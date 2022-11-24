package ar.edu.unlam.tallerweb1.models.algoritmo;

import ar.edu.unlam.tallerweb1.models.algoritmo.strategy.AlgoritmoMayorCompradorStrategy;
import ar.edu.unlam.tallerweb1.models.algoritmo.strategy.AlgoritmoPreseleccionadoStrategy;
import ar.edu.unlam.tallerweb1.models.algoritmo.strategy.AlgoritmoRandomStrategy;
import ar.edu.unlam.tallerweb1.models.algoritmo.strategy.Context;
import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity(name="algoritmo")

public class Algoritmo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    //TODO como hago ???
    private Context context;
    private TipoAlgoritmo tipoAlgoritmo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void Algoritmo() {
        this.context = new Context();
        this.tipoAlgoritmo = TipoAlgoritmo.RANDOM;
    }

    public Rifa getGanador(List<Rifa> rifas) {
        //TODO pasar esto a map
        if(tipoAlgoritmo == TipoAlgoritmo.RANDOM) {
            this.context.setStrategy(new AlgoritmoRandomStrategy());
        }
        else if(tipoAlgoritmo == TipoAlgoritmo.MAYORCOMPRADOR) {
            this.context.setStrategy(new AlgoritmoMayorCompradorStrategy());
        }
        else if(tipoAlgoritmo == TipoAlgoritmo.PRESELECCIONADO) {
            this.context.setStrategy(new AlgoritmoPreseleccionadoStrategy());
        }
        return this.context.execute(rifas);
    }

    public void setTipo(TipoAlgoritmo tipo) {
        this.tipoAlgoritmo = tipo;
    }

    public TipoAlgoritmo getTipoAlgoritmo() {
        return this.tipoAlgoritmo;
    }
}