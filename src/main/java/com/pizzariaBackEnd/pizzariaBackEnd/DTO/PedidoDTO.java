package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Estado;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PedidoDTO {

    @Getter@Setter
    private Long id;

    @Getter@Setter
    private Usuario idCliente;

    @Getter@Setter
    private Usuario idFuncionario;

    @Getter@Setter
    private String nome;

    @Getter@Setter
    private Boolean delivery;

    @Getter@Setter
    private String observacao;

    @Getter@Setter
    private String estado;

    public PedidoDTO(){

    }

    public PedidoDTO(Long id,Usuario idCliente, Usuario idFuncionario,String nome, Boolean delivery, String observacao, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.delivery = delivery;
        this.observacao = observacao;
        this.estado = estado;
    }

}
