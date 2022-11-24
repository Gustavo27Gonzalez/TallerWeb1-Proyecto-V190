package ar.edu.unlam.tallerweb1.service.serviceImpl.strategy;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

import java.util.ArrayList;
import java.util.List;

public class RifasPorUsuarioEnSorteo {
    List<Rifa> rifas;
    Long usuarioId;

    public RifasPorUsuarioEnSorteo(Long usuarioId){
        this.rifas = new ArrayList<>();
        this.usuarioId = usuarioId;
    }

    public List<Rifa> getRifas() {
        return rifas;
    }

    public void addInRifas(Rifa rifa) {
        this.rifas.add(rifa);
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
