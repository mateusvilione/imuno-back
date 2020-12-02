package br.com.imuno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.imuno.dto.LoteDTO;
import br.com.imuno.model.Lote;

@Repository
public interface LoteRepository extends JpaRepository<Lote,Long>{

	@Query("from Lote AS l where l.vacina.id = :vacinaId")
	List<Lote> findByVacinaId(Long vacinaId);

}
