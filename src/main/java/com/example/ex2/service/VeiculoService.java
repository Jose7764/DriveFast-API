package com.example.ex2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex2.dto.MensagemDTO;
import com.example.ex2.dto.Veiculo.VeiculoCreateDTO;
import com.example.ex2.dto.Veiculo.VeiculoResponseDTO;
import com.example.ex2.dto.Veiculo.VeiculoUpdateDTO;
import com.example.ex2.mapper.VeiculoMapper;
import com.example.ex2.model.Veiculo;
import com.example.ex2.repository.VeiculoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository repository;
    private final VeiculoMapper mapper;

    public VeiculoResponseDTO salvar(VeiculoCreateDTO dto) {
        Veiculo veiculo = mapper.toEntity(dto);
        return mapper.toResponseDTO(repository.save(veiculo));
    }

    public List<VeiculoResponseDTO> listar() {
        return repository.findAll()
            .stream()
            .map(mapper::toResponseDTO)
            .toList();
    }

    public List<VeiculoResponseDTO> listarDisponiveis() {
        return repository.findByDisponivel(true)
            .stream()
            .map(mapper::toResponseDTO)
            .toList();
    }

    public VeiculoResponseDTO buscarPorId(Long id) {
        Veiculo veiculo = repository.findById(id).get();
        return mapper.toResponseDTO(veiculo);
    }

    public VeiculoResponseDTO atualizar(Long id, VeiculoUpdateDTO dto) {
        Veiculo veiculo = repository.findById(id).get();
        veiculo.setValorDiaria(dto.valorDiaria());
        return mapper.toResponseDTO(repository.save(veiculo));
    }

    public MensagemDTO remover(Long id) {
        repository.deleteById(id);
        return new MensagemDTO("Veiculo removido com sucesso!");
    }
}
