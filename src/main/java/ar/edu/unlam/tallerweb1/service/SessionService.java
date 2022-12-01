package ar.edu.unlam.tallerweb1.service;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public interface SessionService {
    public void setCurrentUser(Usuario usuarioBuscado);
    public Usuario getCurrentUser() throws Exception;

    public void setCurrentSorteo(Sorteo sorte);
    public Sorteo getCurrentSorteo() throws Exception;


}