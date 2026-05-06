package com.example.ex2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex2.dto.MensagemDTO;
import com.example.ex2.dto.Veiculo.VeiculoCreateDTO;
import com.example.ex2.dto.Veiculo.VeiculoResponseDTO;
import com.example.ex2.dto.Veiculo.VeiculoUpdateDTO;
import com.example.ex2.service.VeiculoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> salvar(@RequestBody VeiculoCreateDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<VeiculoResponseDTO>> listarDisponiveis() {
        return ResponseEntity.ok(service.listarDisponiveis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar(@PathVariable Long id, @RequestBody VeiculoUpdateDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> remover(@PathVariable Long id) {
        return ResponseEntity.ok(service.remover(id));
    }
}
