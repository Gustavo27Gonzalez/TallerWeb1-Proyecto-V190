package ar.edu.unlam.tallerweb1.models.sorteos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.premios.Premio;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import jakarta.validation.constraints.NotNull;


@Entity (name="sorteo")
public class Sorteo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sorteo_id")
    private Long id;
    private String nombre;
    private String descripcion;
    @NotNull
    private Double precioRifa;
    private Integer cantidadRifas;
    @OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL)
    private List<Rifa> rifas = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "premio_id")
	private Premio premio;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecioRifa() {
		return precioRifa;
	}
	public void setPrecioRifa(Double precioRifa) {
		this.precioRifa = precioRifa;
	}
	public Integer getCantidadRifas() {
		return cantidadRifas;
	}
	public void setCantidadRifas(Integer cantidadRifas) {
		this.cantidadRifas = cantidadRifas;
	}
	public Premio getPremio() {
		return premio;
	}
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	
	public List<Rifa> getRifas() {
		return rifas;
	}
	public void setRifas(ArrayList<Rifa> rifas) {
		this.rifas = rifas;
	}
	
	public Sorteo() {}
    
	public Sorteo(DatosSorteo datosSorteo) {
		setNombre(datosSorteo.getNombre());
		setDescripcion(datosSorteo.getDescripcion());
		setPrecioRifa(datosSorteo.getPrecioRifa());
		setCantidadRifas(datosSorteo.getCantidadRifas());
	}
	
	public Sorteo(String nombre) {
		setNombre(nombre);
	}
    
    
}