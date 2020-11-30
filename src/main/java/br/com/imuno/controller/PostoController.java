package br.com.imuno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.imuno.dto.PostoDTO;
import br.com.imuno.model.Posto;
import br.com.imuno.request.PostoRequest;
import br.com.imuno.service.PostoService;
import br.com.imuno.controller.openapi.PostoControllerOpenApi;

@CrossOrigin
@RestController
@RequestMapping("/posto")
public class PostoController implements PostoControllerOpenApi {

	@Autowired
	private PostoService _service;
	
	@Override
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody PostoRequest postoRequest) {
		try {
			PostoDTO postoDTO = _service.salvar(postoRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(postoDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Posto> buscar(@PathVariable Long id) {
		Optional<Posto> posto = _service.buscar(id);
		if (posto.isPresent()) {
			return ResponseEntity.ok(posto.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@GetMapping
	public List<PostoDTO> listar(@RequestParam(required = false) Long administradorId) {
		
		if(administradorId != null) {
			return _service.findByAdministradorId(administradorId);
		}
		
		return _service.listar();	
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody Posto posto, @PathVariable Long id) {
		Posto postoAtual = _service.buscar(id).orElse(null);
		if (postoAtual != null) {
			BeanUtils.copyProperties(posto, postoAtual, "id");
			_service.atualizar(postoAtual);
			return ResponseEntity.ok(postoAtual);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Posto> excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}