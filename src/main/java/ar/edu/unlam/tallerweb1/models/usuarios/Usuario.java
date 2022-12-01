package ar.edu.unlam.tallerweb1.models.usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.enums.TipoDocumento;
import ar.edu.unlam.tallerweb1.models.referidos.Referido;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosLogin;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;


@Entity (name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	private String nombre;
	private String email;
	private Integer dni;
	private Double precioDeRifasTope;
	private String password;
	private Boolean cuentaEliminada = false;
	private Boolean ganoUnSorteoYa = false;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Compra> rifasCompradas = new ArrayList<>();

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
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getPrecioDeRifasTope() {
		return precioDeRifasTope;
	}
	public void setPrecioDeRifasTope(Double precioDeRifasTope) {
		this.precioDeRifasTope = precioDeRifasTope;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getCuentaEliminada() {
		return cuentaEliminada;
	}
	public void setCuentaEliminada(Boolean cuentaEliminada) {
		this.cuentaEliminada = cuentaEliminada;
	}
	public Boolean getGanoUnSorteoYa() {
		return ganoUnSorteoYa;
	}
	public void setGanoUnSorteoYa(Boolean ganoUnSorteoYa) {
		this.ganoUnSorteoYa = ganoUnSorteoYa;
	}
	public List<Compra> getRifasCompradas() {
		return rifasCompradas;
	}
	public void setRifasCompradas(ArrayList<Compra> rifasCompradas) {
		this.rifasCompradas = rifasCompradas;
	}

	public Usuario() {};
	
	public Usuario(DatosRegistro datosRegistro) {
		setNombre(datosRegistro.getNombre());
        setDni(datosRegistro.getDni());
    	setEmail(datosRegistro.getEmail());
        setPassword(datosRegistro.getPassword());
        setPrecioDeRifasTope(datosRegistro.getPrecioDeRifasTope());
	}
	/*
	public Usuario(DatosRegistro datosRegistro) {
		setNombre(datosRegistro.getNombre());
		setEmail(datosRegistro.getEmail());
		setPassword(datosRegistro.getPassword());
	}
	*/
	// --> Constructor para setear los datos del login cuando se inicia sesión
	public Usuario(DatosLogin datosLogin) {
		setEmail(datosLogin.getEmail());
		setPassword(datosLogin.getPassword());
	}
	// Datos de usuario que participa en sorteo
	public Usuario(Long id, String nombre, String email, Boolean ganoUnSorteo) {
		setId(id);
		setNombre(nombre);
		setEmail(email);
		setGanoUnSorteoYa(ganoUnSorteo);
	}

	public Usuario(String nombre) {
		setNombre(nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuentaEliminada, email, ganoUnSorteoYa, id, nombre, password, rifasCompradas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cuentaEliminada, other.cuentaEliminada) && Objects.equals(email, other.email)
				&& Objects.equals(ganoUnSorteoYa, other.ganoUnSorteoYa) && Objects.equals(id, other.id);
	}
}