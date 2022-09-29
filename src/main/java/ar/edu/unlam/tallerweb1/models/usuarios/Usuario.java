package ar.edu.unlam.tallerweb1.models.usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import ar.edu.unlam.tallerweb1.models.referidos.Referido;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;



// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en el
@Entity (name="usuario")
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer dni;
	private String email;
	private String password;
	private String estado;
	private Boolean cuentaEliminada = false;
	private Integer totalRifasCompradas;
	/*@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "sorteosOrganizados",
			joinColumns = @JoinColumn(name = "Usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "sorteo_id"))*/
	private ArrayList<Sorteo> sorteosOrganizados;
    private ArrayList<Sorteo> sorteosGanados;
    private ArrayList<Sorteo> sorteosParticipando;
    private LinkedHashSet<Rifa> rifasCompradas;
    private HashSet<Referido> referidos;
    
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Boolean getCuentaEliminada() {
		return cuentaEliminada;
	}
	public void setCuentaEliminada(Boolean cuentaEliminada) {
		this.cuentaEliminada = cuentaEliminada;
	}
	public Integer getTotalRifasCompradas() {
		return totalRifasCompradas;
	}
	public void setTotalRifasCompradas(Integer totalRifasCompradas) {
		this.totalRifasCompradas = totalRifasCompradas;
	}
	public ArrayList<Sorteo> getSorteosOrganizados() {
		return sorteosOrganizados;
	}
	public void setSorteosOrganizados(ArrayList<Sorteo> sorteosOrganizados) {
		this.sorteosOrganizados = sorteosOrganizados;
	}
	public ArrayList<Sorteo> getSorteosGanados() {
		return sorteosGanados;
	}
	public void setSorteosGanados(ArrayList<Sorteo> sorteosGanados) {
		this.sorteosGanados = sorteosGanados;
	}
	public ArrayList<Sorteo> getSorteosParticipando() {
		return sorteosParticipando;
	}
	public void setSorteosParticipando(ArrayList<Sorteo> sorteosParticipando) {
		this.sorteosParticipando = sorteosParticipando;
	}
	public LinkedHashSet<Rifa> getRifasCompradas() {
		return rifasCompradas;
	}
	public void setRifasCompradas(LinkedHashSet<Rifa> rifasCompradas) {
		this.rifasCompradas = rifasCompradas;
	}
	public HashSet<Referido> getReferidos() {
		return referidos;
	}
	public void setReferidos(HashSet<Referido> referidos) {
		this.referidos = referidos;
	}
	
	public Usuario() {
		super();
	}
	
	public Usuario(String email, String password, String direccion){
		this.email=email;
		this.password=password;
		this.estado="Activo";
		
	}
	
	public Usuario(DatosRegistro datosRegistro) {
		this.email = datosRegistro.getEmail();
		this.password = datosRegistro.getPassword();
		
	}
	
}
