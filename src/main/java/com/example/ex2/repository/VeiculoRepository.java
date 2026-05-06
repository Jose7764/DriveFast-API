package com.example.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ex2.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

    java.util.List<Veiculo> findByDisponivel(Boolean disponivel);
}
