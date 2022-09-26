package ar.edu.unlam.tallerweb1.domain.rifas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rifa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSorteo;
	private Long idRifa;
	private Boolean fueVendida = false;
	private Long idComprador;
	
	
	public Long getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(Long idSorteo) {
		this.idSorteo = idSorteo;
	}
	public Long getIdRifa() {
		return idRifa;
	}
	public void setIdRifa(Long idRifa) {
		this.idRifa = idRifa;
	}
	public Boolean getFueVendida() {
		return fueVendida;
	}
	public void setFueVendida(Boolean fueVendida) {
		this.fueVendida = fueVendida;
	}
	public Long getIdComprador() {
		return idComprador;
	}
	public void setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
	}
	
	

}
