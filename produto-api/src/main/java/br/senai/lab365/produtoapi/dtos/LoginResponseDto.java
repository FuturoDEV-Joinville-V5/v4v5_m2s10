package br.senai.lab365.produtoapi.dtos;

public class LoginResponseDto {
  private String type;
  private String token;

  public LoginResponseDto() {}

  public LoginResponseDto(final String type, final String token) {
    this.type = type;
    this.token = token;
  }

  public String getType() {
    return type;
  }

  public void setType(final String type) {
    this.type = type;
  }

  public String getToken() {
    return token;
  }

  public void setToken(final String token) {
    this.token = token;
  }
}
