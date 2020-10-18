package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.PostoDTO;
import br.com.imuno.model.Posto;
import br.com.imuno.request.PostoRequest;

@Component
public class PostoMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	public Posto requestToModel(PostoRequest postoRequest) {
		return modelMapper.map(postoRequest, Posto.class);
	}
	
	public PostoDTO modelToDTO(Posto posto) {
		return modelMapper.map(posto, PostoDTO.class);
	}
}
