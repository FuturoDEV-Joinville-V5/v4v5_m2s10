package br.senai.lab365.produtoapi.dtos;

public class ProdutoResumoResponse {

  private String nome;
  private String fabricante;

  public String getNome() {
    return nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getFabricante() {
    return fabricante;
  }

  public void setFabricante(final String fabricante) {
    this.fabricante = fabricante;
  }
}
