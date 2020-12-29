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
import br.com.dev.exemplo.model.Disciplina;
import br.com.dev.exemplo.repository.DisciplinaRepository;
import br.com.dev.exemplo.repository.TurmaRepository;

@Controller
public class DisciplinaController {
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	@Autowired
	private TurmaRepository turmaRepository;

	@GetMapping(path = "/disciplinaTeste")
	public String mensagem() {
		return "disciplina teste";
	}

	@GetMapping("/disciplina")
	public String getCliente(Disciplina disciplina) {
		return "disciplinaView/cadastroDisciplina";
	}
	
	@PostMapping("/cadastrarDisciplina")
	public String cadastrarAluno(Disciplina disciplina, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "disciplinaView/cadastroDisciplina";
		}
		disciplinaRepository.save(disciplina);
		return "index";
	}
	@RequestMapping("/listarDisciplinas")
	public String listarDisciplinas(Model model) {
		model.addAttribute("disciplinas", disciplinaRepository.findAll());
		return "disciplinaView/listarDisciplinas";
	}
	@GetMapping("/editarDisciplina/{id}")
	public ModelAndView editarDisciplina(@PathVariable("id") Long idDisciplina) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("disciplinaView/editarDisciplina");
		Optional<Disciplina> disciplina = disciplinaRepository.findById(idDisciplina);
		mv.addObject("disciplina", disciplina);
		return mv;
	}

	@PostMapping("/salvarEdicaoDisciplina")
	public ModelAndView salvarEdicaoDisciplina(Disciplina disciplina) {
		ModelAndView mv = new ModelAndView();
		disciplinaRepository.save(disciplina);
		mv.setViewName("redirect:/listarDisciplinas");
		return mv;
	}
	@RequestMapping("/excluirDisciplina/{id}")
	public String excluirDisciplina(@PathVariable long id) {
		disciplinaRepository.findById(id);
		disciplinaRepository.deleteById(id);
		return "redirect:/listarDisciplinas";
	}
}
