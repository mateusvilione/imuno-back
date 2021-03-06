package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.LoteDTO;
import br.com.imuno.model.Lote;
import br.com.imuno.request.LoteRequest;

@Component
public class LoteMapper {
	@Autowired
	private ModelMapper modelMapper;

	public Lote requestToModel(LoteRequest loteRequest) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.getConfiguration().setFieldMatchingEnabled(true);
		return modelMapper.map(loteRequest, Lote.class);
	}

	public LoteDTO modelToDTO(Lote lote) {
		return modelMapper.map(lote, LoteDTO.class);
	}
}
