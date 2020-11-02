package br.com.imuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina,Long> {

}
