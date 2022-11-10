package ar.edu.unlam.tallerweb1.controller.dtos;

public class CompraDTO {
	private Long id;
	private Long numeroDeRifa;
	private String nombreUsuario;
	
	public CompraDTO() {
		
	}
	
	public CompraDTO(Long id, String nombreUsuario) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getNumeroDeRifa() {
		return numeroDeRifa;
	}

	public void setNumeroDeRifa(Long numeroDeRifa) {
		this.numeroDeRifa = numeroDeRifa;
	}
}
