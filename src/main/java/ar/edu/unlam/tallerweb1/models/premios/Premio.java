package ar.edu.unlam.tallerweb1.models.premios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ar.edu.unlam.tallerweb1.models.enums.TipoPremio;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

@Entity (name="premio")
public class Premio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="premio_id")
	private Long id;
	@Enumerated(value = EnumType.STRING)
	private TipoPremio tipoPremio;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoPremio getTipoPremio() {
		return tipoPremio;
	}
	public void setTipoPremio(TipoPremio tipoPremio) {
		this.tipoPremio = tipoPremio;
	}

	public Premio() {};
	
	public Premio (TipoPremio tipoPremio) {
		setTipoPremio(tipoPremio);
	}
	
	
}