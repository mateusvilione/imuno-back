package br.com.imuno.service;

import java.time.LocalDate;
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

import br.com.imuno.dto.PacienteDTO;
import br.com.imuno.exception.PacienteNaoEncontradoException;
import br.com.imuno.mapper.PacienteMapper;
import br.com.imuno.model.Grupo;
import br.com.imuno.model.Paciente;
import br.com.imuno.model.Usuario;
import br.com.imuno.repository.GrupoRepository;
import br.com.imuno.repository.PacienteRepository;
import br.com.imuno.repository.UsuarioRepository;
import br.com.imuno.request.PacienteRequest;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository _repository;
	@Autowired
	private GrupoRepository _grupoRepository;
	@Autowired
	private UsuarioRepository _usuarioRepository;
	@Autowired
	private PacienteMapper _mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@SuppressWarnings("unchecked")
	@Transactional
	public PacienteDTO salvar(PacienteRequest pacienteRequest) {
		Usuario usuario = new Usuario();
		
		Grupo grupo = new Grupo();
		grupo = _grupoRepository.findById((long)3).get();		

		Set<Grupo> listaGrupo = Set.copyOf(Arrays.asList(grupo));
		
		usuario.setGrupos(listaGrupo);
		usuario.setEmail(pacienteRequest.getEmail());
		usuario.setNome(pacienteRequest.getNome());
		usuario.setSenha(passwordEncoder.encode(pacienteRequest.getSenha()));
		
		_usuarioRepository.save(usuario);
		
		Paciente paciente = _mapper.requestToModel(pacienteRequest);
		paciente.setDataNascimento(LocalDate.now());
		paciente.setSenha(passwordEncoder.encode(pacienteRequest.getSenha()));
		
		
		return _mapper.modelToDTO(_repository.save(paciente));
	}

	@Transactional
	public void atualizar(Paciente paciente) {
		_repository.save(paciente);
	}

	public Optional<Paciente> buscar(Long id) {
		return _repository.findById(id);
	}

	@Transactional
	public void excluir(Long id) {

		try {
			_repository.deleteById(id);
			_repository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new PacienteNaoEncontradoException(id);
		}
		;
	}

	public List<PacienteDTO> listar() {
		return _repository.findAll().stream().map(pac -> _mapper.modelToDTO(pac)).collect(Collectors.toList());
	}

}
