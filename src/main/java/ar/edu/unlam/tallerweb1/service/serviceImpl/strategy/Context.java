package ar.edu.unlam.tallerweb1.service.serviceImpl.strategy;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

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
