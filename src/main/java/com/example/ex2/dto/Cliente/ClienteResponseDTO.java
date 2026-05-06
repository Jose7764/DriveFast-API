package com.example.ex2.dto.Cliente;

public record ClienteResponseDTO(
    long id,
    String nome,
    String cnh, 
    String email
) {
    
}
