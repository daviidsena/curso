package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Curso;
import br.com.senac.service.CursoService;

@Controller
@RequestMapping("curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/")
	public ModelAndView listaTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/listar");
		mv.addObject("cursos", cursoService.obterCursos());
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirCurso(@PathVariable("id") Integer id) {
		cursoService.deletarPorId(id);
		return "redirect:/curso/";
	}
	
	@GetMapping("/cadastrar/")
	public ModelAndView cadastrarCurso() {
		ModelAndView mv = new ModelAndView("curso/cadastrar");
		mv.addObject("curso", new Curso());
		mv.addObject("title", "Cadastrar Curso");
		return mv;
	}
	
	@PostMapping("/cadastrar/")
	public String cadastrarCursoPost(Curso curso) {
		cursoService.salvar(curso);
		return "redirect:/curso/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("curso/cadastrar");
		mv.addObject("curso", cursoService.buscarPorId(id));
		mv.addObject("title", "Editar Curso");
		return mv;
	}
}	
