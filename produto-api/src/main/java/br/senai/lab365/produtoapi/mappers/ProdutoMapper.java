package br.senai.lab365.produtoapi.mappers;

import br.senai.lab365.produtoapi.dtos.ProdutoCadastroRequest;
import br.senai.lab365.produtoapi.dtos.ProdutoCadastroResponse;
import br.senai.lab365.produtoapi.dtos.ProdutoResumoResponse;
import br.senai.lab365.produtoapi.models.Produto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProdutoMapper {

  ProdutoResumoResponse map(final Produto source);

  List<ProdutoResumoResponse> map(final List<Produto> source);

  Produto map(final ProdutoCadastroRequest source);

  ProdutoCadastroResponse mapToCadastroResponse(Produto source);
}
