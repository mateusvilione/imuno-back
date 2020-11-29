package br.com.imuno.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Caderneta;

@Repository
public interface CadernetaRepository extends JpaRepository<Caderneta,Long>{
	
	@Query("from Caderneta AS c where c.paciente.id = :pacienteId")
	List<Caderneta> findByPaciente(Long pacienteId);
}
