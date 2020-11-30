package br.com.imuno.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Posto;

@Repository
public interface PostoRepository extends JpaRepository<Posto, Long> {

	@Query("from Posto AS p where p.administrador.id = :administradorId")
	Optional<Posto> findByAdministradorId(Long administradorId);
}
