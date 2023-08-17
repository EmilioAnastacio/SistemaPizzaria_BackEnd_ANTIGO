package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Item;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class SaborDTO {

    @Getter@Setter
    private Long id;

    @Getter@Setter
    private String nome;

    @Getter@Setter
    private List<Item> item;

    public SaborDTO(Long id, String nome, List<Item> item) {
        this.id = id;
        this.nome = nome;
        this.item = item;
    }

    public SaborDTO() {
    }


}
