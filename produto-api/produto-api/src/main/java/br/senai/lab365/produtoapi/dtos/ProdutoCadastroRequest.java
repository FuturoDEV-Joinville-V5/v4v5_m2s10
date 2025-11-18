package br.senai.lab365.produtoapi.dtos;

public class ProdutoCadastroRequest {
  private String nome;
  private String descricao;
  private String fabricante;
  private Double peso;

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

  public Double getPeso() {
    return peso;
  }

  public void setPeso(final Double peso) {
    this.peso = peso;
  }
}
