🧩 Projeto: Lista de Tarefas — Resumo Estruturado e Explicado

🏗️ 1. Entitie (Classe de Modelo / Banco de Dados)
•	Função: Representa uma tabela no banco de dados.

•	Anotação principal: @Entity → indica que essa classe será mapeada no banco.

•	Chave primária: @Id e @GeneratedValue → identificador único (gerado automaticamente).

•	Construtores: um padrão (vazio) e outro com parâmetros.

•	Métodos: get e set → usados para acessar e alterar os atributos.
________________________________________
🗃️ 2. Repository (Camada de Acesso aos Dados)

•	Função: Responsável pela comunicação direta com o banco de dados.

•	Estrutura: é uma interface que herda de JpaRepository.

•	Exemplo:

•	public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}

•	Tipos genéricos: <Tarefa, Long> informam que o repositório trabalha com objetos da classe Tarefa e que o ID é do tipo Long.

•	Função do JpaRepository: fornece automaticamente métodos CRUD como save(), findById(), findAll(), deleteById(), entre outros.
📦 Pense nele como um “gerente de arquivos”, que o Service chama quando precisa acessar ou alterar o banco.
________________________________________
🧠 3. Service (Camada de Regras de Negócio / Intermediária)

•	Função: Faz a ponte entre o Controller e o Repository.

•	Anotação: @Service → define que essa classe contém regras de negócio.

•	Injeção de dependência: @Autowired → injeta automaticamente o Repository.
Métodos principais:

•	listarTarefas() → chama repository.findAll() e retorna todas as tarefas.

•	cadastrarTarefa(Tarefa tarefa) → chama repository.save(tarefa) e salva uma nova tarefa.

•	apagarTarefa(Long id) → chama repository.deleteById(id) e apaga a tarefa correspondente.

•	buscarPorId(Long id) → chama repository.findById(id) e devolve um Optional<Tarefa>.

o	O Optional é uma “caixa de segurança” que evita erro caso o ID não exista.

•	atualizarTarefa(Long id, Tarefa novaTarefa)

o	Busca a tarefa existente (findById(id)).

o	Atualiza os dados com set.

o	Salva as alterações com repository.save().
📍 Pense nele como um “coordenador” que recebe pedidos do Controller e manda o Repository agir.
________________________________________
🌐 4. Controller (Camada de Entrada / API Web)

•	Função: É o “recepcionista” da aplicação, recebe as requisições HTTP (via Postman, navegador, etc.).

•	Anotação principal: @RestController
•	Mapeamento base: @RequestMapping("/tarefas")
•	Injeção de dependência: @Autowired → chama o Service.
Métodos REST:
•	@GetMapping → listar todas as tarefas.
•	public List<Tarefa> listar() {
•	    return service.listarTarefas();
•	}
•	@GetMapping("/{id}") → buscar tarefa por ID.
•	public Optional<Tarefa> buscarPorId(@PathVariable Long id) {
•	    return service.buscarPorId(id);

•	}

O @PathVariable extrai o ID da URL e o envia para o método.

•	@PostMapping → cadastrar nova tarefa.

•	public Tarefa cadastrar(@RequestBody Tarefa tarefa) {

•	    return service.cadastrarTarefa(tarefa);

•	}

O @RequestBody transforma o JSON enviado pelo Postman em um objeto Java.

•	@PutMapping("/{id}") → atualizar uma tarefa existente.

•	public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {

•	    return service.atualizarTarefa(id, tarefa);

•	}

•	@DeleteMapping("/{id}") → deletar tarefa por ID.

•	public void deletar(@PathVariable Long id) {

•	    service.apagarTarefa(id);

•	}

📍 O Controller não fala com o banco diretamente — ele sempre conversa com o Service.
________________________________________
🧭 Fluxo Completo do Projeto
1.	Cliente (Postman ou navegador) → faz uma requisição (GET, POST, PUT, DELETE).
2.	Controller → recebe a requisição e chama o Service.
3.	Service → processa a lógica e conversa com o Repository.
4.	Repository → executa a operação no banco de dados.
5.	Resposta → retorna os dados de volta (na ordem inversa).
💡 É como uma empresa:
•	O cliente faz o pedido → o recepcionista (Controller) anota → o gerente (Service) coordena → o estoquista (Repository) busca no estoque (banco de dados).

