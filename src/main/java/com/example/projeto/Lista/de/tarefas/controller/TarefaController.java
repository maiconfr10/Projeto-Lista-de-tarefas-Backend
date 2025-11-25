package com.example.projeto.Lista.de.tarefas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.Lista.de.tarefas.entitie.Tarefa;
import com.example.projeto.Lista.de.tarefas.service.ListaDeTarefaService;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*") // <--- LIBERAR O FRONT
public class TarefaController {

    @Autowired
    private ListaDeTarefaService service;

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTarefas();
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return service.atualizarTarefa(id, tarefa);
    }

    @PostMapping
    public Tarefa cadastrar(@RequestBody Tarefa tarefa) {
        return service.cadastrarTarefa(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.apagarTarefa(id);
    }
}
