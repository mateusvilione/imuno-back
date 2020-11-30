package br.com.imuno.controller.openapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.com.imuno.dto.PostoDTO;
import br.com.imuno.exception.config.Problem;
import br.com.imuno.model.Posto;
import br.com.imuno.request.PostoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de Posto")
public interface PostoControllerOpenApi {
	
	@ApiOperation(httpMethod = "POST", value = "Cadastrar posto")
	@ApiResponses({ 
		@ApiResponse(code = 201, message = "Posto cadastrado" ),
		@ApiResponse(code = 204, message = "")
	})
	ResponseEntity<?> salvar(@ApiParam(name = "corpo", value = "Representação de um novo posto", required = true) @Valid PostoRequest postoRequest);
	
	@ApiOperation(httpMethod = "GET", value = "Buscar Posto pelo ID")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Buscar Posto pelo ID", response = PostoDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) 
	})
	@ApiImplicitParam(name = "id", value = "ID a ser buscado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Posto> buscar(Long id);
	
	@ApiOperation(httpMethod = "GET", value = "Buscar todos os Postos")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Buscar todos os Postos", response = PostoDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class) 
	})
	public List<PostoDTO> listar(Long administradorId);
	
	@ApiOperation(httpMethod = "DELETE", value = "Excluir Posto pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({ 
		@ApiResponse(code = 204, message = "Posto excluído com sucesso", response = PostoDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser excluído", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<Posto> excluir(Long id);
	
	@ApiOperation(httpMethod = "PUT", value = "Atualizar posto pelo ID", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({
		@ApiResponse(code = 200, message = "Posto atualizado com sucesso.", response = PostoDTO.class),
		@ApiResponse(code = 404, message = "O recurso não foi encontrado", response = Problem.class)
	})
	@ApiImplicitParam(name = "id", value = "Id a ser atualizado", required = true, dataType = "int", paramType = "path", example = "1")
	ResponseEntity<?> atualizar(@ApiParam(name = "corpo", value = "Representação de um novo posto", required = true) @Valid Posto posto, Long id);
}