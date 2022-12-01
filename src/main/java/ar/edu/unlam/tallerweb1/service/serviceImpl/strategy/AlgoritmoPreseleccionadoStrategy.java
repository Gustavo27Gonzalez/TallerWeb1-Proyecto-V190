package ar.edu.unlam.tallerweb1.service.serviceImpl.strategy;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

import java.util.List;

public class AlgoritmoPreseleccionadoStrategy implements AlgoritmoStrategy {
    @Override
    public Rifa execute(List<Rifa> rifas) {
        //Rifa rifaGandora = rifas.stream().filter((rifa)-> rifa.esRifaGanadora()).findFirst().get();
        //if(rifaGandora == null){
            int ganador = (int) Math.floor(Math.random() * rifas.size());
            return rifas.get(ganador);
        //}
       // return rifaGandora;
    }
}
