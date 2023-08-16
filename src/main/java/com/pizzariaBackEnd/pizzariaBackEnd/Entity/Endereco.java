package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco", schema = "public")
public class Endereco extends AbstractEntity{

    @Getter@Setter
    @JoinColumn(name = "idCliente", nullable = false)
    private Usuario idCliente;

    @Getter@Setter
    @Column(name = "nomeRua", nullable = false, length = 100)
    private String nomeRua;

    @Getter@Setter
    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;

    @Getter@Setter
    @Column(name = "cep", nullable = false, length = 100)
    private String cep;

    @Getter@Setter
    @Column(name = "numero", nullable = false, length = 100)
    private int numero;

    @Getter@Setter
    @Column(name = "complemento", length = 100)
    private String complemento;

}
