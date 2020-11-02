package br.com.imuno.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.imuno.dto.AdministradorDTO;
import br.com.imuno.dto.CadernetaDTO;
import br.com.imuno.exception.AdministradorNaoEncontradoException;
import br.com.imuno.mapper.AdministradorMapper;
import br.com.imuno.mapper.CadernetaMapper;
import br.com.imuno.model.Administrador;
import br.com.imuno.model.Caderneta;
import br.com.imuno.model.Grupo;
import br.com.imuno.model.Usuario;
import br.com.imuno.repository.CadernetaRepository;
import br.com.imuno.request.AdministradorRequest;
import br.com.imuno.request.CadernetaRequest;

@Service
public class CadernetaService {
	@Autowired
	private CadernetaMapper mapper;
	
	@Autowired
	private CadernetaRepository repository;
	
	@Transactional
	public CadernetaDTO salvar(CadernetaRequest cadernetaRequest) {
		
		Caderneta caderneta = mapper.requestToModel(cadernetaRequest);
		return mapper.modelToDTO(repository.save(caderneta));
	}
	
	@Transactional
	public void atualizar (Caderneta caderneta) {
		repository.save(caderneta);
	}
	
	public Optional<Caderneta> buscar(Long id) {
		return repository.findById(id);
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch(EmptyResultDataAccessException e) {
			throw new AdministradorNaoEncontradoException(id);
		};
	}
	
	public List<CadernetaDTO> listar() {

		return repository.findAll()
				.stream()
				.map(cad -> mapper.modelToDTO(cad))
				.collect(Collectors.toList());
	}
	
}
