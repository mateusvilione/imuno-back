package br.com.imuno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.imuno.dto.AdministradorDTO;
import br.com.imuno.exception.AdministradorNaoEncontradoException;
import br.com.imuno.mapper.AdministradorMapper;
import br.com.imuno.model.Administrador;
import br.com.imuno.repository.AdministradorRepository;
import br.com.imuno.request.AdministradorRequest;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repository;
	
	@Autowired
	private AdministradorMapper mapper;
	
	@Transactional
	public AdministradorDTO salvar(AdministradorRequest administradorRequest) {
		Administrador administrador = mapper.requestToModel(administradorRequest);
		return mapper.modelToDTO(repository.save(administrador));
	}
	
	@Transactional
	public void atualizar (Administrador administrador) {
		repository.save(administrador);
	}
	
	public Optional<Administrador> buscar(Long id) {
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
	
	public List<AdministradorDTO> listar() {
		return repository.findAll()
				.stream()
				.map(admin -> mapper.modelToDTO(admin))
				.collect(Collectors.toList());
	}
	
}
