package ar.edu.unlam.tallerweb1.controller.dtos;

public class DatosRifa {
	
	private Long sorteoId;
	private Long rifaId;
	
	
	public Long getSorteoId() {
		return sorteoId;
	}
	public void setSorteoId(Long sorteoId) {
		this.sorteoId = sorteoId;
	}
	public Long getRifaId() {
		return rifaId;
	}
	public void setRifaId(Long rifaId) {
		this.rifaId = rifaId;
	}
	
	public DatosRifa() {}
	
	public DatosRifa(Long sorteoId, Long rifaId) {
		setSorteoId(sorteoId);
		setRifaId(rifaId);
	}
	

}
