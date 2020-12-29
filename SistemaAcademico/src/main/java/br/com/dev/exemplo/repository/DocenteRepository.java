package br.com.dev.exemplo.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.dev.exemplo.model.Docente;

public interface DocenteRepository extends CrudRepository<Docente, Long> {
	
}
