package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item", schema = "public")
public class Item{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Getter@Setter
    @ManyToOne
    //@JoinColumn(name = "idPedido", nullable = false)
    private Pedido idPedido;

    @Getter@Setter
    private String tamanho;

    @ManyToMany
    @JoinTable(name = "item_sabor", joinColumns = @JoinColumn(name = "idSabor"), inverseJoinColumns = @JoinColumn(name = "idItem"))
    private List<Sabor> sabor = new ArrayList<>();

    public Item() {

    }

    public Item(Pedido idPedido, String tamanho) {
        this.idPedido = idPedido;
        this.tamanho = tamanho;
    }
}
