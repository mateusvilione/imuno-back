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

import br.com.imuno.dto.DoseDTO;
import br.com.imuno.model.Dose;
import br.com.imuno.request.DoseRequest;
import br.com.imuno.service.DoseService;


@CrossOrigin
@RestController
@RequestMapping("/dose")
public class DoseController {

	@Autowired
	private DoseService _service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody DoseRequest doseRequest) {
		try {
			DoseDTO doseDTO = _service.salvar(doseRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(doseDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dose> buscar(@PathVariable Long id) {
		Optional<Dose> dose = _service.buscar(id);
		if (dose.isPresent()) {
			return ResponseEntity.ok(dose.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public List<DoseDTO> listar() {
		return _service.listar();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody Dose dose, @PathVariable Long id) {
		Dose doseAtual = _service.buscar(id).orElse(null);
		if (doseAtual != null) {
			BeanUtils.copyProperties(dose, doseAtual, "id");
			_service.atualizar(doseAtual);
			return ResponseEntity.ok(doseAtual);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Dose> excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
