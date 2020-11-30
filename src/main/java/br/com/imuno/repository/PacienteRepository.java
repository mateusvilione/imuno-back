package br.com.imuno.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
	Optional<Paciente> findByCpfRne(String cpfRne);
}
