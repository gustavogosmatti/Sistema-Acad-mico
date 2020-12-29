package br.com.dev.exemplo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.dev.exemplo.model.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

}
