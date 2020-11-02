package br.com.imuno.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lote")
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String codigo;
	
	@Column(name = "data_fabricacao")
	private LocalDate dataFabricacao;
	
	@Column
	private Integer quantidade;
	
	@Column(name = "data_entrada")
	private LocalDate dataEntrada;
	
	@Column(name = "data_validade")
	private LocalDate dataValidade;
	
	@OneToOne
	private Administrador administrador;
	
	@OneToOne
	private Posto posto;
	
	@ManyToOne
	@JoinColumn(name = "vacina_id", nullable = false)
	private Vacina vacina;

}
