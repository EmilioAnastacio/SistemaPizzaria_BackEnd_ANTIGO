package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sabor", schema = "public")
public class Sabor{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter@Setter
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @ManyToMany(mappedBy = "sabor")
    private List<Item> item = new ArrayList<>();

    public Sabor(){

    }

    public Sabor(String nome){
        this.nome = nome;
    }
}
