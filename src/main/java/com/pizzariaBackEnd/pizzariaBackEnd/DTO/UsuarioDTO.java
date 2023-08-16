package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Cargo;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UsuarioDTO {

    @Getter@Setter
    private Long id;

    @Getter@Setter
    private String nome;

    @Getter@Setter
    private String cpf;

    @Getter@Setter
    private String telefone;

    @Getter@Setter
    private List<Endereco> enderecos;

    public UsuarioDTO(){

    }


    public UsuarioDTO(String nome, String cpf, String telefone,List<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = enderecos;

    }
}
