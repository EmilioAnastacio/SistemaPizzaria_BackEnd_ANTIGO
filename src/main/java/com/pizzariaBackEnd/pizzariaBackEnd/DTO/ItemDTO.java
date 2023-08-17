package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Pedido;
import lombok.Getter;
import lombok.Setter;

public class ItemDTO {

    @Getter@Setter
    private Pedido idPedido;

    @Getter@Setter
    private String tamanho;

    public ItemDTO(Pedido idPedido, String tamanho) {
        this.idPedido = idPedido;
        this.tamanho = tamanho;
    }
}
