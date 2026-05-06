package com.example.ex2.dto.Locacao;

public record LocacaoCreateDTO(
    long clienteId,
    long veiculoId,
    Integer dias
) {
}
