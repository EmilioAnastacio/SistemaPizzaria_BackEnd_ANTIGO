package com.pizzariaBackEnd.pizzariaBackEnd.DTO;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Estado;
import lombok.Getter;
import lombok.Setter;

public class PedidoDTO {

    @Getter@Setter
    private Long idCliente;

    @Getter@Setter
    private Long idFuncionario;

    @Getter@Setter
    private boolean delivery;

    @Getter@Setter
    private String observacao;

    @Getter@Setter
    private Estado estado;

    public PedidoDTO(Long idCliente, Long idFuncionario, boolean delivery, String observacao, Estado estado) {
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.delivery = delivery;
        this.observacao = observacao;
        this.estado = estado;
    }
}
