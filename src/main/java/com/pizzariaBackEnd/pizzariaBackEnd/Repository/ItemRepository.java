package com.pizzariaBackEnd.pizzariaBackEnd.Repository;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
