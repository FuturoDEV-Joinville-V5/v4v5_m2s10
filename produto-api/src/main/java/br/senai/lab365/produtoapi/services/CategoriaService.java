package br.senai.lab365.produtoapi.services;

import br.senai.lab365.produtoapi.dtos.CategoriaRequestDTO;
import br.senai.lab365.produtoapi.dtos.CategoriaResponseDTO;
import br.senai.lab365.produtoapi.mappers.CategoriaMapper;
import br.senai.lab365.produtoapi.repositories.CategoriaRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  private final CategoriaRepository repository;
  private final CategoriaMapper mapper;

  public CategoriaService(final CategoriaRepository repository, final CategoriaMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public CategoriaResponseDTO cadastra(final CategoriaRequestDTO request) {

    if (repository.existsByNome(request.nome())) {
      throw new DuplicateKeyException("Já existe categoria com esse nome.");
    }

    return mapper.map(repository.save(mapper.map(request)));
  }
}
