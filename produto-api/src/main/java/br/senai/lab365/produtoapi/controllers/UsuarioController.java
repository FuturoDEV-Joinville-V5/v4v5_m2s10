package br.senai.lab365.produtoapi.controllers;

import br.senai.lab365.produtoapi.dtos.UsuarioCadastroDTO;
import br.senai.lab365.produtoapi.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

  private final UsuarioService service;

  public UsuarioController(final UsuarioService service) {
    this.service = service;
  }

  @ResponseStatus(code = HttpStatus.CREATED)
  @PostMapping
  public void cadastra(@Valid @RequestBody final UsuarioCadastroDTO request) {
    service.cadastra(request);
  }
}
