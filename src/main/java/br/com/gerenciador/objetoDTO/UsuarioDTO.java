package br.com.gerenciador.objetoDTO;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(

                         String login,

                         String senha) {
}
