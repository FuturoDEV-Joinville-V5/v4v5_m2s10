package br.senai.lab365.produtoapi.controllers;

import br.senai.lab365.produtoapi.dtos.CategoriaRequestDTO;
import br.senai.lab365.produtoapi.dtos.CategoriaResponseDTO;
import br.senai.lab365.produtoapi.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  private final CategoriaService service;

  public CategoriaController(final CategoriaService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<CategoriaResponseDTO> cadastra(
      @Valid @RequestBody final CategoriaRequestDTO request) {
    return new ResponseEntity<>(service.cadastra(request), HttpStatus.CREATED);
  }
}
