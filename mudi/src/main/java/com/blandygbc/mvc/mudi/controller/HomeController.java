package com.blandygbc.mvc.mudi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blandygbc.mvc.mudi.model.Pedido;
import com.blandygbc.mvc.mudi.repositories.PedidoRepository;

@Controller
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
