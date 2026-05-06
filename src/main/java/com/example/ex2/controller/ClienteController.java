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
import com.example.ex2.dto.Cliente.ClienteCreateDTO;
import com.example.ex2.dto.Cliente.ClienteResponseDTO;
import com.example.ex2.dto.Cliente.ClienteUpdateDTO;
import com.example.ex2.projection.ClienteGastoProjection;
import com.example.ex2.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(@RequestBody ClienteCreateDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @RequestBody ClienteUpdateDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> remover(@PathVariable Long id) {
        return ResponseEntity.ok(service.remover(id));
    }

    @GetMapping("/relatorio-gastos")
    public ResponseEntity<List<ClienteGastoProjection>> relatorioGastos() {
        return ResponseEntity.ok(service.relatorioGastos());
    }
}
