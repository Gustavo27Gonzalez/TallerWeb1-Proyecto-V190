package ar.edu.unlam.tallerweb1.controller.dtos;

public class DatosRegistro {

	private String nombre;
    private Integer dni;
    private String email;
    private String password;
    
    public DatosRegistro(){}

    public DatosRegistro(String nombre, Integer dni, String email, String password) {
        this.nombre = nombre;
        this.dni = dni;
    	this.email = email;
        this.password = password;
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
    

}