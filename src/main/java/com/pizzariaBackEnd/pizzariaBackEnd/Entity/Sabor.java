package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sabor", schema = "public")
public class Sabor extends AbstractEntity{

    @Getter@Setter
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
}
