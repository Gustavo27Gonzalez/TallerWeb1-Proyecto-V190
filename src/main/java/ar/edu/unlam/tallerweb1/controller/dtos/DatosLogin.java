package ar.edu.unlam.tallerweb1.controller.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DatosLogin {
	
	@NotNull(message = "{login.email.null}")
	@NotEmpty(message = "Ingrese su mail")
	@Email(message = "Ingrese un mail con formato válido")
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Ingrese un mail con formato válido")
	private String email;
	@NotNull(message = "Ingrese su contraseña")
	@NotEmpty(message = "Ingrese su contraseña")
	@Size(min = 8, max = 20, message 
    = "La contraseña debe tener entre 8 y 20 caracteres de longitud")
	private String password;

	public DatosLogin() {
	}
	
	public DatosLogin(String email, String password) {
		this.email = email;
		this.password = password;
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
