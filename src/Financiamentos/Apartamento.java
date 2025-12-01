// Arquivo: Apartamento.java
package Financiamentos;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int andar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                       int vagasGaragem, int andar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.andar = andar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosMensal();
        int meses = getPrazoFinanciamento() * 12;
        double potencia = Math.pow(1 + taxaMensal, meses);
        return getValorImovel() * (taxaMensal * potencia) / (potencia - 1);
    }

    @Override
    public String formatarParaArquivoTexto() {
        return String.format("Apartamento;%.2f;%d;%.4f;%d;%d",
                getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(),
                vagasGaragem, andar);
    }
}