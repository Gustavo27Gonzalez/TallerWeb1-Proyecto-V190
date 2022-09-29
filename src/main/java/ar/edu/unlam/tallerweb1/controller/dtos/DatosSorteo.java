package ar.edu.unlam.tallerweb1.controller.dtos;


public class DatosSorteo {
	
    private String nombre;
    private String descripcion;
    private Double precioRifa;
    private Integer cantidadRifas;
    //private String tipoPremio;
    
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
    
    public DatosSorteo() {};
    
    public DatosSorteo(String nombre, String descripcion, Double precioRifa, Integer cantidadRifas) {
    	
    }

}
