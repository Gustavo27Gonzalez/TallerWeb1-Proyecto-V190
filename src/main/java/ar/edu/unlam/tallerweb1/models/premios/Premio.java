package ar.edu.unlam.tallerweb1.models.premios;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

@Entity (name="premio")
public class Premio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoPremio tipoPremio;
	
	//private Sorteo sorteo;
	
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
	/*
	public Sorteo getSorteo() {
		return sorteo;
	}
	public void setSorteo(Sorteo sorteo) {
		this.sorteo = sorteo;
	}
	public Premio() {}
	
	public Premio(TipoPremio tipoPremio, Sorteo sorteo) {
		setTipoPremio(tipoPremio);
		setSorteo(sorteo);
	}
	*/
	
	public Premio (TipoPremio tipoPremio) {
		setTipoPremio(tipoPremio);
	}
}
