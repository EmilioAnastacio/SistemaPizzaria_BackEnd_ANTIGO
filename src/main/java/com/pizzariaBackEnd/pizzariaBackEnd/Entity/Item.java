package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item", schema = "public")
public class Item extends AbstractEntity{

    @Getter@Setter
    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido idPedido;

    @Getter@Setter
    @JoinColumn(name = "idTamanho", nullable = false)
    private Tamanho tamanho;


    @Getter@Setter
    @Column(name = "observacao", nullable = false, length = 500)
    private  String observacao;
}
