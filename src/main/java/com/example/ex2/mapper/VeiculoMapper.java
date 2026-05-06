package com.example.ex2.mapper;

import org.springframework.stereotype.Component;

import com.example.ex2.dto.Veiculo.VeiculoCreateDTO;
import com.example.ex2.dto.Veiculo.VeiculoResponseDTO;
import com.example.ex2.model.Veiculo;

@Component
public class VeiculoMapper {

    public Veiculo toEntity(VeiculoCreateDTO dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(dto.marca());
        veiculo.setModelo(dto.modelo());
        veiculo.setPlaca(dto.placa());
        veiculo.setValorDiaria(dto.valorDiaria());
        veiculo.setDisponivel(true);
        return veiculo;
    }

    public VeiculoResponseDTO toResponseDTO(Veiculo veiculo) {
        return new VeiculoResponseDTO(
            veiculo.getId(),
            veiculo.getMarca(),
            veiculo.getModelo(),
            veiculo.getPlaca(),
            veiculo.getValorDiaria(),
            veiculo.getDisponivel()
        );
    }
}
