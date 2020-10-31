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
import br.com.imuno.exception.AdministradorNaoEncontradoException;
import br.com.imuno.mapper.AdministradorMapper;
import br.com.imuno.model.Administrador;
import br.com.imuno.model.Grupo;
import br.com.imuno.model.Usuario;
import br.com.imuno.repository.AdministradorRepository;
import br.com.imuno.repository.GrupoRepository;
import br.com.imuno.repository.UsuarioRepository;
import br.com.imuno.request.AdministradorRequest;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repository;
	@Autowired
	private GrupoRepository _grupoRepository;
	@Autowired
	private UsuarioRepository _usuarioRepository;
	@Autowired
	private AdministradorMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public AdministradorDTO salvar(AdministradorRequest administradorRequest) {
		Usuario usuario = new Usuario();
		
		Grupo grupo = new Grupo();
		grupo = _grupoRepository.findById((long)1).get();		

		Set<Grupo> listaGrupo = Set.copyOf(Arrays.asList(grupo));
		
		usuario.setNome(administradorRequest.getNome());
		usuario.setEmail(administradorRequest.getEmail());
		usuario.setSenha(passwordEncoder.encode(administradorRequest.getSenha()));
		usuario.setGrupos(listaGrupo);
		
		var iduser = _usuarioRepository.save(usuario);
		
		Administrador administrador = mapper.requestToModel(administradorRequest);
		administrador.setUsuarioId(iduser.getId());
		administrador.setSenha(passwordEncoder.encode(administradorRequest.getSenha()));
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
