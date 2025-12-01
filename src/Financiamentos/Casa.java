// Arquivo: Casa.java
package Financiamentos;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double areaTerreno;
    private double seguro = 80;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual,
                double areaConstruida, double areaTerreno) throws AumentoMaiorDoQueJurosException {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;

        double pagamentoBase = getValorImovel() / (getPrazoFinanciamento() * 12);
        double jurosMensal = pagamentoBase * getTaxaJurosMensal();

        if (seguro > jurosMensal / 2) {
            throw new AumentoMaiorDoQueJurosException("Seguro muito alto");
        }
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoBase = getValorImovel() / (getPrazoFinanciamento() * 12);
        double juros = pagamentoBase * getTaxaJurosMensal();
        return pagamentoBase + juros + seguro;
    }

    @Override
    public String formatarParaArquivoTexto() {
        return String.format("Casa;%.2f;%d;%.4f;%.2f;%.2f;%.2f",
                getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(),
                areaConstruida, areaTerreno, seguro);
    }
}