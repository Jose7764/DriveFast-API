package com.example.ex2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex2.dto.Locacao.LocacaoCreateDTO;
import com.example.ex2.dto.Locacao.LocacaoResponseDTO;
import com.example.ex2.dto.MensagemDTO;
import com.example.ex2.service.LocacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/locacoes")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService service;

    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> salvar(@RequestBody LocacaoCreateDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<LocacaoResponseDTO>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.listarPorCliente(clienteId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> remover(@PathVariable Long id) {
        return ResponseEntity.ok(service.remover(id));
    }
}
