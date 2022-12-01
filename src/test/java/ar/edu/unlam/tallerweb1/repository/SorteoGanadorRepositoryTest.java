package ar.edu.unlam.tallerweb1.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

import ar.edu.unlam.tallerweb1.service.ServicioRifa;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioRifaImpl;

public class SorteoGanadorRepositoryTest {
	public static final int CANTIDAD_PARTICIPANTES = 3;
	private ServicioRifa servicioRifa;
	private RepositorioRifa repositorioRifa;
	private RepositorioUsuario repositorioUsuario;
	private Usuario usuario;
	
	@Before
	public void init() {
		this.repositorioRifa = mock(RepositorioRifa.class);
		this.repositorioUsuario = mock(RepositorioUsuario.class);
        this.servicioRifa = new ServicioRifaImpl(this.repositorioRifa);
	}

	@Test
	public void siendoQueExisteUnSorteoConRifasVendidasGeneroAlGanador() {
		// Genero el Sorteo
		DatosSorteo datosSorteo = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10, TipoAlgoritmo.RANDOM);
		Usuario creador = createUser();
		Sorteo sorteo = new Sorteo(datosSorteo,creador.getId());
		
		// Genero los Participantes
		List<Usuario> participantes = dadoQueExistenParticipantes(CANTIDAD_PARTICIPANTES);
		
		// Vendo las rifas
		List<Compra> comprasRealizadas = dadoQueExisteUnSorteoVendoLasRifas(sorteo, participantes);
		
		// Genero el sorteo para obtener al ganador
		Usuario ganador = dadoQueRealizoElSorteoParaObtenerAlGanador(comprasRealizadas);
		
		entoncesObtengoUnGanador(ganador);
	}
	
	private void entoncesObtengoUnGanador(Usuario ganador) {
		assertNotNull(ganador);
	}

	private Usuario dadoQueRealizoElSorteoParaObtenerAlGanador(List<Compra> comprasRealizadas) {
		Usuario participanteGanador = new Usuario();
		Integer valor = 0;
		Integer aux = 0;
		Set<Usuario> participantes = new HashSet<>();
		List<Usuario> listosParaElSorteo = new ArrayList<>();
		for(int i=0; i<comprasRealizadas.size(); i++) {
			participantes.add(comprasRealizadas.get(i).getUsuario());
		}
		listosParaElSorteo = (ArrayList<Usuario>) participantes.stream().distinct().collect(Collectors.toList());
		for(int j=0; j<listosParaElSorteo.size(); j++) {
			if( j == 0) {
				participanteGanador = listosParaElSorteo.get(j);
			}
			aux = valor;
			valor = (int)(Math.random()*100+1);
			if(valor > aux) {
				participanteGanador = listosParaElSorteo.get(j);
			}
		}
		return participanteGanador;
	}

	private List<Compra> dadoQueExisteUnSorteoVendoLasRifas(Sorteo sorteo, List<Usuario> participantes) {
		Integer rifas = sorteo.getCantidadRifas();
		List<Compra> ventas = new LinkedList<>();
		Usuario usuario = new Usuario();
		for(int i = 0; i<rifas; i++) {
			Long idRifa = (long)(i);
			Rifa nueva = new Rifa(idRifa, false, sorteo);
			if(i <= 5) {
				usuario = participantes.get(0);
			}else {
				if(i < 9) {
					usuario = participantes.get(1);
				}else {
					usuario = participantes.get(2);
				}
			}
			Compra compra = new Compra(nueva, usuario);
			ventas.add(compra);
			dadoQueExisteUnSorteoConUnaRifaYLaQuieroComprar(compra);
			Compra compraExitosa = cuandoQuieroComprarUnNumeroDeUnaRifa(compra);
			entoncesLaCompraEsExitosa(compraExitosa);
		}
		return ventas;
	}

	private List<Usuario> dadoQueExistenParticipantes(int cantidadParticipantes) {
		List<Usuario> compradores = new LinkedList<>();
		
        for(int i = 0; i<cantidadParticipantes; i++) {
        	Integer posicion = i;
        	String nombre = posicion.toString();
        	Usuario u = new Usuario(nombre);
        	compradores.add(u);
        	this.repositorioUsuario.guardar(u);
        }    
        when(this.repositorioUsuario.listarUsuarios()).thenReturn(compradores);
        return compradores;
	}

	private void dadoQueExisteUnSorteoConUnaRifaYLaQuieroComprar(Compra compra) {
		when(this.repositorioRifa.comprar(compra)).thenReturn(compra);
	}

	private Compra cuandoQuieroComprarUnNumeroDeUnaRifa(Compra compra) {
		return this.servicioRifa.comprarRifa(compra);
		
	}

	private void entoncesLaCompraEsExitosa(Compra compraExitosa) {
		assertThat(compraExitosa).isNotNull();
	}

	private Usuario createUser() {
		this.usuario.setId(1L);
		this.usuario.setNombre("Agustin");
		this.usuario.setEmail("agustin@test.com");
		this.usuario.setGanoUnSorteoYa(Boolean.FALSE);
		return this.usuario;
	}
}