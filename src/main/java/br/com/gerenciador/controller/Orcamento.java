package br.com.gerenciador.controller;

import br.com.gerenciador.model.Objeto;

import java.util.List;


public class Orcamento {
    String produto;
    Double valor;
    String data;

    public Orcamento(String produto, String valor, String data) {
    this.produto=produto;
    this.valor=Double.valueOf(valor);
    this.data=data;
    }

    @Override
    public String toString() {
        return "produto: "+produto+'\n'+"valor: "+valor+'\n'+"data: "+data;
    }
}
