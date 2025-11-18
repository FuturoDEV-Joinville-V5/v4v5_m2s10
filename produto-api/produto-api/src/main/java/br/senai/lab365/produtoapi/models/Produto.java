package br.senai.lab365.produtoapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;
  private String descricao;
  private String fabricante;
  private double preco;
  private int qtdEstoque;
  private double peso;

  public Produto() {}

  public Produto(final String nome, final String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public long getId() {
    return id;
  }

  public void setId(final long id) {
    this.id = id;
  }

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

  public double getPreco() {
    return preco;
  }

  public void setPreco(final double preco) {
    this.preco = preco;
  }

  public int getQtdEstoque() {
    return qtdEstoque;
  }

  public void setQtdEstoque(final int qtdEstoque) {
    this.qtdEstoque = qtdEstoque;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(final double peso) {
    this.peso = peso;
  }
}
