package ar.edu.unlam.tallerweb1.service.serviceImpl;

import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.SessionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SessionService")
@Transactional
public class SessionServiceImpl implements SessionService {
    Usuario currentUser = null;
    public void setCurrentUser(Usuario usuarioBuscado) {
        this.currentUser = usuarioBuscado;
    }

    public Usuario getCurrentUser() throws Exception {
        if(currentUser != null) {
            return currentUser;
        }
        throw new RuntimeException("Current user is not set");
    }
}
