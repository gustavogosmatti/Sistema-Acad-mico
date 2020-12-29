package br.com.dev.exemplo.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
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
import br.com.dev.exemplo.model.Disciplina;
import br.com.dev.exemplo.model.Docente;
import br.com.dev.exemplo.model.Turma;
import br.com.dev.exemplo.repository.AlunoRepository;
import br.com.dev.exemplo.repository.DisciplinaRepository;
import br.com.dev.exemplo.repository.DocenteRepository;
import br.com.dev.exemplo.repository.TurmaRepository;

@Controller
public class TurmaController {
	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private DocenteRepository docenteRepository;
	@GetMapping(path = "/turmaTeste")
	public String mensagem() {
		return "turmaTeste";
	}

	@GetMapping("/turma")
	public ModelAndView getTurma(Turma turma) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("turmaView/cadastroTurma");
		Iterable<Disciplina> disciplina = disciplinaRepository.findAll();
		mv.addObject("disciplina", disciplina);
		Iterable<Docente> docente = docenteRepository.findAll();
		mv.addObject("docente", docente);
		return mv;
	}

	@PostMapping("/cadastrarTurma")
	public String cadastrarTurma(Turma turma, BindingResult result, Model model) throws SQLIntegrityConstraintViolationException {
		if (result.hasErrors()) {
			return "turmaView/cadastroTurma";
		}
		try {
			if(turma.getDisciplina()== null)
			{
				turma.setDisciplina(new Disciplina());
				System.out.println("passei aki");
			}
			turmaRepository.save(turma);
			Docente docente = turma.getDocente();
			docente.getTurma().add(turma);
			docenteRepository.save(docente);
		} catch (Exception e) {
			System.out.println("DEU ERRO");
			
			return "redirect:/listarDisciplinas";
		}
		
		
		return "index";
	}
	@RequestMapping("/listarTurmas")
	public String listarDisciplinas(Model model) {
		model.addAttribute("turmas", turmaRepository.findAll());
		return "turmaView/listarTurmas";
	}
	@GetMapping("/editarTurma/{id}")
	public ModelAndView editarTurma(@PathVariable("id") Long idTurma) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("turmaView/editarTurma");
		Optional<Turma> turma = turmaRepository.findById(idTurma);
		Iterable<Disciplina> disciplina = disciplinaRepository.findAll();
		mv.addObject("disciplina", disciplina);
		Iterable<Docente> docente = docenteRepository.findAll();
		mv.addObject("docente",docente);
		mv.addObject("turma", turma);
		
		return mv;
	}

	@PostMapping("/salvarEdicaoTurma")
	public ModelAndView salvarEdicaoTurma(Turma turma) {
		ModelAndView mv = new ModelAndView();
		turmaRepository.save(turma);
		mv.setViewName("redirect:/listarTurmas");
		return mv;
	}
	@RequestMapping("/excluirTurma/{id}")
	public String excluirTurma(@PathVariable long id) {
		turmaRepository.deleteById(id);
		return "redirect:/listarTurmas";
	}
	@GetMapping("/turmas/listarAlunosTurma/{id}")
	public ModelAndView listarAlunosTurma(@PathVariable("id") long id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("turmaView/listarAlunosTurma");
		mv.addObject("turma", turma);
		Iterable<Aluno> alunos = alunoRepository.findByTurma(turma);
		mv.addObject("alunos", alunos);
		return mv;
		
	}
}
