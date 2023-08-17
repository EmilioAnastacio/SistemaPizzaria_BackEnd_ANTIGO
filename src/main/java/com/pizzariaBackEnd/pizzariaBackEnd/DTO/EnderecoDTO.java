package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EnderecoDTO {

    //@Getter@Setter
    //private Usuario idCliente;
    @Getter@Setter
    private Long id;

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

    @Getter@Setter
    private Usuario usuario;

    public EnderecoDTO(){

    }

    public EnderecoDTO(Long id,String nomeRua, String cep, String bairro, int numero, String complemento, Usuario usuarioDTO) {
        this.id = id;
        this.nomeRua = nomeRua;
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.usuario = usuarioDTO;
    }
}
