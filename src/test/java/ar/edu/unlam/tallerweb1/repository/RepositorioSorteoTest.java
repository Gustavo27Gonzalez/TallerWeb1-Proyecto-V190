package ar.edu.unlam.tallerweb1.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.repositoryImpl.RepositorioSorteoImpl;

public class RepositorioSorteoTest extends SpringTest {

	public static final int CANTIDAD_SORTEOS = 5;
    private RepositorioSorteo repositorioSorteo;

    @Test
    public void alPedirTodosLosSorteosObtengoLaListaCompleta(){
        dadoQueExistenSorteos(CANTIDAD_SORTEOS);
        List<Sorteo> sorteos = cuandoListoSorteos();
        entoncesEncuentro(sorteos, CANTIDAD_SORTEOS);
    }

    private void entoncesEncuentro(List<Sorteo> sorteos, int cantidadSorteosEsperados){
        assertThat(sorteos).hasSize(cantidadSorteosEsperados);
    }

    private List<Sorteo> cuandoListoSorteos(){
        return this.repositorioSorteo.listarSorteos();
    }

    private void dadoQueExistenSorteos(int cantidadSorteos) {
        this.repositorioSorteo = new RepositorioSorteoImpl(sessionFactory);
    }

}
