package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedido", schema = "public")
public class Pedido extends AbstractEntity{

    @Getter@Setter
    @JoinColumn(name = "idFuncionario", nullable = false)
    private Usuario idFuncionario;

    @JoinColumn(name = "idCliente", nullable = false)
    @Getter@Setter
    private Usuario idCliente;

    @Getter@Setter
    @JoinColumn(name = "estado", nullable = false)
    private Estado estado;

    @Getter@Setter
    @Column(name = "delivey", nullable = false)
    private boolean delivery;

    @Getter@Setter
    @Column(name = "observacao", nullable = false)
    private String observacao;

}
