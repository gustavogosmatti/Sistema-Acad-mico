package br.com.dev.exemplo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.exemplo.model.Docente;
import br.com.dev.exemplo.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Long> {

	Iterable<Turma> findByDocente(Optional<Docente> docente);

}
