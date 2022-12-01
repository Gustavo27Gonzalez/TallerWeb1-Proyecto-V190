package ar.edu.unlam.tallerweb1.service.serviceImpl;

import ar.edu.unlam.tallerweb1.service.serviceImpl.strategy.AlgoritmoMayorCompradorStrategy;
import ar.edu.unlam.tallerweb1.service.serviceImpl.strategy.AlgoritmoPreseleccionadoStrategy;
import ar.edu.unlam.tallerweb1.service.serviceImpl.strategy.AlgoritmoRandomStrategy;
import ar.edu.unlam.tallerweb1.service.serviceImpl.strategy.Context;
import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class ServicioAlgoritmo {
    private Context context;
    private TipoAlgoritmo tipoAlgoritmo;

    public void ServicioAlgoritmo() {
        this.tipoAlgoritmo = TipoAlgoritmo.RANDOM;
    }

    public Rifa getGanador(List<Rifa> rifas) {
        context = new Context();
        //TODO pasar esto a map, USAR EQUALS
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