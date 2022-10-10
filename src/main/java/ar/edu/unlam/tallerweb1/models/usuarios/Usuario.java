package ar.edu.unlam.tallerweb1.models.usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ar.edu.unlam.tallerweb1.models.referidos.Referido;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en el
@Entity (name="usuario")
@Table(name = "usuario")
public class Usuario {
	
	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	@Column (name = "username")
	private String nombre;
	@Column(name = "dni")
	private Integer dni;
	@Column (name = "email")
	private String email;
	@Column (name = "pass")
	private String password;
	private String estado;
	private Boolean cuentaEliminada = false;
	private Boolean ganoUnSorteoYa = false;
	private Integer totalRifasCompradas;
	private ArrayList<Sorteo> sorteosOrganizados;
    private ArrayList<Sorteo> sorteosGanados;
    private ArrayList<Sorteo> sorteosParticipando;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Compra> rifasCompradas = new ArrayList<>();
    @OneToMany(mappedBy = "referidoPor", cascade = CascadeType.ALL)
	private List<Referido> referidos = new ArrayList<>();
    
	public Usuario() {
	}
	
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
	public Boolean getGanoUnSorteoYa() {
		return ganoUnSorteoYa;
	}
	public void setGanoUnSorteoYa(Boolean ganoUnSorteoYa) {
		this.ganoUnSorteoYa = ganoUnSorteoYa;
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
	
	public Usuario(String email, String password){
		setEmail(email);
		setPassword(password);
		setEstado("Activo");
	}
	
	public Usuario(DatosRegistro datosRegistro) {
		setNombre(datosRegistro.getNombre());
		setDni(datosRegistro.getDni());
		setEmail(datosRegistro.getEmail());
		setPassword(datosRegistro.getPassword());
	}
	
	// Constructor para probar algoritmo
    public Usuario(String nombre, Integer totalRifasCompradas, ArrayList<Sorteo> sorteosOrganizados, ArrayList<Sorteo> sorteosGanados, LinkedHashSet<Rifa> rifasCompradas, HashSet<Referido> referidos){
        setNombre(nombre);
        setTotalRifasCompradas(totalRifasCompradas);
        setSorteosOrganizados(sorteosOrganizados);
        setSorteosGanados(sorteosGanados);
        setRifasCompradas(rifasCompradas);
        setReferidos(referidos);
    }

    public Usuario(String nombre, Integer totalRifasCompradas, Boolean ganoUnSorteoYa){
        setNombre(nombre);
        setTotalRifasCompradas(totalRifasCompradas);
        setGanoUnSorteoYa(ganoUnSorteoYa);
    }
}
