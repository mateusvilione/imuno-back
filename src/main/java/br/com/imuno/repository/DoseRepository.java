package br.com.imuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Dose;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Long>{

}
