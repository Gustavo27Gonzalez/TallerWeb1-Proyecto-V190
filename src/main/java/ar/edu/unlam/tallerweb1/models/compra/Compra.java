package ar.edu.unlam.tallerweb1.models.compra;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

@Entity(name="compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="compra_id")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rifa_id")
	private Rifa rifa;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Compra() {};
	
	public Compra(Rifa rifa, Usuario usuario) {
		setRifa(rifa);
		setUsuario(usuario);
	}
	
	public Compra(DatosCompra datosCompra) {
		setRifa(datosCompra.getRifa());
		setUsuario(datosCompra.getUsuario());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, rifa, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(id, other.id) && Objects.equals(rifa, other.rifa)
				&& Objects.equals(usuario, other.usuario);
	}
	
	

}
