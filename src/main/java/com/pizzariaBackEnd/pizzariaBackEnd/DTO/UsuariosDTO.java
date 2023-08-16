package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Cargo;
import lombok.Getter;
import lombok.Setter;

public class UsuariosDTO {

    @Getter@Setter
    private Long id;

    @Getter@Setter
    private String nome;

    @Getter@Setter
    private String email;

    @Getter@Setter
    private Cargo cargo;

    public UsuariosDTO(Long id, String nome, String email, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }
}
