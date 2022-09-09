package br.com.senac.inicializacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Faker faker = new Faker();
		
		for (int i = 0; i < 10; i++) {
			alunoService.salvar(new Aluno(faker.name().firstName()));
			turmaService.salvar(new Turma(faker.code().asin()));
			cursoService.salvar(new Curso(faker.name().firstName()));
			professorService.salvar(new Professor(faker.name().firstName()));
		}
	}
}