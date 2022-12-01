package ar.edu.unlam.tallerweb1.service.serviceImpl.strategy;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

import java.util.List;

public class AlgoritmoPreseleccionadoStrategy implements AlgoritmoStrategy {
    @Override
    public Rifa execute(List<Rifa> rifas) {
        return rifas.stream().filter((rifa)-> rifa.esRifaGanadora()).findFirst().get();
    }
}
