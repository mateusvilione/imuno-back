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
import org.springframework.web.bind.annotation.RestController;

import br.com.imuno.controller.openapi.AdministradorControllerOpenApi;
import br.com.imuno.dto.AdministradorDTO;
import br.com.imuno.model.Administrador;
import br.com.imuno.request.AdministradorRequest;
import br.com.imuno.service.AdministradorService;


@CrossOrigin
@RestController
@RequestMapping("/administrador")
public class AdministradorController implements AdministradorControllerOpenApi {

	@Autowired
	private AdministradorService _service;
	
	@Override
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody AdministradorRequest administradorRequest) {
		try {
			AdministradorDTO administradorDTO = _service.salvar(administradorRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(administradorDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Administrador> buscar(@PathVariable Long id) {
		Optional<Administrador> administrador = _service.buscar(id);
		if (administrador.isPresent()) {
			return ResponseEntity.ok(administrador.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@GetMapping
	public List<AdministradorDTO> listar() {
		return _service.listar();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody Administrador administrador, @PathVariable Long id) {
		Administrador administradorAtual = _service.buscar(id).orElse(null);
		if (administradorAtual != null) {
			BeanUtils.copyProperties(administrador, administradorAtual, "id");
			_service.atualizar(administradorAtual);
			return ResponseEntity.ok(administradorAtual);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Administrador> excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
