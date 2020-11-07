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

import br.com.imuno.dto.FuncionarioDTO;
import br.com.imuno.exception.FuncionarioNaoEncontradoException;
import br.com.imuno.mapper.FuncionarioMapper;
import br.com.imuno.model.Funcionario;
import br.com.imuno.model.Grupo;
import br.com.imuno.model.Usuario;
import br.com.imuno.repository.FuncionarioRepository;
import br.com.imuno.repository.GrupoRepository;
import br.com.imuno.repository.UsuarioRepository;
import br.com.imuno.request.FuncionarioRequest;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	@Autowired
	private GrupoRepository _grupoRepository;
	@Autowired
	private UsuarioRepository _usuarioRepository;
	@Autowired
	private FuncionarioMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public FuncionarioDTO salvar(FuncionarioRequest funcionarioRequest) {
		Usuario usuario = new Usuario();
		
		Grupo grupo = new Grupo();
		grupo = _grupoRepository.findById((long)2).get();		

		Set<Grupo> listaGrupo = Set.copyOf(Arrays.asList(grupo));
		
		usuario.setNome(funcionarioRequest.getNome());
		usuario.setEmail(funcionarioRequest.getEmail());
		usuario.setSenha(passwordEncoder.encode(funcionarioRequest.getSenha()));
		usuario.setGrupos(listaGrupo);
		
		Usuario iduser = _usuarioRepository.save(usuario);
		
		Funcionario funcionario = mapper.requestToModel(funcionarioRequest);
		funcionario.setUsuarioId(iduser.getId());
		funcionario.setSenha(passwordEncoder.encode(funcionarioRequest.getSenha()));
		return mapper.modelToDTO(repository.save(funcionario));
	}
	
	@Transactional
	public void atualizar (Funcionario funcionario) {
		repository.save(funcionario);
	}
	
	public Optional<Funcionario> buscar(Long id) {
		return repository.findById(id);
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch(EmptyResultDataAccessException e) {
			throw new FuncionarioNaoEncontradoException(id);
		};
	}
	
	public List<FuncionarioDTO> listar() {
		return repository.findAll()
				.stream()
				.map(func -> mapper.modelToDTO(func))
				.collect(Collectors.toList());
	}

}
