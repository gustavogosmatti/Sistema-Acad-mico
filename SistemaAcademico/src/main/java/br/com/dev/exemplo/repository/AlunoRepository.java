package br.com.dev.exemplo.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.exemplo.model.Aluno;
import br.com.dev.exemplo.model.Turma;
import br.com.dev.exemplo.model.Usuario;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	Iterable<Aluno> findByTurma(Optional<Turma> turma);

	Iterable<Aluno> findByTurmaIn(Iterable<Turma> turma);
	
	Aluno findByUsuario(Usuario usuario);
	//Iterable<Aluno> findByTurmaDocente(Iterable<Turma> turma);

}
