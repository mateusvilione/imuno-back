package br.com.imuno.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imuno.dto.FuncionarioDTO;
import br.com.imuno.model.Funcionario;
import br.com.imuno.request.FuncionarioRequest;

@Component
public class FuncionarioMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Funcionario requestToModel(FuncionarioRequest funcionarioRequest) {
		return modelMapper.map(funcionarioRequest, Funcionario.class);
	}
	
	public FuncionarioDTO modelToDTO(Funcionario funcionario) {
		return modelMapper.map(funcionario, FuncionarioDTO.class);
	}
	
	

}
