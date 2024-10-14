package br.com.gerenciador.objetoDTO;


import lombok.Getter;

public class Orcamento {
    private String produto;
    @Getter
    private Double valor;
    private String data;

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
