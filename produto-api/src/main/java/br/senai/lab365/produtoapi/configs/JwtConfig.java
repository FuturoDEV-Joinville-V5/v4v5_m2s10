package br.senai.lab365.produtoapi.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {
  // Chave precisa ser Muito forte
  private final String SECRET_KEY =
      "chaveParaJWTPrecisaSerRealmenteMuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuitoForte";

  // Gera a chave para assinar o token
  private Key getSignInKey() {
    final byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String generateToken(final String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // -> 1 hora
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public Jws<Claims> parseClaims(final String token) {
    return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token);
  }

  public String extractUsername(final String token) {
    return parseClaims(token).getBody().getSubject();
  }

  public boolean validateToken(final String token) {
    try {
      parseClaims(token);
      return true;
    } catch (final JwtException | IllegalArgumentException e) {
      return false;
    }
  }
}
