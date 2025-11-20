package br.senai.lab365.produtoapi.mappers;

import br.senai.lab365.produtoapi.dtos.UsuarioCadastroDTO;
import br.senai.lab365.produtoapi.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

  public Usuario map(UsuarioCadastroDTO source);
}
