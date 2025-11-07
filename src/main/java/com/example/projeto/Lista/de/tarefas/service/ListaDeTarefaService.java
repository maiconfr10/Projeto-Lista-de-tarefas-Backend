package com.example.projeto.Lista.de.tarefas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto.Lista.de.tarefas.entitie.Tarefa;
import com.example.projeto.Lista.de.tarefas.repositories.ListaDeTarefaRepository;

@Service
public class ListaDeTarefaService {

	@Autowired
	private ListaDeTarefaRepository repository;

	public List<Tarefa> listarTarefas() {
		return repository.findAll();

	}

	public Tarefa cadastrarTarefa(Tarefa tarefa) {
		return repository.save(tarefa);
	}

	public void apagarTarefa(Long id) {
		repository.deleteById(id);
	}

	public Optional<Tarefa> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public Tarefa atualizarTarefa(Long id, Tarefa novaTarefa) {
		Tarefa tarefaExistente = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tarefa não encontrada com Id" + id));

		tarefaExistente.setNumeroTarefa(novaTarefa.getNumeroTarefa());
		tarefaExistente.setNomeTarefa(novaTarefa.getNomeTarefa());
		tarefaExistente.setTipoTarefa(novaTarefa.getTipoTarefa());
		tarefaExistente.setDataTarefa(novaTarefa.getDataTarefa());
		tarefaExistente.setHorarioTarefa(novaTarefa.getHorarioTarefa());

		return repository.save(tarefaExistente);
	}

}