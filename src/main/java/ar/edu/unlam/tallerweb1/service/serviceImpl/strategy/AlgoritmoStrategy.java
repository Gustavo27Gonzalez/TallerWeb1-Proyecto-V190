package ar.edu.unlam.tallerweb1.service.serviceImpl.strategy;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

import javax.persistence.Entity;
import java.util.List;

public interface AlgoritmoStrategy {
    public Rifa execute(List<Rifa> rifas);
}
