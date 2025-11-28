package br.senai.lab365.produtoapi.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(@NotBlank String nome, @NotBlank String descricao) {}
