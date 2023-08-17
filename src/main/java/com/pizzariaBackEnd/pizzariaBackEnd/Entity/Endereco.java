package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "endereco", schema = "public")
public class Endereco{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Getter@Setter
    @ManyToOne
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

    public Endereco() {
    }

}
