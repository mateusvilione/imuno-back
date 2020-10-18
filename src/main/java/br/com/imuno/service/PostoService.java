package br.com.imuno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.imuno.dto.PostoDTO;
import br.com.imuno.exception.PostoNaoEncontradoException;
import br.com.imuno.mapper.PostoMapper;
import br.com.imuno.model.Posto;
import br.com.imuno.repository.PostoRepository;
import br.com.imuno.request.PostoRequest;

@Service
public class PostoService {

	@Autowired
	private PostoRepository repository;
	
	@Autowired
	private PostoMapper mapper;
	
	@Transactional
	public PostoDTO salvar(PostoRequest postoRequest) {
		Posto posto = mapper.requestToModel(postoRequest);
		return mapper.modelToDTO(repository.save(posto));
	}
	
	@Transactional
	public void atualizar (Posto posto) {
		repository.save(posto);
	}
	
	public Optional<Posto> buscar(Long id) {
		return repository.findById(id);
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch(EmptyResultDataAccessException e) {
			throw new PostoNaoEncontradoException(id);
		};
	}
	
	public List<PostoDTO> listar() {
		return repository.findAll()
				.stream()
				.map(p -> mapper.modelToDTO(p))
				.collect(Collectors.toList());
	}
	
}
