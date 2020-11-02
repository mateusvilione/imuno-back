package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.DoseDTO;
import br.com.imuno.model.Dose;
import br.com.imuno.request.DoseRequest;

@Component
public class DoseMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Dose requestToModel(DoseRequest doseRequest) {
		return modelMapper.map(doseRequest, Dose.class);
	}

	public DoseDTO modelToDTO(Dose dose) {
		return modelMapper.map(dose, DoseDTO.class);
	}
}
