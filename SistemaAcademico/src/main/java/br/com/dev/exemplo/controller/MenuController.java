package br.com.dev.exemplo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

import br.com.dev.exemplo.model.Aluno;
import br.com.dev.exemplo.model.Role;
import br.com.dev.exemplo.model.Usuario;
import br.com.dev.exemplo.repository.AlunoRepository;
import br.com.dev.exemplo.repository.UsuarioRepository;


@Controller
public class MenuController {
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired 
	private UsuarioRepository usuarioRepository;
	@GetMapping(path = "/menuInicial")
	public ModelAndView menuInicial() {
		UsuarioController uc = new UsuarioController();
		Usuario usuario = usuarioRepository.findByLogin(uc.getUsuario().getLogin());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/menuView/menuInicial");
		for (Role role : usuario.getRoles()) {
			System.out.println(role.getNomeRole());
			if(role.getNomeRole().equalsIgnoreCase("ROLE_ADMIN"))
			{
				
				Aluno aluno = alunoRepository.findByUsuario(usuario);
				System.out.println(aluno.getNome());
				mv.addObject(aluno);
				mv.addObject(role);
			}
			if(role.getNomeRole().equalsIgnoreCase("ROLE_ALUNO"))
			{
				
				Aluno aluno = alunoRepository.findByUsuario(usuario);
				System.out.println(aluno.getNome());
				mv.addObject(aluno);
				mv.addObject(role);
			}
		}
		//String usuario = uc.getUsuario().getLogin();
		//Aluno aluno = alunoRepository.findByUsuario(uc.getUsuario());
		//Usuario usu = uc.getUsuario();
		//System.out.println(aluno.getNome());
		//System.out.println(usuario);
		
		
		//mv.addObject(aluno);
		return mv;

	}
	@GetMapping("/alunoMenu")
	public ModelAndView menuAluno() {
		UsuarioController uc = new UsuarioController();
		Usuario usuario = uc.getUsuario();
		//Aluno aluno = alunoRepository.findByUsuario(usuario);
		//System.out.println(aluno.getNome());
		return null;
	}
	@GetMapping(path = "/")
	public String index() {
		return "index";

	}

}
