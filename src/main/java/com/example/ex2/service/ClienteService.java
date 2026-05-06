package com.example.ex2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex2.dto.Cliente.ClienteCreateDTO;
import com.example.ex2.dto.Cliente.ClienteResponseDTO;
import com.example.ex2.dto.Cliente.ClienteUpdateDTO;
import com.example.ex2.dto.MensagemDTO;
import com.example.ex2.mapper.ClienteMapper;
import com.example.ex2.model.Cliente;
import com.example.ex2.projection.ClienteGastoProjection;
import com.example.ex2.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteResponseDTO salvar(ClienteCreateDTO dto) {
        Cliente cliente = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(cliente));
    }

    public List<ClienteResponseDTO> listar() {
        return repository.findAll()
            .stream()
            .map(mapper::toResponseDTO)
            .toList();
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).get();
        return mapper.toResponseDTO(cliente);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteUpdateDTO dto) {
        Cliente cliente = repository.findById(id).get();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        return mapper.toResponseDTO(repository.save(cliente));
    }

    public MensagemDTO remover(Long id) {
        repository.deleteById(id);
        return new MensagemDTO("Cliente removido com sucesso!");
    }

    public List<ClienteGastoProjection> relatorioGastos() {
        return repository.relatorioGastos();
    }
}
