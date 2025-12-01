// Arquivo: Terreno.java
package Financiamentos;

public class Terreno extends Financiamento {
    private String tipoZona;
    private double acrescimo = 0.02;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                   String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        int meses = getPrazoFinanciamento() * 12;
        double pagamentoBase = getValorImovel() / meses;
        double juros = pagamentoBase * getTaxaJurosMensal();
        return (pagamentoBase + juros) * (1 + acrescimo);
    }

    @Override
    public String formatarParaArquivoTexto() {
        return String.format("Terreno;%.2f;%d;%.4f;%s;%.4f",
                getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(),
                tipoZona, acrescimo);
    }
}