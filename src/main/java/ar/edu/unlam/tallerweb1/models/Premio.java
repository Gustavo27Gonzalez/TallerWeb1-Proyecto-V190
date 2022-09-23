package ar.edu.unlam.tallerweb1.models;

import javax.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSorteo;
    private Enum premio;

    public Integer getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(Integer idSorteo) {
        this.idSorteo = idSorteo;
    }

    public Enum getPremio() {
        return premio;
    }

    public void setPremio(Enum premio) {
        this.premio = premio;
    }
}
