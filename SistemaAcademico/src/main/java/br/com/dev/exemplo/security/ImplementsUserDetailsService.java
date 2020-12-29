package br.com.dev.exemplo.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import br.com.dev.exemplo.model.Usuario;
import br.com.dev.exemplo.repository.UsuarioRepository;
@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);
		if(usuario ==null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
}
