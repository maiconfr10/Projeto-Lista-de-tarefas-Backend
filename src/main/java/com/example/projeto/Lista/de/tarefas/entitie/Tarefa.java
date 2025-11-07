package com.example.projeto.Lista.de.tarefas.entitie;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String numeroTarefa;
	private String nomeTarefa;
	private String tipoTarefa;
	private LocalDate dataTarefa;
	private String horarioTarefa;

	public Tarefa(long id, String numeroTarefa, String nomeTarefa, String tipoTarefa, LocalDate dataTarefa,
			String horarioTarefa) {

		this.id = id;
		this.numeroTarefa = numeroTarefa;
		this.nomeTarefa = nomeTarefa;
		this.tipoTarefa = tipoTarefa;
		this.dataTarefa = dataTarefa;
		this.horarioTarefa = horarioTarefa;
	}

	public Tarefa() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroTarefa() {
		return numeroTarefa;
	}

	public void setNumeroTarefa(String numeroTarefa) {
		this.numeroTarefa = numeroTarefa;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(String tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public LocalDate getDataTarefa() {
		return dataTarefa;
	}

	public void setDataTarefa(LocalDate dataTarefa) {
		this.dataTarefa = dataTarefa;
	}

	public String getHorarioTarefa() {
		return horarioTarefa;
	}

	public void setHorarioTarefa(String horarioTarefa) {
		this.horarioTarefa = horarioTarefa;
	}
}
