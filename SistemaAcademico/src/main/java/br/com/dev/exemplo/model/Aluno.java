package br.com.dev.exemplo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long idAluno;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "idade")
	private int idade;
	@ManyToOne
	private Turma turma;
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno() {
		super();
	}

	public Aluno(String nome, String email, int idade) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}

	public Long getId() {
		return idAluno;
	}

	public void setId(Long id) {
		this.idAluno = id;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
