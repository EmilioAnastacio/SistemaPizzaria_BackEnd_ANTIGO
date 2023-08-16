package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import lombok.Getter;
import lombok.Setter;

public class ItemSaborDTO {

    @Getter@Setter
    private Long idItem;

    @Getter@Setter
    private Long idSabor;

    public ItemSaborDTO(Long idItem, Long idSabor) {
        this.idItem = idItem;
        this.idSabor = idSabor;
    }
}
