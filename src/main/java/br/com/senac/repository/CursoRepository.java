package br.com.senac.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.senac.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}