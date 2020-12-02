package br.com.imuno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.imuno.dto.LoteDTO;
import br.com.imuno.exception.LoteNaoEncontradoException;
import br.com.imuno.mapper.LoteMapper;
import br.com.imuno.model.Lote;
import br.com.imuno.repository.LoteRepository;
import br.com.imuno.request.LoteRequest;

@Service
public class LoteService {
	
	@Autowired
	private LoteRepository repository;
	@Autowired
	private LoteMapper mapper;

	@Transactional
	public LoteDTO salvar(LoteRequest loteRequest) {
		Lote lote = mapper.requestToModel(loteRequest);
		return mapper.modelToDTO(repository.save(lote));
	}

	@Transactional
	public void atualizar(Lote lote) {
		repository.save(lote);
	}

	public Optional<Lote> buscar(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new LoteNaoEncontradoException(id);
		}
		;
	}

	public List<LoteDTO> listar() {

		return repository.findAll().stream().map(lote -> mapper.modelToDTO(lote)).collect(Collectors.toList());
	}

	public List<Lote> buscarLotePelaVacina(Long vacinaId) {
		return repository.findByVacinaId(vacinaId);
	}

}
