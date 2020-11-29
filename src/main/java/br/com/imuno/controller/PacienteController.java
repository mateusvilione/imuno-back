package br.com.imuno.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

import br.com.imuno.controller.openapi.PacienteControllerOpenApi;
import br.com.imuno.dto.PacienteDTO;
import br.com.imuno.model.Paciente;
import br.com.imuno.request.PacienteRequest;
import br.com.imuno.service.PacienteService;

@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacienteController implements PacienteControllerOpenApi {

	@Autowired
	private PacienteService _service;

	@Override
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody PacienteRequest pacienteRequest) {
		try {
			PacienteDTO pacienteDTO = _service.salvar(pacienteRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@Override
	@GetMapping("/filtro")
	public ResponseEntity<Paciente> buscar(@RequestParam(required = false) Long id, @RequestParam(required = false) String cpfRne ) {
		Optional<Paciente> paciente = Optional.ofNullable(new Paciente());
		
		if(id != null) {
			paciente = _service.buscar(id);
		}
		
		if(id == null && cpfRne != null) {
			paciente = _service.buscarCpfRne(cpfRne);
		}
		
		if (paciente.isPresent()) {
			return ResponseEntity.ok(paciente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@GetMapping
	public List<PacienteDTO> listar() {
		return _service.listar();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody PacienteRequest paciente, @PathVariable Long id) {
		Paciente pacienteAtual = _service.buscar(id).orElse(null);
		if (pacienteAtual != null) {
			BeanUtils.copyProperties(paciente, pacienteAtual, "id", "usuarioId");
			_service.atualizar(pacienteAtual);
			return ResponseEntity.ok(pacienteAtual);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> excluir(@PathVariable Long id) {
		try {
			_service.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
