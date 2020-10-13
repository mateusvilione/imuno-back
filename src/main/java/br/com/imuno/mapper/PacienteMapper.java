package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.PacienteDTO;
import br.com.imuno.model.Paciente;
import br.com.imuno.request.PacienteRequest;

@Component
public class PacienteMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Paciente requestToModel(PacienteRequest pacienteRequest) {
		return modelMapper.map(pacienteRequest, Paciente.class);
	}
	
	public PacienteDTO modelToDTO(Paciente paciente) {
		return modelMapper.map(paciente, PacienteDTO.class);
	}
	
}
