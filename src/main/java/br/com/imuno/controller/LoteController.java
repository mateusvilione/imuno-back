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

import br.com.imuno.dto.LoteDTO;
import br.com.imuno.model.Lote;
import br.com.imuno.request.LoteRequest;
import br.com.imuno.service.LoteService;


@CrossOrigin
@RestController
@RequestMapping("/lote")
public class LoteController {

	@Autowired
	private LoteService _service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody LoteRequest loteRequest) {
		try {
			LoteDTO administradorDTO = _service.salvar(loteRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(administradorDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Lote> buscar(@PathVariable Long id) {
		Optional<Lote> lote = _service.buscar(id);
		if (lote.isPresent()) {
			return ResponseEntity.ok(lote.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public List<LoteDTO> listar() {
		return _service.listar();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody Lote lote, @PathVariable Long id) {
		Lote loteAtual = _service.buscar(id).orElse(null);
		if (loteAtual != null) {
			BeanUtils.copyProperties(lote, loteAtual, "id");
			_service.atualizar(loteAtual);
			return ResponseEntity.ok(loteAtual);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Lote> excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
