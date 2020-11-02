package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.VacinaDTO;
import br.com.imuno.model.Vacina;
import br.com.imuno.request.VacinaRequest;

@Component
public class VacinaMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	public Vacina requestToModel(VacinaRequest vacinaRequest) {
		return modelMapper.map(vacinaRequest, Vacina.class);
	}
	
	public VacinaDTO modelToDTO(Vacina vacina) {
		return modelMapper.map(vacina, VacinaDTO.class);
	}
}
