package br.com.dev.exemplo.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "docente")
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idDocente;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "formacao")
	private String formacao;
	@Column(name = "idade")
	private int idade;
	@OneToMany
	private List<Turma> turma;

	public Long getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(Long idDocente) {
		this.idDocente = idDocente;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public Docente() {

	}

	public Docente(String nome, String email, String formacao, int idade) {
		super();
		this.nome = nome;
		this.email = email;
		this.formacao = formacao;
		this.idade = idade;
	}

	public Long getId() {
		return idDocente;
	}

	public void setId(Long id) {
		this.idDocente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
