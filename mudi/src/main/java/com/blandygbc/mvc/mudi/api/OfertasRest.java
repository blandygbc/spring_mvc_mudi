package com.blandygbc.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
        Long id = requisicao.getId();
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(id);
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
