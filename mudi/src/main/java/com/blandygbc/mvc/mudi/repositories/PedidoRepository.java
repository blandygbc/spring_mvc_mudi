package com.blandygbc.mvc.mudi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blandygbc.mvc.mudi.model.Pedido;
import com.blandygbc.mvc.mudi.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);

    @Query("select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUser(@Param("username") String username);

}
