// Arquivo: Financiamento.java
package Financiamentos;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosAnual / 12;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotal() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public abstract String formatarParaArquivoTexto();
}