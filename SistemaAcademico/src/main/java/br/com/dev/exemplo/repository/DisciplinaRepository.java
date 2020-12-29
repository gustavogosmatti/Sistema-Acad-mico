package br.com.dev.exemplo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.exemplo.model.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {

}
