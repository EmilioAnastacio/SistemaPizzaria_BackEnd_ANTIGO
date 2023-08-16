package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Tamanho;
import lombok.Getter;
import lombok.Setter;

public class ItemDTO {

    @Getter@Setter
    private Long idPedido;

    @Getter@Setter
    private Tamanho tamanho;

    public ItemDTO(Long idPedido, Tamanho tamanho) {
        this.idPedido = idPedido;
        this.tamanho = tamanho;
    }
}
