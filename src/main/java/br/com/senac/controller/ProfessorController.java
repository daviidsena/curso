package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/")
	public ModelAndView listaTodosProfessors() {
		ModelAndView mv = new ModelAndView("professor/listar");
		mv.addObject("professores", professorService.obterProfessores());
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirProfessor(@PathVariable("id") Integer id) {
		professorService.deletarPorId(id);
		return "redirect:/professor/";
	}
	
	@GetMapping("/cadastrar/")
	public ModelAndView cadastrarProfessor() {
		ModelAndView mv = new ModelAndView("professor/cadastrar");
		mv.addObject("professor", new Professor());
		mv.addObject("title", "Cadastrar Professor");
		return mv;
	}
	
	@PostMapping("/cadastrar/")
	public String cadastrarProfessorPost(Professor professor) {
		professorService.salvar(professor);
		return "redirect:/professor/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("professor/cadastrar");
		mv.addObject("professor", professorService.buscarPorId(id));
		mv.addObject("title", "Editar Professor");
		return mv;
	}
}	
