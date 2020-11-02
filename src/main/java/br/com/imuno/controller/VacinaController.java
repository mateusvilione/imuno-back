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

import br.com.imuno.dto.VacinaDTO;
import br.com.imuno.model.Vacina;
import br.com.imuno.request.VacinaRequest;
import br.com.imuno.service.VacinaService;

@CrossOrigin
@RestController
@RequestMapping("/vacina")
public class VacinaController {

	@Autowired
	private VacinaService _service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody VacinaRequest vacinaRequest) {
		try {
			VacinaDTO vacinaDTO = _service.salvar(vacinaRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(vacinaDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vacina> buscar(@PathVariable Long id) {
		Optional<Vacina> vacina = _service.buscar(id);
		if (vacina.isPresent()) {
			return ResponseEntity.ok(vacina.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public List<VacinaDTO> listar() {
		return _service.listar();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody Vacina vacina, @PathVariable Long id) {
		Vacina vacinaAtual = _service.buscar(id).orElse(null);
		if (vacinaAtual != null) {
			BeanUtils.copyProperties(vacina, vacinaAtual, "id");
			_service.atualizar(vacinaAtual);
			return ResponseEntity.ok(vacinaAtual);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Vacina> excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
