package br.com.imuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

}
