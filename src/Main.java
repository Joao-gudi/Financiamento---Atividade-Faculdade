// Arquivo: Main.java
import Financiamentos.*;
import usuarios.InterfaceUsuario;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario ui = new InterfaceUsuario();
        ArrayList<Financiamento> lista = new ArrayList<>();

        System.out.println("Sistema de Financiamentos");
        System.out.println("==========================");

        // Cadastrar alguns financiamentos fixos para teste
        try {
            lista.add(new Casa(300000, 20, 0.08, 150, 200));
            System.out.println("Casa 1 cadastrada");
        } catch (Exception e) {
            System.out.println("Erro na casa 1: " + e.getMessage());
        }

        lista.add(new Apartamento(250000, 15, 0.09, 2, 5));
        System.out.println("Apartamento 1 cadastrado");

        lista.add(new Terreno(150000, 10, 0.12, "residencial"));
        System.out.println("Terreno 1 cadastrado");

        // Cadastrar financiamento com dados do usuário
        System.out.println("\nCadastrar novo financiamento:");
        int tipo = ui.escolherTipo();
        double valor = ui.pedirValor();
        int prazo = ui.pedirPrazo();
        double taxa = ui.pedirTaxa();

        try {
            switch (tipo) {
                case 1:
                    double areaConst = ui.pedirAreaConstruida();
                    double areaTerr = ui.pedirAreaTerreno();
                    lista.add(new Casa(valor, prazo, taxa, areaConst, areaTerr));
                    System.out.println("Nova casa cadastrada");
                    break;
                case 2:
                    int vagas = ui.pedirVagas();
                    int andar = ui.pedirAndar();
                    lista.add(new Apartamento(valor, prazo, taxa, vagas, andar));
                    System.out.println("Novo apartamento cadastrado");
                    break;
                case 3:
                    String zona = ui.pedirZona();
                    lista.add(new Terreno(valor, prazo, taxa, zona));
                    System.out.println("Novo terreno cadastrado");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }

        // Mostrar detalhes
        System.out.println("\nDetalhes dos Financiamentos:");
        for (int i = 0; i < lista.size(); i++) {
            Financiamento f = lista.get(i);
            System.out.println("\nFinanciamento " + (i+1) + ":");
            System.out.println("Tipo: " + f.getClass().getSimpleName());
            System.out.println("Valor: R$" + f.getValorImovel());
            System.out.println("Prazo: " + f.getPrazoFinanciamento() + " anos");
            System.out.println("Taxa: " + (f.getTaxaJurosAnual()*100) + "%");
            System.out.println("Mensal: R$" + f.calcularPagamentoMensal());
            System.out.println("Total: R$" + f.calcularTotal());
        }

        // Salvar em arquivo texto
        System.out.println("\nSalvando em arquivo texto...");
        try {
            PrintWriter writer = new PrintWriter("financiamentos.txt");
            for (Financiamento f : lista) {
                writer.println(f.formatarParaArquivoTexto());
            }
            writer.close();
            System.out.println("Arquivo 'financiamentos.txt' salvo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo texto: " + e.getMessage());
        }

        // Ler arquivo texto
        System.out.println("\nLendo arquivo texto...");
        try {
            Scanner arquivo = new Scanner(new File("financiamentos.txt"));
            System.out.println("Conteúdo do arquivo:");
            while (arquivo.hasNextLine()) {
                System.out.println(arquivo.nextLine());
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

        // Salvar serializado
        System.out.println("\nSalvando serializado...");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financiamentos.dat"));
            oos.writeObject(lista);
            oos.close();
            System.out.println("Arquivo 'financiamentos.dat' salvo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar serializado: " + e.getMessage());
        }

        // Ler serializado
        System.out.println("\nLendo arquivo serializado...");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financiamentos.dat"));
            ArrayList<Financiamento> listaRecuperada = (ArrayList<Financiamento>) ois.readObject();
            ois.close();

            System.out.println("Financiamentos recuperados: " + listaRecuperada.size());
            for (Financiamento f : listaRecuperada) {
                System.out.println("Tipo: " + f.getClass().getSimpleName() +
                        " | Valor: R$" + f.getValorImovel() +
                        " | Mensal: R$" + f.calcularPagamentoMensal());
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler serializado: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado!");
    }
}