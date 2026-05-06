package com.example.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ex2.model.Cliente;
import com.example.ex2.projection.ClienteGastoProjection;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    @Query(value = """
        SELECT c.nome AS nomeCliente, COALESCE(SUM(l.valor_total), 0) AS totalGasto
        FROM cliente c
        LEFT JOIN locacao l ON l.cliente_id = c.id
        GROUP BY c.id, c.nome
        """, nativeQuery = true)
    java.util.List<ClienteGastoProjection> relatorioGastos();
}
