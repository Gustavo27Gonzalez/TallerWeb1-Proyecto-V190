package ar.edu.unlam.tallerweb1.models.referidos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Referido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDoc;
	private TipoDocumento tipoDocumento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(Integer numeroDoc) {
		this.numeroDoc = numeroDoc;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	

}
