package br.com.imuno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.imuno.dto.VacinaDTO;
import br.com.imuno.exception.VacinaNaoEncontradoException;
import br.com.imuno.mapper.VacinaMapper;
import br.com.imuno.model.Vacina;
import br.com.imuno.repository.VacinaRepository;
import br.com.imuno.request.VacinaRequest;

@Service
public class VacinaService {
	@Autowired
	private VacinaRepository repository;

	@Autowired
	private VacinaMapper mapper;

	@Transactional
	public VacinaDTO salvar(VacinaRequest vacinaRequest) {
		Vacina vacina = mapper.requestToModel(vacinaRequest);
		return mapper.modelToDTO(repository.save(vacina));
	}

	@Transactional
	public void atualizar(Vacina vacina) {
		repository.save(vacina);
	}

	public Optional<Vacina> buscar(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new VacinaNaoEncontradoException((Long) id);
		}
	}

	public List<VacinaDTO> listar() {

		return repository.findAll().stream().map(admin -> mapper.modelToDTO(admin)).collect(Collectors.toList());
	}

}
