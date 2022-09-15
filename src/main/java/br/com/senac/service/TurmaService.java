package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public Turma salvar(Turma turma) {
		return turmaRepository.save(turma);
	}

	public List<Turma> obterTurmas() {
		return turmaRepository.findAll();
	}

	public Turma buscarPorId(Integer id) throws ObjectNotFoundException {
		Optional<Turma> turma = turmaRepository.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(1L, "Turma não encontrado"));
	}

	public void deletarPorId(Integer id) {
		turmaRepository.deleteById(id);
	}
}