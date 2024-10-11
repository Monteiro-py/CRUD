package br.com.gerenciador.service;

import br.com.gerenciador.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Objeto, Long> {
}
