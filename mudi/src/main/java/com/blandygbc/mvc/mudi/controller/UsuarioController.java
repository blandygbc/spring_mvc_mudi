package com.blandygbc.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blandygbc.mvc.mudi.model.Pedido;
import com.blandygbc.mvc.mudi.model.StatusPedido;
import com.blandygbc.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("pedido")
    public String home(Model model, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName());
        model.addAttribute("pedidos", pedidos);
        return "usuario/meus_pedidos";
    }

    @GetMapping("pedido/{status}")
    public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findByStatusAndUser(StatusPedido.valueOf(status.toUpperCase()),
                principal.getName());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "usuario/meus_pedidos";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/meus_pedidos";
    }
}
