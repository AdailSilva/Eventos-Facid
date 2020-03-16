package com.adailsilva.eventosfacid.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author AdailSilva
 */

// tabela do banco de dados (entidade)
@Entity
public class Convidado {

	// parâmetros
	@Id
	@NotEmpty
	private String rg;

	@NotEmpty
	private String nomeConvidado;

	// montando relacionamento entre tabelas (convidado <-> evento)
	@ManyToOne // muitos convidados para um evento
	private Evento evento;

	// métodos Getters and Setters
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
