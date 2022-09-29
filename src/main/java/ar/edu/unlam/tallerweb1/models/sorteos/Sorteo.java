package ar.edu.unlam.tallerweb1.models.sorteos;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.models.premios.Premio;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;


@Entity (name="sorteo")
public class Sorteo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precioRifa;
    private Integer cantidadRifas;
    private LinkedList<Rifa> rifas;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "premio_sorteo")*/
    //private Premio premio;
    
    
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
	public LinkedList<Rifa> getRifas() {
		return rifas;
	}
	public void setRifas(LinkedList<Rifa> rifas) {
		this.rifas = rifas;
	}
	/*
	public Premio getPremio() {
		return premio;
	}
	public void setPremio(Premio premio) {
		this.premio = premio;
	}
	*/
    
    
    
}
