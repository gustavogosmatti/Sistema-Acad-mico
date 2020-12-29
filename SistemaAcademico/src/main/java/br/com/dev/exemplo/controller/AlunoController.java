package br.com.dev.exemplo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.dev.exemplo.model.Aluno;
import br.com.dev.exemplo.model.Role;
import br.com.dev.exemplo.model.Turma;
import br.com.dev.exemplo.model.Usuario;
import br.com.dev.exemplo.repository.AlunoRepository;
import br.com.dev.exemplo.repository.RoleRepository;
import br.com.dev.exemplo.repository.TurmaRepository;
import br.com.dev.exemplo.repository.UsuarioRepository;

@Controller
public class AlunoController {
	@Autowired 
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired 
	private TurmaRepository turmaRepository;
	@Autowired 
	private RoleRepository roleRepository;
	

	@GetMapping(path = "/alunoTeste")
	public String mensagem() {
		return "AlunoTeste";
	}

	@GetMapping("/aluno")
	public ModelAndView getAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunoView/cadastroAluno");
		Iterable<Turma> turma = turmaRepository.findAll();
		Iterable<Role> role = roleRepository.findAll();
		mv.addObject("turma", turma);
		mv.addObject("roles",role);
		return mv;
	}

	@PostMapping("/cadastrarAluno")
	public String cadastrarAluno(Aluno aluno, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "alunoView/cadastroAluno";
		}
		String senha = new BCryptPasswordEncoder().encode(aluno.getUsuario().getSenha());
		aluno.getUsuario().setSenha(senha);
		
		
		System.out.println(aluno.getUsuario().getUsername());
		aluno.getUsuario().setAlunos(new ArrayList<Aluno>());
		aluno.getUsuario().getAlunos().add(aluno);
		aluno.getUsuario().setRoles(new ArrayList<Role>());
		aluno.getUsuario().getRoles().add(aluno.getRole());
		alunoRepository.save(aluno);
		
		return "index";
	}

	@RequestMapping("/listarAlunos")
	public String listarAlunos(Model model) {
		model.addAttribute("alunos", alunoRepository.findAll());
		return "alunoView/listarAlunos";
	}

	@GetMapping("/editarAluno/{id}")
	public ModelAndView editarAluno(@PathVariable("id") Long idAluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunoView/editarAluno");
		Optional<Aluno> aluno = alunoRepository.findById(idAluno);
		Iterable<Turma> turma = turmaRepository.findAll();
		Iterable<Role> role = roleRepository.findAll();
		mv.addObject("roles",role);
		mv.addObject("turma", turma);
		mv.addObject(aluno.get());
		return mv;
	}

	@PostMapping("/salvarEdicaoAluno")
	public ModelAndView salvarEdicaoAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		String senha = new BCryptPasswordEncoder().encode(aluno.getUsuario().getSenha());
		aluno.getUsuario().setSenha(senha);
		aluno.getUsuario().setRoles(new ArrayList<Role>());
		aluno.getUsuario().getRoles().add(aluno.getRole());
		alunoRepository.save(aluno);
		mv.setViewName("redirect:/listarAlunos");
		return mv;
	}
	@RequestMapping("/excluirAluno/{id}")
	public String excluirAluno(@PathVariable long id) {
		alunoRepository.deleteById(id);
		return "redirect:/listarAlunos";
	}
	@GetMapping("/aluno/listarDadosAluno/{id}")
	public ModelAndView listarDadosAlunoPorId(@PathVariable("id") Long idAluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alunoView/listarDadosAluno");
		Optional<Aluno> aluno = alunoRepository.findById(idAluno);
		mv.addObject(aluno.get());
		return mv;
	}
}
