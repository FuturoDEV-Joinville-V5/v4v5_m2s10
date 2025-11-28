package br.senai.lab365.produtoapi.mappers;

import br.senai.lab365.produtoapi.dtos.CategoriaRequestDTO;
import br.senai.lab365.produtoapi.dtos.CategoriaResponseDTO;
import br.senai.lab365.produtoapi.models.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {
  Categoria map(CategoriaRequestDTO source);

  CategoriaResponseDTO map(Categoria source);
}
