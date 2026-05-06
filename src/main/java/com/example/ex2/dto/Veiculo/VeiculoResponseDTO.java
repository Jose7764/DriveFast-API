package com.example.ex2.dto.Veiculo;

import java.math.BigDecimal;

public record VeiculoResponseDTO(
    long id,
    String marca,
    String modelo,
    String placa,
    BigDecimal valorDiaria,
    Boolean disponivel
) {
}