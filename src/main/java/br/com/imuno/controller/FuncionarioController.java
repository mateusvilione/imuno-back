package br.com.imuno.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import br.com.imuno.dto.FuncionarioDTO;
import br.com.imuno.model.Funcionario;
import br.com.imuno.request.FuncionarioRequest;
import br.com.imuno.service.FuncionarioService;

@CrossOrigin
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody FuncionarioRequest funcionarioRequest) {
		try {
			FuncionarioDTO funcionarioDTO = service.salvar(funcionarioRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioDTO);
		} catch(Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@GetMapping
	public List<FuncionarioDTO> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		
		Optional<Funcionario> funcionario = service.buscar(id);
		
		if (funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Funcionario> excluir(@PathVariable Long id) {
		try {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@RequestBody @Valid Funcionario funcionario, @PathVariable Long id) {
		
		Funcionario funcionarioAtual = service.buscar(id).orElse(null);
		
		if (funcionarioAtual != null) {
			BeanUtils.copyProperties(funcionario, funcionarioAtual, "id");
			
			service.atualizar(funcionarioAtual);
			return ResponseEntity.ok(funcionarioAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	

}
