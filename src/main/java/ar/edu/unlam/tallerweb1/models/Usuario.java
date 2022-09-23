package ar.edu.unlam.tallerweb1.models;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String mail;
    private String userName;
    private String password;
    private Map<String,Sorteo> sorteosAdministrados;
    private Map<String,Sorteo> sorteoParticipando;
    private Map<String,Sorteo> sorteosGanados;
    private Map<String,Sorteo> referidos;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Sorteo> getSorteosAdministrados() {
        return sorteosAdministrados;
    }

    public void setSorteosAdministrados(Map<String, Sorteo> sorteosAdministrados) {
        this.sorteosAdministrados = sorteosAdministrados;
    }

    public Map<String, Sorteo> getSorteoParticipando() {
        return sorteoParticipando;
    }

    public void setSorteoParticipando(Map<String, Sorteo> sorteoParticipando) {
        this.sorteoParticipando = sorteoParticipando;
    }

    public Map<String, Sorteo> getSorteosGanados() {
        return sorteosGanados;
    }

    public void setSorteosGanados(Map<String, Sorteo> sorteosGanados) {
        this.sorteosGanados = sorteosGanados;
    }

    public Map<String, Sorteo> getReferidos() {
        return referidos;
    }

    public void setReferidos(Map<String, Sorteo> referidos) {
        this.referidos = referidos;
    }
}
