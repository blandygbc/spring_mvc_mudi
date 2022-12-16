package com.blandygbc.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blandygbc.mvc.mudi.dto.RequisicaoNovaOferta;
import com.blandygbc.mvc.mudi.model.Oferta;
import com.blandygbc.mvc.mudi.model.Pedido;
import com.blandygbc.mvc.mudi.repositories.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(RequisicaoNovaOferta requisicao) {
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getId());
        if (!pedidoBuscado.isPresent()) {
            return null;
        }
        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedidoBuscado.get());
        pedidoBuscado.get().getOfertas().add(nova);
        pedidoRepository.save(pedidoBuscado.get());
        return nova;
    }
}
