package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.domain.referidos.Referido;
import ar.edu.unlam.tallerweb1.domain.rifas.Rifa;
import ar.edu.unlam.tallerweb1.domain.sorteos.Sorteo;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en el
@Entity (name="usuario")
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.
	private String nombre;
	private Integer dni;
	private String email;
	private String rol;
	private String password;
	private Boolean cuentaEliminada = false;
	private Integer totalRifasCompradas;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
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
	
	
    
    
	
}
