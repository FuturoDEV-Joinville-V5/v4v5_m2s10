package br.senai.lab365.produtoapi.configs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

  @Autowired private JwtConfig jwtConfig;

  @Autowired private CustomUserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final FilterChain filterChain)
      throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");

    String jwt = null;
    String username = null;
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      jwt = authHeader.substring(7);
      username = jwtConfig.extractUsername(jwt);
    }

    final SecurityContext context = SecurityContextHolder.getContext();
    if (username != null && context.getAuthentication() == null) {
      final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

      if (jwtConfig.validateToken(jwt)) {
        final UsernamePasswordAuthenticationToken authToken =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        context.setAuthentication(authToken);
      }
    }
    filterChain.doFilter(request, response);
  }
}
