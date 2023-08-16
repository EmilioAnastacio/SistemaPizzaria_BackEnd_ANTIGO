package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import lombok.Getter;
import lombok.Setter;

public class SaborDTO {

    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    private String nome;

    public SaborDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public SaborDTO() {
    }


}
