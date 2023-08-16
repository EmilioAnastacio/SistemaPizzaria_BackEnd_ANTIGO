package com.pizzariaBackEnd.pizzariaBackEnd.Repository;

import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {
}
