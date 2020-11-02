package br.com.imuno.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.imuno.dto.DoseDTO;
import br.com.imuno.exception.DoseNaoEncontradoException;
import br.com.imuno.mapper.DoseMapper;
import br.com.imuno.model.Dose;
import br.com.imuno.repository.DoseRepository;
import br.com.imuno.request.DoseRequest;

@Service
public class DoseService {

	@Autowired
	private DoseRepository repository;
	@Autowired
	private DoseMapper mapper;

	@Transactional
	public DoseDTO salvar(DoseRequest doseRequest) {

		Dose dose = mapper.requestToModel(doseRequest);
		return mapper.modelToDTO(repository.save(dose));
	}

	@Transactional
	public void atualizar(Dose dose) {
		repository.save(dose);
	}

	public Optional<Dose> buscar(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public void excluir(Long id) {
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new DoseNaoEncontradoException(id);
		}
	}

	public List<DoseDTO> listar() {

		return repository.findAll().stream().map(dose -> mapper.modelToDTO(dose)).collect(Collectors.toList());
	}

}
