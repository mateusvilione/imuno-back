package br.com.imuno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.imuno.dto.FuncionarioDTO;
import br.com.imuno.exception.FuncionarioNaoEncontradoException;
import br.com.imuno.mapper.FuncionarioMapper;
import br.com.imuno.model.Funcionario;
import br.com.imuno.repository.FuncionarioRepository;
import br.com.imuno.request.FuncionarioRequest;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private FuncionarioMapper mapper;
	
	@Transactional
	public FuncionarioDTO salvar(FuncionarioRequest funcionarioRequest) {
		Funcionario funcionario = mapper.requestToModel(funcionarioRequest);
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
