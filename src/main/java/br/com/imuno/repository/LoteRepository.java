package br.com.imuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Lote;

@Repository
public interface LoteRepository extends JpaRepository<Lote,Long>{

}
