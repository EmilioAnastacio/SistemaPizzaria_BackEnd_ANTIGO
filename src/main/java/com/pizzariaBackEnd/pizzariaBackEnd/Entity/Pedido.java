package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "pedido", schema = "public")
public class Pedido{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Getter@Setter
    @JoinColumn(name = "idFuncionario", nullable = false)
    private Usuario idFuncionario;

    @JoinColumn(name = "idCliente", nullable = false)
    @Getter@Setter
    private Usuario idCliente;

    @Getter@Setter
    @Column(name = "nome")
    private String nome;

    @Getter@Setter
    private String estado;//feito,andamento,entregue

    @Getter@Setter
    @Column(name = "delivey", nullable = false)
    private Boolean delivery;//balcao ou delivery

    @Getter@Setter
    @Column(name = "observacao", nullable = false)
    private String observacao;

    public Pedido() {
    }

    public Pedido(Usuario idFuncionario, Usuario idCliente,String nome, String estado, Boolean delivery, String observacao) {
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.nome = nome;
        this.estado = estado;
        this.delivery = delivery;
        this.observacao = observacao;
    }
}
