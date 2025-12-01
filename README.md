# 🏦 Sistema de Financiamentos Imobiliários

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![POO](https://img.shields.io/badge/Programa%C3%A7%C3%A3o-Orientada%20a%20Objetos-blue)
![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen)

Sistema completo para simulação e gerenciamento de financiamentos imobiliários desenvolvido em Java, aplicando conceitos avançados de Programação Orientada a Objetos.

## 📋 Índice

- [Visão Geral](#-visão-geral)
- [Funcionalidades](#-funcionalidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Instalação e Execução](#-instalação-e-execução)
- [Tipos de Financiamento](#️-tipos-de-financiamento)
- [Persistência de Dados](#-persistência-de-dados)
- [Tratamento de Exceções](#-tratamento-de-exceções)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Fluxo do Programa](#-fluxo-do-programa)
- [Contribuição](#-contribuição)

## 🎯 Visão Geral

Este projeto implementa um sistema robusto para cálculo e gerenciamento de diferentes tipos de financiamentos imobiliários, incluindo:
- **Casas** com seguro mensal
- **Apartamentos** com sistema de amortização
- **Terrenos** com acréscimo de risco

O sistema foi desenvolvido seguindo boas práticas de programação e inclui persistência de dados em múltiplos formatos.

## ✨ Funcionalidades

### ✅ Principais Características

| Funcionalidade | Descrição |
|----------------|-----------|
| **Cálculos Financeiros** | Pagamento mensal e total para cada tipo |
| **Persistência Dupla** | Salva em arquivo texto e serializado |
| **Tratamento de Erros** | Validação completa de entradas |
| **Interface Interativa** | Menu intuitivo para usuários |
| **Relatórios Detalhados** | Exibição completa dos financiamentos |

### 📊 Recursos Técnicos
- **Herança e Polimorfismo**: Classes especializadas herdam de `Financiamento`
- **Encapsulamento**: Atributos privados com métodos de acesso
- **Abstração**: Classe base abstrata com métodos abstratos
- **Exceções Personalizadas**: Tratamento específico para regras de negócio

## 📁 Estrutura do Projeto
financiamentos/
├── Financiamento.java # Classe abstrata base
├── Casa.java # Financiamento para casas
├── Apartamento.java # Financiamento para apartamentos
├── Terreno.java # Financiamento para terrenos
├── AumentoMaiorDoQueJurosException.java # Exceção personalizada
└── usuarios/
└── InterfaceUsuario.java # Interface com o usuário

Main.java # Programa principal

text

### Descrição dos Arquivos

| Arquivo | Responsabilidade |
|---------|-----------------|
| `Financiamento.java` | Define estrutura comum a todos os financiamentos |
| `Casa.java` | Implementa financiamento específico para casas |
| `Apartamento.java` | Implementa financiamento para apartamentos |
| `Terreno.java` | Implementa financiamento para terrenos |
| `InterfaceUsuario.java` | Gerencia interação com o usuário |
| `Main.java` | Controla fluxo principal do programa |

## 🚀 Instalação e Execução

### Pré-requisitos

- Java Development Kit (JDK) 8 ou superior
- Terminal ou prompt de comando
- (Opcional) IDE como IntelliJ IDEA, Eclipse ou VSCode

### Passo a Passo

1. **Clone ou baixe o projeto**
```bash
git clone [url-do-repositorio]
cd financiamentos
Compile todas as classes

bash
javac financiamentos/*.java usuarios/*.java Main.java
Execute o programa

bash
java Main
Compilação Avançada
bash
# Compilar com opções específicas
javac -encoding UTF-8 -d . financiamentos/*.java usuarios/*.java Main.java

# Executar com mais memória (opcional)
java -Xmx512m Main
🏗️ Tipos de Financiamento
🏠 Casa
java
Casa casa = new Casa(300000, 20, 0.08, 150, 200);
Atributos específicos:

areaConstruida: Área construída em m²

areaTerreno: Área total do terreno em m²

Cálculo: PagamentoBase + Juros + Seguro(R$80)

Exceção: Lança erro se seguro > 50% dos juros

🏢 Apartamento
java
Apartamento apto = new Apartamento(250000, 15, 0.09, 2, 5);
Atributos específicos:

vagasGaragem: Número de vagas na garagem

andar: Número do andar

Cálculo: Sistema Price (prestações fixas)

Fórmula: Valor * [(i*(1+i)^n)/((1+i)^n-1)]

🌳 Terreno
java
Terreno terreno = new Terreno(150000, 10, 0.12, "residencial");
Atributos específicos:

tipoZona: "residencial" ou "comercial"

Cálculo: (PagamentoBase + Juros) * 1.02

Acréscimo: 2% para risco

💾 Persistência de Dados
📄 Arquivo Texto (financiamentos.txt)
Formato por linha:

text
Tipo;ValorImovel;Prazo;TaxaJuros;Atributo1;Atributo2;Atributo3
Exemplos:

text
Casa;300000.00;20;0.0800;150.00;200.00;80.00
Apartamento;250000.00;15;0.0900;2;5
Terreno;150000.00;10;0.1200;residencial;0.0200
💿 Arquivo Serializado (financiamentos.dat)
Salva o objeto ArrayList<Financiamento> completo

Mantém todos os métodos e atributos

Recuperação exata dos objetos

Código de Persistência
java
// Salvar em texto
PrintWriter writer = new PrintWriter("financiamentos.txt");
for (Financiamento f : lista) {
    writer.println(f.formatarParaArquivoTexto());
}
writer.close();

// Salvar serializado
ObjectOutputStream oos = new ObjectOutputStream(
    new FileOutputStream("financiamentos.dat")
);
oos.writeObject(lista);
oos.close();
🚨 Tratamento de Exceções
Exceções Implementadas
Exceção	Quando Ocorre	Tratamento
InputMismatchException	Entrada não numérica	Solicita nova entrada
IllegalArgumentException	Valores inválidos (negativos)	Mensagem específica
AumentoMaiorDoQueJurosException	Seguro muito alto	Oferece alternativa
Exceção Personalizada
java
public class AumentoMaiorDoQueJurosException extends Exception {
    public AumentoMaiorDoQueJurosException(String mensagem) {
        super(mensagem);
    }
}

// Uso na classe Casa
if (seguro > jurosMensal / 2) {
    throw new AumentoMaiorDoQueJurosException(
        "Seguro muito alto comparado aos juros"
    );
}
Validações Implementadas
Valores Positivos

java
if (valor <= 0) {
    throw new IllegalArgumentException("Valor deve ser positivo");
}
Taxas Não Negativas

java
if (taxa < 0) {
    throw new IllegalArgumentException("Taxa não pode ser negativa");
}
Entradas Válidas

java
try {
    int opcao = scanner.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Digite um número válido");
    scanner.nextLine(); // Limpa buffer
}
💻 Exemplos de Uso
Exemplo 1: Cadastro Completo
java
// Criar interface de usuário
InterfaceUsuario ui = new InterfaceUsuario();

// Coletar dados
double valor = ui.pedirValorImovel();
int prazo = ui.pedirPrazoFinanciamento();
double taxa = ui.pedirTaxaJurosAnual();

// Criar financiamento baseado no tipo
switch (tipoEscolhido) {
    case 1: // Casa
        Casa casa = new Casa(valor, prazo, taxa, 
                            ui.pedirAreaConstruida(), 
                            ui.pedirAreaTerreno());
        break;
    // ... outros casos
}
Exemplo 2: Cálculos Financeiros
java
// Para qualquer financiamento
Financiamento fin = lista.get(0);
double mensal = fin.calcularPagamentoMensal();
double total = fin.calcularTotal();
int anos = fin.getPrazoFinanciamento();

System.out.println("Pagamento mensal: R$ " + mensal);
System.out.println("Total a pagar: R$ " + total);
System.out.println("Prazo: " + anos + " anos");
Exemplo 3: Salvamento e Recuperação
java
// Salvar dados
salvarFinanciamentos(lista, "financiamentos.txt");

// Recuperar dados
ArrayList<Financiamento> recuperados = 
    carregarFinanciamentos("financiamentos.dat");

// Verificar integridade
if (lista.size() == recuperados.size()) {
    System.out.println("Dados recuperados com sucesso!");
}
🔄 Fluxo do Programa


















Passos Detalhados
Inicialização

Carrega dados salvos (se existirem)

Configura interface do usuário

Cadastro

Seleção do tipo de financiamento

Entrada de dados com validação

Criação do objeto apropriado

Processamento

Cálculo de pagamentos mensais

Cálculo do total financiado

Geração de relatórios

Persistência

Salvamento em arquivo texto

Salvamento serializado

Confirmação de sucesso

Saída

Exibição de resultados

Opção para novos cadastros

Encerramento gracioso

🧪 Casos de Teste
Teste 1: Casa com Seguro Alto
java
// Deve lançar exceção
try {
    Casa casa = new Casa(100000, 5, 0.05, 100, 150);
    // Seguro R$80 > Metade dos juros
} catch (AumentoMaiorDoQueJurosException e) {
    System.out.println("Exceção esperada: " + e.getMessage());
}
Teste 2: Valores Inválidos
java
// Interface deve rejeitar
double valor = ui.pedirValorImovel();
// Usuário digita "-100" → Deve solicitar novamente
// Usuário digita "abc" → Deve solicitar novamente
// Usuário digita "500000" → Aceito
Teste 3: Persistência
java
// Criar lista
ArrayList<Financiamento> original = new ArrayList<>();
original.add(new Casa(300000, 20, 0.08, 150, 200));

// Salvar
salvarFinanciamentos(original, "teste.dat");

// Carregar
ArrayList<Financiamento> recuperado = carregarFinanciamentos("teste.dat");

// Verificar
assert original.size() == recuperado.size();
assert original.get(0).getValorImovel() == 
       recuperado.get(0).getValorImovel();
📈 Cálculos Financeiros
Fórmulas Implementadas
Taxa Mensal

text
taxaMensal = taxaAnual / 12
Casa (Sistema Linear)

text
pagamentoBase = valorImovel / (prazo * 12)
jurosMensal = pagamentoBase * taxaMensal
totalMensal = pagamentoBase + jurosMensal + seguro
Apartamento (Sistema Price)

text
meses = prazo * 12
potencia = (1 + taxaMensal) ^ meses
prestacao = valorImovel * (taxaMensal * potencia) / (potencia - 1)
Terreno (Com Acréscimo)

text
pagamentoBase = valorImovel / (prazo * 12)
jurosMensal = pagamentoBase * taxaMensal
totalMensal = (pagamentoBase + jurosMensal) * 1.02
🔧 Personalização
Adicionar Novo Tipo de Financiamento
Criar nova classe:

java
public class NovoFinanciamento extends Financiamento {
    private String novoAtributo;
    
    public NovoFinanciamento(double valor, int prazo, 
                            double taxa, String atributo) {
        super(valor, prazo, taxa);
        this.novoAtributo = atributo;
    }
    
    @Override
    public double calcularPagamentoMensal() {
        // Implementar cálculo específico
    }
    
    @Override
    public String formatarParaArquivoTexto() {
        return String.format("Novo;%.2f;%d;%.4f;%s",
            getValorImovel(), getPrazoFinanciamento(),
            getTaxaJurosAnual(), novoAtributo);
    }
}
Atualizar InterfaceUsuario:

java
public int escolherTipoFinanciamento() {
    // Adicionar nova opção
    System.out.println("4 - Novo Financiamento");
    // ...
}
Atualizar Main:

java
switch (tipo) {
    case 4:
        // Coletar dados específicos
        // Criar objeto NovoFinanciamento
        break;
}
Modificar Parâmetros
java
// Para modificar o seguro da casa
public class Casa extends Financiamento {
    // Tornar seguro configurável
    private double seguro;
    
    public Casa(double valor, int prazo, double taxa,
                double areaConst, double areaTerr,
                double seguro) {  // Novo parâmetro
        // ...
        this.seguro = seguro;
    }
}
🐛 Solução de Problemas
Problemas Comuns
Problema	Causa	Solução
Erro de compilação	JDK não instalado	Instalar Java JDK 8+
Arquivo não encontrado	Caminho incorreto	Verificar diretório atual
Entrada não reconhecida	Buffer sujo	Adicionar scanner.nextLine()
Dados não salvos	Permissões de arquivo	Verificar permissões de escrita
Debugging
java
// Adicionar logs para debug
System.out.println("DEBUG: Valor digitado = " + valor);
System.out.println("DEBUG: Criando objeto...");

// Verificar tamanho da lista
System.out.println("DEBUG: Lista tem " + lista.size() + " itens");

// Verificar salvamento
File arquivo = new File("financiamentos.txt");
System.out.println("DEBUG: Arquivo existe? " + arquivo.exists());
System.out.println("DEBUG: Tamanho: " + arquivo.length() + " bytes");
📚 Aprendizados do Projeto
Conceitos de POO Aplicados
Abstração: Classe Financiamento como modelo geral

Encapsulamento: Atributos privados com getters

Herança: Classes específicas estendem a base

Polimorfismo: Métodos sobrescritos em cada subclasse

Boas Práticas Implementadas
Tratamento adequado de exceções

Validação de entrada do usuário

Separação de responsabilidades

Código limpo e comentado

Persistência em múltiplos formatos

🤝 Contribuição
Como Contribuir
Faça um fork do projeto

Crie uma branch para sua feature

Commit suas mudanças

Push para a branch

Abra um Pull Request

Padrões de Código
Use nomes descritivos em português

Comente métodos complexos

Mantenha a consistência de estilo

Adicione testes para novas funcionalidades

📄 Licença
Este projeto é para fins educacionais. Sinta-se à vontade para usar, modificar e distribuir.

👏 Agradecimentos
Projeto desenvolvido como parte do aprendizado de Programação Orientada a Objetos em Java.

Nota Importante: Este sistema é para fins educacionais. Para cálculos financeiros reais, consulte um especialista em finanças.

📞 Suporte
Para questões ou sugestões:

Abra uma issue no repositório

Consulte a documentação

Revise os exemplos fornecidos
