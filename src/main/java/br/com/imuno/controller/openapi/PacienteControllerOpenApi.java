package br.com.imuno.controller.openapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.com.imuno.dto.PacienteDTO;
import br.com.imuno.exception.config.Problem;
import br.com.imuno.model.Paciente;
import br.com.imuno.request.PacienteRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Paciente")
public interface PacienteControllerOpenApi {
	
	@ApiOperation(httpMethod = "POST", value = "Cadastrar paciente")
	@ApiResponses({ 
		@ApiResponse(code = 201, message = "Paciente cadastrado" ),
		@ApiResponse(code = 204, message = "")
	})
	ResponseEntity<?> salvar(@ApiParam(name = "corpo", value = "Representação de um novo paciente", required = true) @Valid PacienteRequest pacienteRequest);
	
	@ApiOperation(httpMethod = "GET", value = "Buscar Paciente pelo ID")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Buscar Paciente pelo ID", response = PacienteDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) 
	})
	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Paciente> buscar(Long id);
	
	@ApiOperation(httpMethod = "GET", value = "Buscar todos os Pacientes")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Buscar todos os Pacientes", response = PacienteDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) 
	})
	public List<PacienteDTO> listar();
	
	@ApiOperation(httpMethod = "DELETE", value = "Excluir Paciente pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ 
		@ApiResponse(code = 204, message = "Paciente excluído com sucesso", response = PacienteDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser excluído", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Paciente> excluir(Long id);
	
	@ApiOperation(httpMethod = "PUT", value = "Atualizar Paciente pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Paciente atualizado com sucesso.", response = PacienteDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser atualizado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<?> atualizar(@ApiParam(name = "corpo", value = "Representação de um novo paciente", required = true) @Valid PacienteRequest paciente, Long id);
}
