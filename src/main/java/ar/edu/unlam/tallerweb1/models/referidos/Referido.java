package ar.edu.unlam.tallerweb1.models.referidos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.models.enums.TipoDocumento;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

@Entity (name="referido")
public class Referido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "referido_id")
	private Long id;
	private Integer nroDocumento;
	@Enumerated(value = EnumType.STRING)
	private TipoDocumento tipoDocumento;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario referidoPor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Usuario getReferidoPor() {
		return referidoPor;
	}
	public void setReferidoPor(Usuario referidoPor) {
		this.referidoPor = referidoPor;
	}
	
	public Referido() {}
	

}
