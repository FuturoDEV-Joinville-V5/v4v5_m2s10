package br.senai.lab365.produtoapi.services;

import br.senai.lab365.produtoapi.dtos.UsuarioCadastroDTO;
import br.senai.lab365.produtoapi.mappers.UsuarioMapper;
import br.senai.lab365.produtoapi.models.Usuario;
import br.senai.lab365.produtoapi.repositories.UsuarioRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  private final UsuarioRepository repository;
  private final UsuarioMapper mapper;
  private final PasswordEncoder encoder;

  public UsuarioService(
      final UsuarioRepository repository,
      final UsuarioMapper mapper,
      final PasswordEncoder encoder) {
    this.repository = repository;
    this.mapper = mapper;
    this.encoder = encoder;
  }

  public void cadastra(final UsuarioCadastroDTO request) {
    if (emailJaExiste(request.getEmail())) {
      throw new DuplicateKeyException("e-mail já cadastrado.");
    }

    final Usuario novoUsuario = mapper.map(request);
    novoUsuario.setSenha(encoder.encode(novoUsuario.getSenha()));
    novoUsuario.setRole("ROLE_USER");

    repository.save(novoUsuario);
  }

  private boolean emailJaExiste(final String email) {
    return repository.existsByEmail(email);
  }
}
