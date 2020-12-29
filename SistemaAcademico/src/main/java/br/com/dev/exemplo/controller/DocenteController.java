package br.com.dev.exemplo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dev.exemplo.model.Aluno;
import br.com.dev.exemplo.model.Docente;
import br.com.dev.exemplo.model.Turma;
import br.com.dev.exemplo.repository.AlunoRepository;
import br.com.dev.exemplo.repository.DocenteRepository;
import br.com.dev.exemplo.repository.TurmaRepository;

@Controller
public class DocenteController {
	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@GetMapping(path = "/docenteTeste")
	public String mensagem() {
		return "docenteTeste";
	}

	@GetMapping("/docente")
	public ModelAndView getDocente(Docente docente) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("docenteView/cadastroDocente");
		Iterable<Turma> turma = turmaRepository.findAll();
		mv.addObject("turma", turma);
		
		return mv;
	}

	@PostMapping("/cadastrarDocente")
	public String cadastrarAluno(Docente docente, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "docenteView/cadastroDocente";
		}
		docenteRepository.save(docente);
		return "index";
	}

	@RequestMapping("/listarDocentes")
	public String listarDocentes(Model model) {
		model.addAttribute("docentes", docenteRepository.findAll());
		return "docenteView/listarDocentes";
	}
	@GetMapping("/editarDocente/{id}")
	public ModelAndView editarAluno(@PathVariable("id") Long idDocente) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("docenteView/editarDocente");
		Optional<Docente> docente = docenteRepository.findById(idDocente);
		mv.addObject("docente", docente);
		return mv;
	}

	@PostMapping("/salvarEdicaoDocente")
	public ModelAndView salvarEdicaoDocente(Docente docente) {
		ModelAndView mv = new ModelAndView();
		docenteRepository.save(docente);
		mv.setViewName("redirect:/listarDocentes");
		return mv;
	}
	@RequestMapping("/excluirDocente/{id}")
	public String excluirAluno(@PathVariable long id) {
		docenteRepository.deleteById(id);
		return "redirect:/listarDocentes";
	}
	@GetMapping("/docentes/listarTurmasDocente/{id}")
	public ModelAndView listarTurmasDocente(@PathVariable("id") long id) {
		Optional<Docente> docente = docenteRepository.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("docenteView/listarTurmasDocente");
		Iterable<Turma> turma = turmaRepository.findByDocente(docente);
		mv.addObject("docente",docente);
		mv.addObject("turma",turma);
		
		return mv;
	}
	@GetMapping("/docentes/listarTurmasDocente/listarAlunosTurmaDocente/{id}")
	public ModelAndView listarAlunosTurmaDocente(@PathVariable("id") long id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("docenteView/listarAlunosTurmaDocente");
		Iterable<Aluno> aluno = alunoRepository.findByTurma(turma);
		mv.addObject("aluno",aluno);
		mv.addObject("turma",turma);
		return mv;
	}
}
