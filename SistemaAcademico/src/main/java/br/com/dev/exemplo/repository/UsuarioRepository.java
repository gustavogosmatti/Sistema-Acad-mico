package br.com.dev.exemplo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.exemplo.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	Usuario findByLogin(String login);

}
