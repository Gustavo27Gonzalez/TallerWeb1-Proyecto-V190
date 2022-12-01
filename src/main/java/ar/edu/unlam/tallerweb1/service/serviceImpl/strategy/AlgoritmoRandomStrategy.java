package ar.edu.unlam.tallerweb1.service.serviceImpl.strategy;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

import java.util.List;

public class AlgoritmoRandomStrategy implements AlgoritmoStrategy {
    @Override
    public Rifa execute(List<Rifa> rifas) {
        int ganador = (int) Math.floor(Math.random() * rifas.size());
        return rifas.get(ganador);
    }
}
