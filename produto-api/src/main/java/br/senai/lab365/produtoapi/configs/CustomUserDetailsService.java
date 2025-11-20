package br.senai.lab365.produtoapi.configs;

import br.senai.lab365.produtoapi.models.Usuario;
import br.senai.lab365.produtoapi.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private UsuarioRepository repository;

  private static List<GrantedAuthority> getAuthorities(final List<String> roles) {
    final List<GrantedAuthority> authorities = new ArrayList<>();
    for (final String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final Usuario usuario = repository.findByEmail(username);

    if (usuario == null) {
      throw new UsernameNotFoundException("usuário não encontrado.");
    }

    return new User(
        usuario.getEmail(), usuario.getSenha(), getAuthorities(List.of(usuario.getRole())));
  }
}
