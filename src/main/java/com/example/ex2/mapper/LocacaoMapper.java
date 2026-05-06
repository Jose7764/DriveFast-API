package com.example.ex2.mapper;

import org.springframework.stereotype.Component;

import com.example.ex2.dto.Locacao.LocacaoResponseDTO;
import com.example.ex2.model.Locacao;

@Component
public class LocacaoMapper {

    public LocacaoResponseDTO toResponseDTO(Locacao locacao) {
        return new LocacaoResponseDTO(
            locacao.getId(),
            locacao.getDias(),
            locacao.getValorTotal(),
            locacao.getCliente().getNome(),
            locacao.getVeiculo().getModelo()
        );
    }
}
