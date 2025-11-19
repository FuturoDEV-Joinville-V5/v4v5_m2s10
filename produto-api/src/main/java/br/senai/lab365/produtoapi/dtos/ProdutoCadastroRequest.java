package br.senai.lab365.produtoapi.dtos;

import jakarta.validation.constraints.NotBlank;

public class ProdutoCadastroRequest {
  @NotBlank private String nome;
  @NotBlank private String descricao;
  @NotBlank private String fabricante;

  public String getNome() {
    return nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(final String descricao) {
    this.descricao = descricao;
  }

  public String getFabricante() {
    return fabricante;
  }

  public void setFabricante(final String fabricante) {
    this.fabricante = fabricante;
  }
}
