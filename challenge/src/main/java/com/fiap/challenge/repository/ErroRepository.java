package com.fiap.challenge.repository;

import com.fiap.challenge.entity.Erro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long> {
}
