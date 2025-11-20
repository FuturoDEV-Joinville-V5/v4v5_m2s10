package br.senai.lab365.produtoapi.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UsuarioCadastroDTO {

  @NotBlank private String nome;

  @NotBlank @Email private String email;

  @NotBlank
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
  private String senha;

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
}
