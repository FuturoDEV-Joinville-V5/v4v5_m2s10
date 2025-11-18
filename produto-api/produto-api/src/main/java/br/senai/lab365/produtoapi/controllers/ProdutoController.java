package br.senai.lab365.produtoapi.controllers;

import br.senai.lab365.produtoapi.dtos.ProdutoCadastroRequest;
import br.senai.lab365.produtoapi.dtos.ProdutoCadastroResponse;
import br.senai.lab365.produtoapi.dtos.ProdutoResumoResponse;
import br.senai.lab365.produtoapi.services.ProdutoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

  private final ProdutoService service;

  public ProdutoController(final ProdutoService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<ProdutoCadastroResponse> cadastra(
      @Valid @RequestBody final ProdutoCadastroRequest request) {
    return new ResponseEntity<>(service.cadastra(request), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ProdutoResumoResponse>> lista() {
    return ResponseEntity.ok(service.lista());
  }
}
