package com.example.ex2.mapper;

import org.springframework.stereotype.Component;

import com.example.ex2.dto.Cliente.ClienteCreateDTO;
import com.example.ex2.dto.Cliente.ClienteResponseDTO;
import com.example.ex2.model.Cliente;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteCreateDTO dto) {
        return new Cliente(
            dto.nome(),
            dto.cnh(),
            dto.email()
        );
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCnh(),
            cliente.getEmail()
        );
    }
}
