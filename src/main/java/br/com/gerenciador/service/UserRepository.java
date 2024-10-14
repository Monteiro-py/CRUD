package br.com.gerenciador.service;

import br.com.gerenciador.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public interface UserRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
