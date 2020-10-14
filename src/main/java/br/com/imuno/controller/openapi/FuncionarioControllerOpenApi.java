package br.com.imuno.controller.openapi;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.com.imuno.dto.FuncionarioDTO;
import br.com.imuno.exception.config.Problem;
import br.com.imuno.model.Funcionario;
import br.com.imuno.request.FuncionarioRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Funcionario")
public interface FuncionarioControllerOpenApi {
	
	@ApiOperation(httpMethod = "POST", value = "Cadastrar Funcionario")
	@ApiResponses({ 
		@ApiResponse(code = 201, message = "Funcionario cadastrado" ),
		@ApiResponse(code = 204, message = "")
	})
	ResponseEntity<?> salvar(@ApiParam(name = "corpo", value = "Representação de um novo funcionario", required = true) @Valid FuncionarioRequest funcionarioRequest);
	
	@ApiOperation(httpMethod = "GET", value = "Buscar Funcionario pelo ID")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Buscar Funcionario pelo ID", response = FuncionarioDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) 
	})
	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Funcionario> buscar(Long id);
	
	@ApiOperation(httpMethod = "DELETE", value = "Excluir Funcionario pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ 
		@ApiResponse(code = 204, message = "Funcionario excluído com sucesso", response = FuncionarioDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser excluído", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Funcionario> excluir(Long id);
	
	@ApiOperation(httpMethod = "PUT", value = "Atualizar Funcionario pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Funcionario atualizado com sucesso.", response = FuncionarioDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser atualizado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<?> atualizar(@ApiParam(name = "corpo", value = "Representação de um novo funcionario", required = true) @Valid Funcionario funcionario, Long id);
}
