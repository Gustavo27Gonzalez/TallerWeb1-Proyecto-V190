package ar.edu.unlam.tallerweb1.models.rifas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosRifa;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

@Entity (name="rifa")
public class Rifa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rifa_id")
	private Long id;
	private Boolean fueVendida = false;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sorteo_id")
	private Sorteo sorteo;
	@OneToOne(mappedBy = "rifa")
	private Compra compra;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getFueVendida() {
		return fueVendida;
	}
	public void setFueVendida(Boolean fueVendida) {
		this.fueVendida = fueVendida;
	}
	public Sorteo getSorteo() {
		return sorteo;
	}
	public void setSorteo(Sorteo sorteo) {
		this.sorteo = sorteo;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public Rifa() {}
	
	public Rifa(Long id) {
		setId(id);
	}

	public Rifa(Long id, Boolean fueVendida) {
		setId(id);
		setFueVendida(fueVendida);
	}
	
	public Rifa(DatosRifa datosRifa) {
		setId(datosRifa.getRifaId());
	}

}