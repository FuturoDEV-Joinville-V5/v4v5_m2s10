package br.senai.lab365.produtoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(name = "email", unique = true)
  private String email;

  private String senha;

  private String role;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(final String senha) {
    this.senha = senha;
  }

  public String getRole() {
    return role;
  }

  public void setRole(final String role) {
    this.role = role;
  }
}
