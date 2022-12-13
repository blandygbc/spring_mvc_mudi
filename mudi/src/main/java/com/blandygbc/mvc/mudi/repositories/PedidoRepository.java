package com.blandygbc.mvc.mudi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blandygbc.mvc.mudi.model.Pedido;
import com.blandygbc.mvc.mudi.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);

}
