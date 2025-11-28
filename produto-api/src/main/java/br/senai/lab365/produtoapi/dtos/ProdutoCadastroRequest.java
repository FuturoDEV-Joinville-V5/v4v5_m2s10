package br.senai.lab365.produtoapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoCadastroRequest {
  @NotBlank private String nome;
  @NotBlank private String descricao;
  @NotBlank private String fabricante;
  @NotNull @Positive private Long categoriaId;

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

  public @NotNull Long getCategoriaId() {
    return categoriaId;
  }

  public void setCategoriaId(@NotNull @Positive final Long categoriaId) {
    this.categoriaId = categoriaId;
  }
}
