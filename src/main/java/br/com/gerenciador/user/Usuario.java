package br.com.gerenciador.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Usuario")
@Table(name="usuarios")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String longin;
    private String senha;
}
