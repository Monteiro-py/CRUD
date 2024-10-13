package br.com.gerenciador.service;

import br.com.gerenciador.model.Objeto;

import jakarta.validation.OverridesAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Repository extends JpaRepository<Objeto, Long> {
    Page<Objeto> findAllByAtivoTrue(Pageable page);
}
