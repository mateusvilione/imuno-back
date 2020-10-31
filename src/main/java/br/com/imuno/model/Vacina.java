package br.com.imuno.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vacina")
public class Vacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String prevencao;
	
	@OneToMany(mappedBy = "vacina", cascade = CascadeType.ALL)
	private List<Dose> dose;
		
	//idade_recomendada
	@OneToMany(mappedBy = "vacina", cascade = CascadeType.ALL)
	private List<IdadeRecomendada> idadeRecomendada;
	
	@ManyToOne
	@JoinColumn(name = "lote_id", nullable = false)
	private Lote lote;

}
