package com.pizzariaBackEnd.pizzariaBackEnd.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

public class ItemSabor extends AbstractEntity{

    @Getter@Setter
    @ManyToOne
    @JoinColumn(name="idItem", nullable = false)
    private Item idItem;

    @Getter@Setter
    @ManyToOne
    @JoinColumn(name="idSabor", nullable = false)
    private Sabor idSabor;
}
