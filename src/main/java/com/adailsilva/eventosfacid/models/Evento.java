package com.adailsilva.eventosfacid.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author AdailSilva
 */

// tabela do banco de dados (entidade)
@Entity
public class Evento implements Serializable {
	// implementar Serialazible
	// último passo para ser possível a geração do id automaticamente
	private static final long serialVersionUID = 1L;

	// parâmetros
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // gerar o id automaticamente e autoincrementar o mesmo
	private long codigo;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String local;

	@NotEmpty
	private String data;

	@NotEmpty
	private String horario;

	/**
	 * Construtor protegido padrão
	 */
	protected Evento() {
	}

	/**
	 * Construtor do evento com nome, local, data e horário
	 * 
	 * @param nome
	 * @param local
	 * @param data
	 * @param horario
	 */
	public Evento(final String nome, final String local, final String data, final String horario) {
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
	}

	// montando relacionamento entre tabelas (evento <-> convidado)
	@OneToMany // um evento para muitos convidados // não precisei gerar Getter and Setter
				// deste parâmetro
	private List<Convidado> convidado;

	// métodos Getters and Setters
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", nome=" + nome + ", local=" + local + ", data=" + data + ", horario="
				+ horario + ", convidado=" + convidado + "]";
	}

}
