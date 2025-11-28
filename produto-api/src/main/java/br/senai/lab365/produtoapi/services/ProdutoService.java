package br.senai.lab365.produtoapi.services;

import br.senai.lab365.produtoapi.dtos.ProdutoCadastroRequest;
import br.senai.lab365.produtoapi.dtos.ProdutoCadastroResponse;
import br.senai.lab365.produtoapi.dtos.ProdutoResumoResponse;
import br.senai.lab365.produtoapi.mappers.ProdutoMapper;
import br.senai.lab365.produtoapi.models.Produto;
import br.senai.lab365.produtoapi.repositories.CategoriaRepository;
import br.senai.lab365.produtoapi.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final ProdutoRepository repository;
  private final ProdutoMapper mapper;
  private final CategoriaRepository categoriaRespository;

  public ProdutoService(
      final ProdutoRepository repository,
      final ProdutoMapper mapper,
      final CategoriaRepository categoriaRespository) {
    this.repository = repository;
    this.mapper = mapper;
    this.categoriaRespository = categoriaRespository;
  }

  public ProdutoCadastroResponse cadastra(final ProdutoCadastroRequest request) {

    final Produto novoProduto = mapper.map(request);

    final var produtoSalvo = repository.save(novoProduto);
    produtoSalvo.setCategoria(
        categoriaRespository.getReferenceById(produtoSalvo.getCategoria().getId()));

    return mapper.mapToCadastroResponse(produtoSalvo);
  }

  public void atualiza(final ProdutoCadastroRequest request) {

    final Produto produto = mapper.map(request);

    repository.save(produto);
  }

  public List<ProdutoResumoResponse> lista() {
    final List<Produto> produtos = repository.findAll();

    return mapper.map(produtos);
  }

  public ProdutoCadastroResponse buscaProdutoEspecifico(final Long id) {
    return mapper.mapToCadastroResponse(
        repository.findById(id).orElseThrow(EntityNotFoundException::new));
  }
}
