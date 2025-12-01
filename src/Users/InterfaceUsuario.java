// Arquivo: InterfaceUsuario.java
package usuarios;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in);

    public double pedirValor() {
        while (true) {
            try {
                System.out.print("Valor do imóvel: ");
                double valor = scanner.nextDouble();
                if (valor > 0) return valor;
                System.out.println("Valor deve ser positivo");
            } catch (Exception e) {
                System.out.println("Digite um número válido");
                scanner.nextLine();
            }
        }
    }

    public int pedirPrazo() {
        while (true) {
            try {
                System.out.print("Prazo (anos): ");
                int prazo = scanner.nextInt();
                if (prazo > 0) return prazo;
                System.out.println("Prazo deve ser positivo");
            } catch (Exception e) {
                System.out.println("Digite um número inteiro");
                scanner.nextLine();
            }
        }
    }

    public double pedirTaxa() {
        while (true) {
            try {
                System.out.print("Taxa de juros anual (%): ");
                double taxa = scanner.nextDouble();
                if (taxa >= 0) return taxa / 100;
                System.out.println("Taxa não pode ser negativa");
            } catch (Exception e) {
                System.out.println("Digite um número válido");
                scanner.nextLine();
            }
        }
    }

    public double pedirAreaConstruida() {
        while (true) {
            try {
                System.out.print("Área construída (m²): ");
                double area = scanner.nextDouble();
                if (area > 0) return area;
                System.out.println("Área deve ser positiva");
            } catch (Exception e) {
                System.out.println("Digite um número válido");
                scanner.nextLine();
            }
        }
    }

    public double pedirAreaTerreno() {
        while (true) {
            try {
                System.out.print("Área do terreno (m²): ");
                double area = scanner.nextDouble();
                if (area > 0) return area;
                System.out.println("Área deve ser positiva");
            } catch (Exception e) {
                System.out.println("Digite um número válido");
                scanner.nextLine();
            }
        }
    }

    public int pedirVagas() {
        while (true) {
            try {
                System.out.print("Vagas na garagem: ");
                int vagas = scanner.nextInt();
                if (vagas >= 0) return vagas;
                System.out.println("Número não pode ser negativo");
            } catch (Exception e) {
                System.out.println("Digite um número inteiro");
                scanner.nextLine();
            }
        }
    }

    public int pedirAndar() {
        while (true) {
            try {
                System.out.print("Andar: ");
                int andar = scanner.nextInt();
                if (andar >= 0) return andar;
                System.out.println("Número não pode ser negativo");
            } catch (Exception e) {
                System.out.println("Digite um número inteiro");
                scanner.nextLine();
            }
        }
    }

    public String pedirZona() {
        while (true) {
            try {
                System.out.print("Tipo de zona: ");
                scanner.nextLine();
                String zona = scanner.nextLine();
                if (!zona.isEmpty()) return zona;
                System.out.println("Digite um tipo de zona");
            } catch (Exception e) {
                System.out.println("Erro na entrada");
            }
        }
    }

    public int escolherTipo() {
        while (true) {
            try {
                System.out.println("1 - Casa");
                System.out.println("2 - Apartamento");
                System.out.println("3 - Terreno");
                System.out.print("Escolha: ");
                int escolha = scanner.nextInt();
                if (escolha >= 1 && escolha <= 3) return escolha;
                System.out.println("Escolha entre 1 e 3");
            } catch (Exception e) {
                System.out.println("Digite 1, 2 ou 3");
                scanner.nextLine();
            }
        }
    }
}