package com.example.ex2.dto.Veiculo;

import java.math.BigDecimal;

public record VeiculoCreateDTO(
    String marca,
    String modelo,
    String placa,
    BigDecimal valorDiaria
) {
}
