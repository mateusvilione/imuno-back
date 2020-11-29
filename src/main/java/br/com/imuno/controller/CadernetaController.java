package br.com.imuno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imuno.dto.CadernetaDTO;
import br.com.imuno.model.Caderneta;
import br.com.imuno.request.CadernetaRequest;
import br.com.imuno.service.CadernetaService;

@CrossOrigin
@RestController
@RequestMapping("/caderneta")
public class CadernetaController {

	@Autowired
	private CadernetaService _service;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody CadernetaRequest cadernetaRequest) {
		try {
			CadernetaDTO cadernetaDTO = _service.salvar(cadernetaRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(cadernetaDTO);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	public List<Caderneta> buscar(@PathVariable Long id) {
		List<Caderneta> caderneta = _service.buscar(id);

		return caderneta;
	}

	@GetMapping
	public List<CadernetaDTO> listar() {
		return _service.listar();
	}
	/*
	 * @Override
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<?> atualizar(@RequestBody
	 * Caderneta caderneta, @PathVariable Long id) { Caderneta cadernetaAtual =
	 * _service.buscar(id).orElse(null); if (cadernetaAtual != null) {
	 * BeanUtils.copyProperties(caderneta, cadernetaAtual, "id");
	 * _service.atualizar(cadernetaAtual); return ResponseEntity.ok(cadernetaAtual);
	 * } return ResponseEntity.notFound().build(); }
	 * 
	 * @Override
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Caderneta>
	 * excluir(@PathVariable Long id) { try { _service.excluir(id); return
	 * ResponseEntity.noContent().build(); } catch (Exception e) { return
	 * ResponseEntity.notFound().build(); } }
	 */
}
