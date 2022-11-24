package ar.edu.unlam.tallerweb1.models.algoritmo.strategy;

import ar.edu.unlam.tallerweb1.models.algoritmo.strategy.AlgoritmoStrategy;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

import java.util.List;

public class AlgoritmoRandomStrategy implements AlgoritmoStrategy {
    @Override
    public Rifa execute(List<Rifa> rifas) {
        int ganador = (int) Math.floor(Math.random() * rifas.size());
        return rifas.get(ganador);
    }
}
