package ar.edu.unlam.tallerweb1.controller.dtos;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public class DatosCompra {
	
	private Rifa rifa;
	private Usuario usuario;
	
	public DatosCompra() {}
	
	public DatosCompra(Rifa rifa, Usuario usuario) {
		setRifa(rifa);
		setUsuario(usuario);
	}
	
	public Rifa getRifa() {
		return rifa;
	}
	public void setRifa(Rifa rifa) {
		this.rifa = rifa;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
