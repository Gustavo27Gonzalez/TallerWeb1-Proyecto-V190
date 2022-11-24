package ar.edu.unlam.tallerweb1.models.algoritmo.strategy;

import ar.edu.unlam.tallerweb1.models.algoritmo.strategy.AlgoritmoStrategy;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

import java.util.List;

public class AlgoritmoPreseleccionadoStrategy implements AlgoritmoStrategy {
    @Override
    public Rifa execute(List<Rifa> rifas) {
        return rifas.stream().filter((rifa)-> rifa.esRifaGanadora()).findFirst().get();
    }
}
