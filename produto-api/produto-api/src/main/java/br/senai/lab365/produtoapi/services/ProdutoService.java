package br.senai.lab365.produtoapi.services;

import br.senai.lab365.produtoapi.dtos.ProdutoCadastroRequest;
import br.senai.lab365.produtoapi.dtos.ProdutoCadastroResponse;
import br.senai.lab365.produtoapi.dtos.ProdutoResumoResponse;
import br.senai.lab365.produtoapi.mappers.ProdutoMapper;
import br.senai.lab365.produtoapi.models.Produto;
import br.senai.lab365.produtoapi.repositories.ProdutoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final ProdutoRepository repository;
  private final ProdutoMapper mapper;

  public ProdutoService(final ProdutoRepository repository, final ProdutoMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public ProdutoCadastroResponse cadastra(final ProdutoCadastroRequest request) {

    final Produto novoProduto = mapper.map(request);

    return mapper.mapToCadastroResponse(repository.save(novoProduto));
  }

  public void atualiza(final ProdutoCadastroRequest request) {

    final Produto produto = mapper.map(request);

    repository.save(produto);
  }

  public List<ProdutoResumoResponse> lista() {
    final List<Produto> produtos = repository.findAll();

    return mapper.map(produtos);
  }
}
