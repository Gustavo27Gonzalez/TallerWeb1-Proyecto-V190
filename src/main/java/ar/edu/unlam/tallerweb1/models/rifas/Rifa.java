package ar.edu.unlam.tallerweb1.models.rifas;

import java.util.Objects;

import javax.persistence.*;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

@Entity (name="rifa")
public class Rifa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rifa_id")
	private Long id;
	private Boolean fueVendida = false;
	private Boolean esGanadora = false;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sorteo_id")
	private Sorteo sorteo;

	@OneToOne(mappedBy = "rifa")
	private Compra compra;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getFueVendida() {
		return fueVendida;
	}
	public void setFueVendida(Boolean fueVendida) {
		this.fueVendida = fueVendida;
	}
	
	public Rifa() {
		
	}
	
	public Rifa(Long id, Boolean fueVendida, Sorteo sorteo) {
		this.id = id;
		this.fueVendida = fueVendida;
		this.sorteo = sorteo;
	}
	// Constructor para controlar si la rifa fue vendida
	public Rifa(Long id, Boolean fueVendida) {
		this.id = id;
		this.fueVendida = fueVendida;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(compra, fueVendida, id, sorteo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rifa other = (Rifa) obj;
		return Objects.equals(compra, other.compra) && Objects.equals(fueVendida, other.fueVendida)
				&& Objects.equals(id, other.id) && Objects.equals(sorteo, other.sorteo);
	}

	public void setEsGanadora(boolean esGanadora) {
		this.esGanadora = esGanadora;
	}
    public boolean esRifaGanadora() {
		return this.esGanadora;
    }
}