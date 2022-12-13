package com.blandygbc.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blandygbc.mvc.mudi.dto.RequisicaoNovoPedido;
import com.blandygbc.mvc.mudi.model.Pedido;
import com.blandygbc.mvc.mudi.model.StatusPedido;
import com.blandygbc.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {

        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = requisicao.toPedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
