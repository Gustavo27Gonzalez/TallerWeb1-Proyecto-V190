package ar.edu.unlam.tallerweb1.service.serviceImpl.strategy;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.service.ServicioCompra;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlgoritmoMayorCompradorStrategy implements AlgoritmoStrategy {
    @Autowired
    private ServicioCompra servicioCompra;

    public void AlgoritmoMayorCompradorStrategy(ServicioCompra servicioCompra) {
        this.servicioCompra = servicioCompra;
    }

    @Override
    public Rifa execute(List<Rifa> rifas) {
        int ganador = (int) Math.floor(Math.random() * rifas.size());
        return rifas.get(ganador);
//        try {
//            Long sorteoId = rifas.get(0).getId();
//            List<Compra> compras = this.servicioCompra.getComprasSorteo(sorteoId);
//            List<RifasPorUsuarioEnSorteo> rifasPorUsuario = new ArrayList<>();
//
//            compras.forEach(compra -> {
//                RifasPorUsuarioEnSorteo item = null;
//                boolean estaEnRifasPorUsuario = elUsuarioYaEstaEnLaLista(compra, rifasPorUsuario);
//                if (estaEnRifasPorUsuario) {
//                    item = rifasPorUsuario.stream().filter(rifasPorUsuarioEnSorteo -> {
//                        return rifasPorUsuarioEnSorteo.usuarioId == compra.getUsuario().getId();
//                    }).findAny().get();
//                    item.addInRifas(compra.getRifa());
//                }
//                else {
//                    RifasPorUsuarioEnSorteo nueva =new RifasPorUsuarioEnSorteo(compra.getUsuario().getId());
//                    nueva.addInRifas(compra.getRifa());
//                    rifasPorUsuario.add(nueva);
//                }
//            });
//
//            return usuarioConMasRifasCompradas(rifasPorUsuario);
//        }
//        catch (Exception e) {
//            throw new RuntimeException("Error al encontrar ganador con algoritmo mayor comprador: " + e);
//        }
    }

}
