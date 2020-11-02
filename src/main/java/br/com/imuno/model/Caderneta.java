package br.com.imuno.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "caderneta")
public class Caderneta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "lote_id", nullable = false)
	private Lote lote;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "vacina_id", nullable = false)
	private Vacina vacina;
	
	@ManyToOne
	@JoinColumn(name = "dose_id", nullable = false)
	private Dose dose;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;
	
	@Column(name="data_vacinacao")
    private OffsetDateTime dataCadastro;
}
