package com.pizzariaBackEnd.pizzariaBackEnd.Repository;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.ItemSabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSaborRepository extends JpaRepository<ItemSabor, Long> {
}
