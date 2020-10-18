package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.AdministradorDTO;
import br.com.imuno.model.Administrador;
import br.com.imuno.request.AdministradorRequest;

@Component
public class AdministradorMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Administrador requestToModel(AdministradorRequest administradorRequest) {
		return modelMapper.map(administradorRequest, Administrador.class);
	}
	
	public AdministradorDTO modelToDTO(Administrador administrador) {
		return modelMapper.map(administrador, AdministradorDTO.class);
	}
	
}
