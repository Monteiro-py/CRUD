package br.com.gerenciador.controller;

import br.com.gerenciador.objetoDTO.UsuarioDTO;
import br.com.gerenciador.user.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity login(@RequestBody UsuarioDTO usuarioDTO){
        var token= new UsernamePasswordAuthenticationToken(usuarioDTO.login(),usuarioDTO.senha());
        var autenticacao=manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
