package ar.edu.unlam.tallerweb1.models;

import javax.persistence.*;

@Entity
@Table(name = "sorteo")
public class Sorteo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSorteo;
    private String nombreSorteo;
    private String descripcion;
    private Double precio;
    private Integer cantidadRifas;
    private Premio premio;

    public Integer getIdSorteo() {
        return idSorteo;
    }

    public void setIdSorteo(Integer idSorteo) {
        this.idSorteo = idSorteo;
    }

    public String getNombreSorteo() {
        return nombreSorteo;
    }

    public void setNombreSorteo(String nombreSorteo) {
        this.nombreSorteo = nombreSorteo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidadRifas() {
        return cantidadRifas;
    }

    public void setCantidadRifas(Integer cantidadRifas) {
        this.cantidadRifas = cantidadRifas;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }
}
