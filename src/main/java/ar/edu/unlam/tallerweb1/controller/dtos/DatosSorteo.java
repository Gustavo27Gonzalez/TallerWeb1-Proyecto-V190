package ar.edu.unlam.tallerweb1.controller.dtos;

public class DatosSorteo {
	private Long idSorteo;
	private String nombre;
	private String descripcion;
	private Double precioRifa;
	private Integer cantidadRifas;

	// private String tipoPremio;
	public DatosSorteo() {
	};

	public DatosSorteo(Long idSorteo, String nombre, String descripcion, Double precioRifa, Integer cantidadRifas) {
		this.idSorteo = idSorteo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioRifa = precioRifa;
		this.cantidadRifas = cantidadRifas;
	}

	public DatosSorteo(String nombre, String descripcion, Double precioRifa, Integer cantidadRifas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioRifa = precioRifa;
		this.cantidadRifas = cantidadRifas;
	}

	public Long getIdSorteo() {
		return idSorteo;
	}

	public void setIdSorteo(Long idSorteo) {
		this.idSorteo = idSorteo;
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

}
