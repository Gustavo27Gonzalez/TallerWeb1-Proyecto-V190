package ar.edu.unlam.tallerweb1.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import ar.edu.unlam.tallerweb1.repository.repositoryImpl.RepositorioRifaImpl;
import ar.edu.unlam.tallerweb1.repository.repositoryImpl.RepositorioUsuarioImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.repositoryImpl.RepositorioCompraImpl;

public class CompraRepositoryTest extends SpringTest{
	
	@Autowired
	private RepositorioCompra repositorioCompra;
	private RepositorioRifa repositorioRifa;
	private RepositorioUsuario repositorioUsuario;
	
	private Usuario usuario = new Usuario();
	
	@Before
	public void init() {
		this.repositorioRifa = new RepositorioRifaImpl(this.sessionFactory);
		this.repositorioUsuario = new RepositorioUsuarioImpl(this.sessionFactory);
		this.repositorioCompra = new RepositorioCompraImpl(this.sessionFactory);
	}
	
	@Test @Transactional //@Commit
	public void alTerminarDeRealizarLaCompraLaMismaEsGuardadaEnLaBaseDeDatos() {
		Compra nueva = dadoQueTengoUnaCompraListaParaSerPersistida();
		cuandoLaCompraYaEsFinalizadaEntoncesLaMismaSeGuardaEnLaBaseDeDatos(nueva);
		entoncesPuedoBuscarLaRifaGuardadaYValidarQueFueExitosaLaPersistencia(nueva);
	}

	private Compra dadoQueTengoUnaCompraListaParaSerPersistida() {
		Rifa rifa = new Rifa();
		rifa.setFueVendida(Boolean.FALSE);
		this.repositorioRifa.comprar(rifa);
		usuario = createUser();
		this.repositorioUsuario.guardar(usuario);
		DatosCompra datosCompra = new DatosCompra(rifa, usuario);
		return new Compra(datosCompra);
	}

	private Usuario createUser() {
//		this.usuario.setId(1L);
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
