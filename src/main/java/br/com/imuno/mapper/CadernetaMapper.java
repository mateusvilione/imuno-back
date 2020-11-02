package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.CadernetaDTO;
import br.com.imuno.model.Caderneta;
import br.com.imuno.request.CadernetaRequest;

@Component
public class CadernetaMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Caderneta requestToModel(CadernetaRequest cadernetaRequest) {
		return modelMapper.map(cadernetaRequest, Caderneta.class);
	}
	
	public CadernetaDTO modelToDTO(Caderneta caderneta) {
		return modelMapper.map(caderneta, CadernetaDTO.class);
	}
}
