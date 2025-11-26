package br.senai.lab365.produtoapi.controllers;

import br.senai.lab365.produtoapi.dtos.LoginRequestDto;
import br.senai.lab365.produtoapi.dtos.LoginResponseDto;
import br.senai.lab365.produtoapi.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthService service;

  public AuthController(final AuthService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<LoginResponseDto> autentica(
      @Valid @RequestBody final LoginRequestDto request) {

    return ResponseEntity.ok(service.autentica(request));
  }
}
