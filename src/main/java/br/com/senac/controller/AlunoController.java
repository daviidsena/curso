package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/")
	public ModelAndView listaTodosAlunos() {
		ModelAndView mv = new ModelAndView("aluno/listar");
		mv.addObject("alunos", alunoService.obterAlunos());
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String excluirAluno(@PathVariable("id") Integer id) {
		alunoService.deletarPorId(id);
		return "redirect:/aluno/";
	}

	@GetMapping("/cadastrar/")
	public ModelAndView cadastrarAluno() {
		ModelAndView mv = new ModelAndView("aluno/cadastrar");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("/cadastrar/")
	public String cadastrarAlunoPost(Aluno aluno) {
		alunoService.salvar(aluno);
		return "redirect:/aluno/";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("aluno/cadastrar");
		mv.addObject("aluno", alunoService.buscarPorId(id));
		return mv;
	}
}
