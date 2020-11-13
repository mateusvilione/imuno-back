package br.com.imuno.controller.openapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.com.imuno.dto.AdministradorDTO;
import br.com.imuno.exception.config.Problem;
import br.com.imuno.model.Administrador;
import br.com.imuno.request.AdministradorRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Administrador")
public interface AdministradorControllerOpenApi {
	
	@ApiOperation(httpMethod = "POST", value = "Cadastrar Administrador")
	@ApiResponses({ 
		@ApiResponse(code = 201, message = "Administrador cadastrado" ),
		@ApiResponse(code = 204, message = "")
	})
	ResponseEntity<?> salvar(@ApiParam(name = "corpo", value = "Representação de um novo Administrador", required = true) @Valid AdministradorRequest administradorRequest);
	
	@ApiOperation(httpMethod = "GET", value = "Buscar Administrador pelo ID")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Buscar Administrador pelo ID", response = AdministradorDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) 
	})
	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Administrador> buscar(Long id);
	
	@ApiOperation(httpMethod = "GET", value = "Buscar todos os Administradores")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Buscar todos os Administradores", response = AdministradorDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) 
	})
	public List<AdministradorDTO> listar();
	
	@ApiOperation(httpMethod = "DELETE", value = "Excluir Administrador pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ 
		@ApiResponse(code = 204, message = "Administrador excluído com sucesso", response = AdministradorDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser excluído", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Administrador> excluir(Long id);
	
	@ApiOperation(httpMethod = "PUT", value = "Atualizar Administrador pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Administrador atualizado com sucesso.", response = AdministradorDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser atualizado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<?> atualizar(@ApiParam(name = "corpo", value = "Representação de um novo Administrador", required = true) @Valid AdministradorRequest administrador, Long id);
}