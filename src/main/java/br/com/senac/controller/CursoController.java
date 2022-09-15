package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.service.CursoService;

@Controller
@RequestMapping("curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/listar")
	public ModelAndView listaTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/listar");
		mv.addObject("cursos", cursoService.obterCursos());
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirCurso(@PathVariable("id") Integer id) {
		cursoService.deletarPorId(id);
		return "redirect:/curso/listar";
	}
}	
