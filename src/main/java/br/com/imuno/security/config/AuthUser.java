package br.com.imuno.security.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.imuno.model.Usuario;
import lombok.Getter;

@Getter
public class AuthUser extends User {

private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String nomeCompleto;
	
	private Long pacienteId;
	private Long funcionarioId;
	private Long administradorId;
	
	
	public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> permissoes) {
		super(usuario.getEmail(), usuario.getSenha(),  permissoes);
		
		this.userId = usuario.getId();
		this.nomeCompleto = usuario.getNome();
		this.pacienteId = usuario.getPacienteId();
		this.funcionarioId = usuario.getFuncionarioId();
		this.administradorId = usuario.getAdministradorId();
		
		
		System.out.println("aaaaaaaaaaaaaaa" + usuario);
	}
	
}
