package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "usuario", schema = "public")
public class Usuario{

    @Id
    @Getter@Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @OneToMany
    private List<Endereco> enderecos;

    @Getter@Setter
    @Enumerated(EnumType.STRING)
    @Column(name ="cargo", length =20, nullable =false)
    private Cargo cargo;

    public Usuario(){

    }

    public Usuario(String nome, String cpf, String telefone, String email, String senha, List<Endereco> enderecos, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.enderecos = enderecos;
        this.cargo = cargo;
    }
}
