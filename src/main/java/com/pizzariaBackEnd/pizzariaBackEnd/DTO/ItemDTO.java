package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Pedido;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ItemDTO {

    @Getter@Setter
    private Long id;
    @Getter@Setter
    private Pedido idPedido;

    @Getter@Setter
    private String tamanho;

    public ItemDTO(){

    }

    public ItemDTO(Long id, Pedido idPedido, String tamanho) {
        this.id = id;
        this.idPedido = idPedido;
        this.tamanho = tamanho;
    }
}
