package ar.edu.unlam.tallerweb1.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public class CompraRepositoryTest {
	
	@Autowired
	private RepositorioCompra repositorioCompra;
	private Usuario usuario = new Usuario();
	
	@Test @Transactional @Commit
	public void alTerminarDeRealizarLaCompraLaMismaEsGuardadaEnLaBaseDeDatos() {
		Compra nueva = dadoQueTengoUnaCompraListaParaSerPersistida();
		cuandoLaCompraYaEsFinalizadaEntoncesLaMismaSeGuardaEnLaBaseDeDatos(nueva);
		entoncesPuedoBuscarLaRifaGuardadaYValidarQueFueExitosaLaPersistencia(nueva);
	}

	private Compra dadoQueTengoUnaCompraListaParaSerPersistida() {
		Rifa rifa = new Rifa(1L, false);
		usuario = createUser();
		DatosCompra datosCompra = new DatosCompra(rifa, usuario);
		return new Compra(datosCompra);
	}

	private Usuario createUser() {
		this.usuario.setId(1L);
		this.usuario.setNombre("Agustin");
		this.usuario.setEmail("agustin@test.com");
		this.usuario.setGanoUnSorteoYa(Boolean.FALSE);
		return this.usuario;
	}

	private void cuandoLaCompraYaEsFinalizadaEntoncesLaMismaSeGuardaEnLaBaseDeDatos(Compra compra) {
		repositorioCompra.guardarCompra(compra);
	}

	private void entoncesPuedoBuscarLaRifaGuardadaYValidarQueFueExitosaLaPersistencia(Compra compra) {
		Compra buscada = this.repositorioCompra.findCompraById(compra);
		assertEquals(buscada.getId(), compra.getId());
	}

}
