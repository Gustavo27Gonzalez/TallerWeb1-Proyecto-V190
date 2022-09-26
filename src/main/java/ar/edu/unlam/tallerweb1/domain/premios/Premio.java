package ar.edu.unlam.tallerweb1.domain.premios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Premio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	
	

}
