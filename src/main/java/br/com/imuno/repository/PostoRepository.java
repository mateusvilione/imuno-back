package br.com.imuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Posto;

@Repository
public interface PostoRepository extends JpaRepository<Posto,Long> {

}
