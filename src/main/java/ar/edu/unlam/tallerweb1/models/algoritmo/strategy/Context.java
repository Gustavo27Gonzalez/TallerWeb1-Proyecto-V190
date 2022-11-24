package ar.edu.unlam.tallerweb1.models.algoritmo.strategy;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

public class Context {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private AlgoritmoStrategy context;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Context() {}

    public void setStrategy(AlgoritmoStrategy context) {
        this.context = context;
    }

    public Rifa execute(List<Rifa> rifas) {
        if (this.context == null) {
            throw new RuntimeException("Algoritmo Strategy is not set");
        }

        return this.context.execute(rifas);
    }
}
