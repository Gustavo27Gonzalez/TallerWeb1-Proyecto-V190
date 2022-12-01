package ar.edu.unlam.tallerweb1.controller.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DatosRegistro {

	@NotNull(message = "Ingrese su nombre")
	@NotEmpty(message = "Ingrese su nombre")
	@Size(min = 3, max = 50, message 
    = "Su nombre deberá tener entre 3 y 50 caracteres de longitud")
	private String nombre;
	@NotNull(message = "Ingrese su dni")
	@NotEmpty(message = "Ingrese su dni")
	@Min(value = 1, message = "Ingrese un dni válido, sin puntos, espacios ni guiones")
    @Max(value = 99999999, message = "Ingrese un dni válido, sin puntos, espacios ni guiones")
    private Integer dni;
    @NotNull(message = "Ingrese su mail")
	@NotEmpty(message = "Ingrese su mail")
	@Email(message = "Ingrese un mail con formato válido")
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Ingrese un mail con formato válido")
	private String email;
    private Double precioDeRifasTope;
    @NotNull(message = "Ingrese su contraseña")
	@NotEmpty(message = "Ingrese su contraseña")
	@Size(min = 8, max = 20, message 
    = "La contraseña debe tener entre 8 y 20 caracteres de longitud")
	private String password;
    @NotNull(message = "Repita su contraseña")
	@NotEmpty(message = "Repita su contraseña")
	@Size(min = 8, max = 20, message 
    = "La contraseña debe tener entre 8 y 20 caracteres de longitud")
	private String repitePassword;

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
    
    public String getRepitePassword() {
        return repitePassword;
    }

    public void setRepitePassword(String repitePassword) {
        this.repitePassword = repitePassword;
    }

    public DatosRegistro(){}

    public DatosRegistro(String nombre, Integer dni, String email, String password) {
        setNombre(nombre);
        setDni(dni);
    	setEmail(email);
        setPassword(password);
    }
    
    public DatosRegistro(String nombre, Integer dni, String email, String password,
			String repitePassword) {
		setNombre(nombre);
        setDni(dni);
    	setEmail(email);
        setPassword(password);
		setRepitePassword(repitePassword);
	}

	public DatosRegistro(String nombre, Integer dni, String email, Double precioDeRifasTope, String password,
			String repitePassword) {
		setNombre(nombre);
        setDni(dni);
    	setEmail(email);
    	setPrecioDeRifasTope(precioDeRifasTope);
        setPassword(password);
		setRepitePassword(repitePassword);
	}
    
    
}