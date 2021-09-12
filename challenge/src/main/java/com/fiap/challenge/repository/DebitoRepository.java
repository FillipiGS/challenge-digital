package com.fiap.challenge.repository;

import com.fiap.challenge.entity.Debito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitoRepository extends JpaRepository<Debito, Long> {
}
