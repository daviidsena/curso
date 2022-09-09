package br.com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("/listar")
	public ModelAndView listaTodosTurmas() {
		ModelAndView mv = new ModelAndView("turma/listar");
		mv.addObject("turmas", turmaService.obterTurmas());
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluirTurma(@PathVariable("id") Integer id) {
		turmaService.deletarPorId(id);
		return "redirect:/turma/listar";
	}
}	