package br.com.gerenciador.model;

import br.com.gerenciador.objetoDTO.ObjetoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Objeto")
@Table(name="objects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String produto;
    private String valor;
    private String data;
    private Boolean ativo;

    public Objeto(ObjetoDTO objetoDTO) {
        this.ativo=true;
        this.produto=objetoDTO.produto();
        this.valor= objetoDTO.valor();
        this.data= objetoDTO.data();
    }

    public void atualizar(ObjetoDTO objetoDTO){
        if(this.produto!=null){
            this.produto=objetoDTO.produto();
        }
        if(this.valor!=null){
            this.produto=objetoDTO.produto();
        }
        if(this.data!=null){
            this.data=objetoDTO.data();
        }
    }

    public void exclusaoLogica(){
        this.ativo=false;
    }


    @Override
    public String toString() {
        return "produto: "+produto+'\n'+
                "valor: "+valor+'\n'+
                "data: "+data;

    }
}
