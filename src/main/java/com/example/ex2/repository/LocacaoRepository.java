package com.example.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ex2.model.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

    @Query("SELECT l FROM Locacao l WHERE l.cliente.id = :clienteId")
    java.util.List<Locacao> buscarPorClienteId(@Param("clienteId") Long clienteId);
}
