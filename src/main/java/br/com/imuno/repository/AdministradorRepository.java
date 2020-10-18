package br.com.imuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imuno.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador,Long>  {

}
