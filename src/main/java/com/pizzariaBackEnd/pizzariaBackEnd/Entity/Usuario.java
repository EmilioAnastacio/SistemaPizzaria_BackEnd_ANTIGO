package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario", schema = "public")
public class Usuario extends AbstractEntity{

    @Getter@Setter
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Getter@Setter
    @Column(name = "cpf", nullable = false, unique = true,length = 14)
    private String cpf;

    @Getter@Setter
    @Column(name = "nome", nullable = false, unique = true,length = 16)
    private String telefone;

    @Getter@Setter
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Getter@Setter
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @Getter@Setter
    @Enumerated(EnumType.STRING)
    @Column(name ="cargo", length =20, nullable =false)
    private Cargo cargo;

}
