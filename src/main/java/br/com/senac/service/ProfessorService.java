package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public List<Professor> obterProfessores(){
		return professorRepository.findAll();
	}
	
	public Professor buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Professor> professor = professorRepository.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException(1L, "Professor não encontrado"));
	}
	
	public void deletarPorId(Integer id) {
		professorRepository.deleteById(id);
    }
}