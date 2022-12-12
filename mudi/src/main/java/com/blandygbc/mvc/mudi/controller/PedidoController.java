package com.blandygbc.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blandygbc.mvc.mudi.dto.RequisicaoNovoPedido;
import com.blandygbc.mvc.mudi.model.Pedido;
import com.blandygbc.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario() {

        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novo(RequisicaoNovoPedido requisicaoNovoPedido) {
        Pedido pedido = requisicaoNovoPedido.toPedido();
        pedidoRepository.save(pedido);
        return "pedido/formulario";
    }
}
