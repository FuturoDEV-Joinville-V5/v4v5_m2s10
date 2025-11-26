package br.senai.lab365.produtoapi.services;

import br.senai.lab365.produtoapi.configs.JwtConfig;
import br.senai.lab365.produtoapi.dtos.LoginRequestDto;
import br.senai.lab365.produtoapi.dtos.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired private JwtConfig jwtConfig;
  @Autowired private AuthenticationManager authenticationManager;

  public LoginResponseDto autentica(final LoginRequestDto request) {
    final Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

    if (authentication == null || !authentication.isAuthenticated()) {
      throw new BadCredentialsException("Invalid username or password");
    }

    final String token = jwtConfig.generateToken(request.getUsername());
    return new LoginResponseDto("Bearer", token);
  }
}
