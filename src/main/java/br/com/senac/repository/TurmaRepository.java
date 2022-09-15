package br.com.senac.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.senac.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
