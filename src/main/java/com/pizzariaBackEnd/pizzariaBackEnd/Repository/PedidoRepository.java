package com.pizzariaBackEnd.pizzariaBackEnd.Repository;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
