package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public List<Curso> obterCursos(){
		return cursoRepository.findAll();
	}
	
	public Curso buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException(1L, "Curso não encontrado"));
	}
	
	public void deletarPorId(Integer id) {
		cursoRepository.deleteById(id);
    }
}