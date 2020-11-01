package br.com.imuno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.imuno.model.enums.Doses;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Dose {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer numero;
	
	@Column(nullable = false, name = "idade_minima")
	private Integer idadeMinima;
	
	@Column(name = "idade_maxima")
	private Integer idadeMaxima;
	
	@Column(nullable = false)
	private Doses tipo;
	
	@Column
	private Integer reforco;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="vacina_id", nullable = false) 
	private Vacina vacina;
}
