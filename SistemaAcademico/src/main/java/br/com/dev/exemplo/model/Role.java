package br.com.dev.exemplo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
@Entity
public class Role implements GrantedAuthority{
	@Id
	private String nomeRole;
	public String getNomeRole() {
		return nomeRole;
	}
	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}
	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

}
