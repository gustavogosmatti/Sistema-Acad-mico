package br.com.dev.exemplo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="disciplina")
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private Long idDisciplina;
	@Column(name="nome")
	private String nome;
	@Column(name="status")
	private boolean status;
	public List<Turma> getTurma() {
		return turma;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	@OneToMany
	private List<Turma> turma;

	public Disciplina() {

	}

	public Disciplina(String nome) {
		super();
		this.nome = nome;
	}

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long id) {
		this.idDisciplina = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
