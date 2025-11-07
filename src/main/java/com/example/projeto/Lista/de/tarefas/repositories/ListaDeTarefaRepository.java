package com.example.projeto.Lista.de.tarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projeto.Lista.de.tarefas.entitie.Tarefa;

@Repository
public interface ListaDeTarefaRepository extends JpaRepository<Tarefa, Long> {

}
