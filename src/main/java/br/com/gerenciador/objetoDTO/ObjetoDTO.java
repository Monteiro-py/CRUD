package br.com.gerenciador.objetoDTO;

import br.com.gerenciador.Objeto;

public record ObjetoDTO(Long id, String produto, String valor, String data) {

    public ObjetoDTO(Objeto n) {
        this(n.getId(),n.getProduto(),n.getValor(),n.getData());
    }



}
