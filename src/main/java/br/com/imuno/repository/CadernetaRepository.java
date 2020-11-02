package br.com.imuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Caderneta;

@Repository
public interface CadernetaRepository extends JpaRepository<Caderneta,Long>{

}
