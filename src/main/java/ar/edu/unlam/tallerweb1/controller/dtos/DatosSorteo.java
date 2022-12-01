package ar.edu.unlam.tallerweb1.controller.dtos;

import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DatosSorteo {
	private Long idSorteo;
	@NotNull(message = "Ingrese un nombre para el sorteo")
	@NotEmpty(message = "Ingrese un nombre para el sorteo")
	@Size(min = 3, max = 50, message 
    = "El nombre del sorteo deber� tener entre 3 y 50 caracteres de longitud")
	private String nombre;
	@NotNull(message = "Ingrese una descripci�n del sorteo")
	@NotEmpty(message = "Ingrese una descripci�n del sorteo")
	@Size(min = 10, max = 200, message 
    = "La descripci�n del sorteo deber� tener entre 10 y 200 caracteres de longitud")
	private String descripcion;
	@NotNull(message = "Ingrese el precio de las rifas")
	@NotEmpty(message = "Ingrese el precio de las rifas")
	@Min(value = 10, message = "El precio m�nimo de las rifas es 10")
    @Max(value = 10000, message = "El precio m�ximo de las rifas es 10000")
	private Double precioRifa;
	@NotNull(message = "Ingrese la cantidad de rifas que tendr� el sorteo")
	@NotEmpty(message = "Ingrese la cantidad de rifas que tendr� el sorteo")
	@Min(value = 10, message = "La cantidad m�nima de rifas es 10")
    @Max(value = 1000, message = "La cantidad m�xima de rifas es 1000")
	private Integer cantidadRifas;

	private TipoAlgoritmo tipoAlgoritmo;

	// private String tipoPremio;
	public DatosSorteo() {
	};

	public DatosSorteo(Long idSorteo, String nombre, String descripcion, Double precioRifa, Integer cantidadRifas, TipoAlgoritmo tipoAlgoritmo) {
		this.idSorteo = idSorteo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioRifa = precioRifa;
		this.cantidadRifas = cantidadRifas;
		this.tipoAlgoritmo =tipoAlgoritmo;
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

	public TipoAlgoritmo getTipoAlgoritmo() {
		return tipoAlgoritmo;
	}

	public void setTipoAlgoritmo(TipoAlgoritmo tipoAlgoritmo) {
		this.tipoAlgoritmo = tipoAlgoritmo;
	}

}
