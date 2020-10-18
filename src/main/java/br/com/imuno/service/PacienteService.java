package br.com.imuno.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.imuno.dto.PacienteDTO;
import br.com.imuno.exception.PacienteNaoEncontradoException;
import br.com.imuno.mapper.PacienteMapper;
import br.com.imuno.model.Paciente;
import br.com.imuno.repository.PacienteRepository;
import br.com.imuno.request.PacienteRequest;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository _repository;
	@Autowired
	private PacienteMapper _mapper;

	@Transactional
	public PacienteDTO salvar(PacienteRequest pacienteRequest) {

		Paciente paciente = _mapper.requestToModel(pacienteRequest);
		paciente.setDataNascimento(LocalDate.now());

		/*
		 * if(paciente.getEndereco().getCidade().getId() == null) {
		 * estadoRepository.save(cliente.getEndereco().getCidade().getEstado());
		 * cidadeRepository.save(cliente.getEndereco().getCidade()); }
		 */
		/*
		 * paciente.getTelefones().stream(). forEach(telefone ->
		 * telefone.setCliente(cliente));
		 */
		return _mapper.modelToDTO(_repository.save(paciente));
	}

	@Transactional
	public void atualizar(Paciente paciente) {
		/*
		 * cliente.getTelefones().stream(). forEach(telefone ->
		 * telefone.setCliente(cliente));
		 */
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

	/*
	 * public List<Telefone> buscarTelefones(Long id) { return
	 * repository.buscarTelefonesPorId(id); }
	 */
	/*
	 * public List<PacienteDTO> listar() {
	 * 
	 * return _repository.findAll() .stream() .map(cli -> mapper.modelToDTO(cli))
	 * .collect(Collectors.toList()); }
	 * 
	 * public List<ClienteResumoDTO> listarResumo() {
	 * 
	 * List<Cliente> clientes = repository.findAll();
	 * 
	 * return clientes .stream() .map(cli -> mapper.modelToDtoResumo(cli))
	 * .collect(Collectors.toList());
	 * 
	 * }
	 */
}
