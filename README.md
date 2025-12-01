# 🏡 Sistema de Simulação de Financiamentos

Este projeto é um sistema simples em Java para simular financiamentos de imóveis.
O usuário pode cadastrar diferentes tipos de imóveis, visualizar cálculos e salvar os resultados em arquivo para consultar depois.

---

## 🚀 Funcionalidades

* Cadastro de financiamentos para:

  * **Casa**
  * **Apartamento**
  * **Terreno**
* Cálculo automático de:

  * Valor total financiado
  * Juros
  * Prestação mensal
* Tratamento de exceção próprio (`AumentoMaiorDoQueJurosException`)
* Interface de usuário via console
* Salvamento dos financiamentos em arquivo `.txt` para futura consulta

---

## 📁 Estrutura do Projeto

```
Financiamento/
│
├── src/
│   ├── Financiamentos/
│   │   ├── Financiamento.java
│   │   ├── Casa.java
│   │   ├── Apartamento.java
│   │   ├── Terreno.java
│   │   └── AumentoMaiorDoQueJurosException.java
│   │
│   ├── Users/
│   │   └── InterfaceUsuario.java
│   │
│   └── Main.java
│
├── financiamentos.txt   → arquivo de saída dos financiamentos
├── financiamentos.dat   → arquivo binário (opcional)
└── Financiamento.iml
```

---

## 🛠️ Como executar

1. Certifique-se de ter o **Java 17+** instalado.
2. Compile os arquivos:

   ```
   javac src/Main.java
   ```
3. Execute o sistema:

   ```
   java src.Main
   ```

---

## 💡 Objetivo do Projeto

O sistema foi desenvolvido para treinar:

* Programação orientada a objetos (POO)
* Criação e implementação de classes abstratas e especializadas
* Encapsulamento, herança e polimorfismo
* Manipulação de arquivos
* Boas práticas na organização de código em Java

---

## 🤝 Contribuições

Sinta-se livre para abrir um *pull request* com melhorias, ajustes ou novas funcionalidades.

---

## 📄 Licença

Este projeto é de uso livre para fins educacionais.

---
