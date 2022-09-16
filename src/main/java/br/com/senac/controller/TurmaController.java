package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@GetMapping("/")
	public ModelAndView listaTodosTurmas() {
		ModelAndView mv = new ModelAndView("turma/listar");
		mv.addObject("turmas", turmaService.obterTurmas());
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String excluirTurma(@PathVariable("id") Integer id) {
		turmaService.deletarPorId(id);
		return "redirect:/turma/";
	}

	@GetMapping("/cadastrar/")
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastrar");
		mv.addObject("turma", new Turma());
		mv.addObject("title", "Cadastrar Turma");
		return mv;
	}

	@PostMapping("/cadastrar/")
	public String cadastrarTurmaPost(Turma turma) {
		turmaService.salvar(turma);
		return "redirect:/turma/";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("turma/cadastrar");
		mv.addObject("turma", turmaService.buscarPorId(id));
		mv.addObject("title", "Editar Turma");
		return mv;
	}
}