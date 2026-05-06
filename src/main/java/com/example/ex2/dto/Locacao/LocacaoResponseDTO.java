package com.example.ex2.dto.Locacao;

import java.math.BigDecimal;

public record LocacaoResponseDTO(
    long id,
    Integer dias,
    BigDecimal valorTotal,
    String nomeCliente,
    String modeloVeiculo
) {
}
