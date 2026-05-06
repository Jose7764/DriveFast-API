package com.example.ex2.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ex2.dto.Locacao.LocacaoCreateDTO;
import com.example.ex2.dto.Locacao.LocacaoResponseDTO;
import com.example.ex2.dto.MensagemDTO;
import com.example.ex2.mapper.LocacaoMapper;
import com.example.ex2.model.Cliente;
import com.example.ex2.model.Locacao;
import com.example.ex2.model.Veiculo;
import com.example.ex2.repository.ClienteRepository;
import com.example.ex2.repository.LocacaoRepository;
import com.example.ex2.repository.VeiculoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final LocacaoRepository repository;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;
    private final LocacaoMapper mapper;

    @Transactional
    public LocacaoResponseDTO salvar(LocacaoCreateDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId()).get();
        Veiculo veiculo = veiculoRepository.findById(dto.veiculoId()).get();

        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setVeiculo(veiculo);
        locacao.setDias(dto.dias());
        locacao.setValorTotal(veiculo.getValorDiaria().multiply(BigDecimal.valueOf(dto.dias())));

        veiculo.setDisponivel(false);
        veiculoRepository.save(veiculo);

        return mapper.toResponseDTO(repository.save(locacao));
    }

    public List<LocacaoResponseDTO> listar() {
        return repository.findAll()
            .stream()
            .map(mapper::toResponseDTO)
            .toList();
    }

    public List<LocacaoResponseDTO> listarPorCliente(Long clienteId) {
        return repository.buscarPorClienteId(clienteId)
            .stream()
            .map(mapper::toResponseDTO)
            .toList();
    }

    @Transactional
    public MensagemDTO remover(Long id) {
        Locacao locacao = repository.findById(id).get();
        Veiculo veiculo = locacao.getVeiculo();
        veiculo.setDisponivel(true);
        veiculoRepository.save(veiculo);
        repository.delete(locacao);
        return new MensagemDTO("Veiculo devolvido e locacao encerrada!");
    }
}
