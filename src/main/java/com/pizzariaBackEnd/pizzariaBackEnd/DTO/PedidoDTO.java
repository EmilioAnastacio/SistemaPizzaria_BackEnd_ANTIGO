package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Estado;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Usuario;
import lombok.Getter;
import lombok.Setter;

public class PedidoDTO {

    @Getter@Setter
    private Usuario idCliente;

    @Getter@Setter
    private Usuario idFuncionario;

    @Getter@Setter
    private String nome;

    @Getter@Setter
    private boolean delivery;

    @Getter@Setter
    private String observacao;

    @Getter@Setter
    private Estado estado;

    public PedidoDTO(Usuario idCliente, Usuario idFuncionario,String nome, boolean delivery, String observacao, Estado estado) {
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.delivery = delivery;
        this.observacao = observacao;
        this.estado = estado;
    }
}
