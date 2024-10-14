package br.com.gerenciador.objetoDTO;


public record Orcamento {
    String produto;
    Double valor;
    String data;

    public Double getValor() {
        return valor;
    }

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
