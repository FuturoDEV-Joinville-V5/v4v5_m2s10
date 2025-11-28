package br.senai.lab365.produtoapi.dtos;

public class ErrorDTO {
  private String mensagem;

  public ErrorDTO() {}

  public ErrorDTO(final String mensagem) {
    this.mensagem = mensagem;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(final String mensagem) {
    this.mensagem = mensagem;
  }
}
