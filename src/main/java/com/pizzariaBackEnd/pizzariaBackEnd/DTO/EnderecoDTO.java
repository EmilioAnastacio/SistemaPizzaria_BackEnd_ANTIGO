package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import lombok.Getter;
import lombok.Setter;

public class EnderecoDTO {

    @Getter@Setter
    private Long idCliente;

    @Getter@Setter
    private String nomeRua;

    @Getter@Setter
    private String cep;

    @Getter@Setter
    private String bairro;

    @Getter@Setter
    private int numero;

    @Getter@Setter
    private String complemento;

    public EnderecoDTO(Long idCliente, String nomeRua, String cep, String bairro, int numero, String complemento) {
        this.idCliente = idCliente;
        this.nomeRua = nomeRua;
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }
}
