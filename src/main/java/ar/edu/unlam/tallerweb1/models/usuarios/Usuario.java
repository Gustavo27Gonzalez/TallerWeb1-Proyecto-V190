package ar.edu.unlam.tallerweb1.models.usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;


@Entity (name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	@Enumerated(value = EnumType.STRING)
	private TipoDocumento tipoDocumento;
	private Integer nroDocumento;
	private String nombre;
	private String email;
	private String password;
	private Date fechaNacimiento;
	private Boolean estaLogueado = false;
	private Boolean cuentaEliminada = false;
	private Boolean ganoUnSorteoYa = false;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Compra> rifasCompradas = new ArrayList<>();
	@OneToMany(mappedBy = "referidoPor", cascade = CascadeType.ALL)
	private List<Referido> referidos = new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getEstaLogueado() {
		return estaLogueado;
	}

	public void setEstaLogueado(Boolean estaLogueado) {
		this.estaLogueado = estaLogueado;
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
	/*
	public ArrayList<Referido> getReferidos() {
		return referidos;
	}

	public void setReferidos(ArrayList<Referido> referidos) {
		this.referidos = referidos;
	}
	*/
	public Usuario() {};
	
	public Usuario(DatosRegistro datosRegistro) {
		setNombre(datosRegistro.getNombre());
		setNroDocumento(datosRegistro.getDni());
		setEmail(datosRegistro.getEmail());
		setPassword(datosRegistro.getPassword());
	}
	
	
	
}
