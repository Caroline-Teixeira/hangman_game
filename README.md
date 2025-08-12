# 🕹️ Jogo da Forca em Java

<a href="https://github.com/Caroline-Teixeira/hangman_game/blob/main/README_ENG.md"><img src="https://raw.githubusercontent.com/yammadev/flag-icons/refs/heads/master/png/US%402x.png" alt="Inglês" ></a>

![Feito com Java](https://img.shields.io/badge/Feito%20com-Java-orange?style=for-the-badge&logo=java)

## 📖 Descrição

Este **Jogo da Forca** é uma aplicação de console desenvolvida em **Java 21**, inspirada no clássico jogo de adivinhação de palavras. O usuário escolhe um tópico (ex.: casa, programação, comida), tenta adivinhar a palavra letra por letra, e visualiza o progresso com uma interface de console interativa que exibe a forca, a palavra oculta, tentativas restantes e letras usadas. O projeto segue uma arquitetura em camadas (Model, Service, View, Util, Exception) para organização e manutenibilidade.

## 🎯 Funcionalidades

- ✅ Iniciar um novo jogo com escolha de tópico
- ✅ Informar uma letra para revelar partes da palavra
- ✅ Exibir o estado atual do jogo (forca, palavra oculta, tentativas, letras usadas)
- ✅ Validação de entradas (ex.: apenas letras válidas, tópicos existentes)
- ✅ Sugestão de tópicos quando um tópico inválido é inserido
- ✅ Exibição de mensagens coloridas no console para feedback (sucesso, erro, aviso, informação)
- ✅ Interface de console com menus interativos no estilo Sudoku

## 📂 Estrutura do Projeto

```
.
├── src/
│   ├── br/com/hangman/
│   │   ├── exception/
│   │   │   ├── GameIsFinishedException.java
│   │   │   └── LetterAlreadyInputtedException.java
│   │   ├── model/
│   │   │   ├── GameBoard.java
│   │   │   ├── GameStatus.java
│   │   │   └── HangmanChar.java
│   │   ├── service/
│   │   │   └── GameBoardService.java
│   │   ├── util/
│   │   │   ├── AnsiColors.java
│   │   │   ├── ConsolePrinter.java
│   │   │   ├── HangmanDisplay.java
│   │   │   └── WordSelector.java
│   │   ├── view/
│   │   │   └── Menu.java
│   │   └── Main.java
└── README.md
```

## 🚀 Como Executar

### 🖥️ Via IDE
1. Importe o projeto em sua IDE (ex.: IntelliJ IDEA, Eclipse).
2. Certifique-se de que o **Java 21** ou superior está configurado.
3. Execute a classe `Main.java` localizada em `br.com.hangman`.

### 🖥️ Via Terminal
1. Clone o repositório e compile/executed com os comandos abaixo.
2. Certifique-se de que o **Java 21** ou superior está instalado.

### Pré-requisitos:
- **Java 21** ou superior instalado

### Clone o repositório:
```bash
git clone https://github.com/[seu-usuario]/[seu-repositorio].git
```

### Navegue até o diretório:
```bash
cd [seu-repositorio]
```

### Compile e execute:
```bash
javac src/br/com/hangman/*.java src/br/com/hangman/*/*.java
java -cp src br.com.hangman.Main
```

## 🛠️ Tecnologias Utilizadas

- **Java 21**


## 📖 Explicação das Principais Classes e Pacotes

**Pacotes**
- `exception` → Exceções personalizadas (`GameIsFinishedException`, `LetterAlreadyInputtedException`) para tratamento de erros específicos.
- `model` → Classes que representam a lógica do jogo (`GameBoard`, `HangmanChar`, `GameStatus`).
- `service` → Lógica de negócios para gerenciar o estado do jogo (`GameBoardService`).
- `util` → Classes utilitárias para exibição da forca, formatação de console e seleção de palavras (`HangmanDisplay`, `ConsolePrinter`, `AnsiColors`, `WordSelector`).
- `view` → Interface de usuário baseada em console com menus interativos (`Menu`).

**Classes Principais**
- `Main` → Ponto de entrada da aplicação, inicializa o menu.
- `Menu` → Interface principal de console, gerencia a interação do usuário com opções numeradas (iniciar jogo, informar letra, exibir estado, sair).
- `GameBoardService` → Gerencia a lógica do jogo, como inicialização de palavras, processamento de letras e atualização do status.
- `GameBoard` → Representa os atributos do jogo (palavra, letras usadas, tentativas restantes, status).
- `HangmanChar` → Representa os atributos de uma palavra, com controle de visibilidade.
- `GameStatus` → Enum para os estados do jogo (INCOMPLETO, VENCEU, PERDEU).
- `WordSelector` → Seleciona palavras aleatórias com base no tópico escolhido, com sugestão de tópicos válidos.
- `HangmanDisplay` → Exibe a forca gráfica com base no número de erros.
- `ConsolePrinter` → Utilitário para impressão formatada com cores no console.
- `AnsiColors` → Constantes para formatação de cores no console.


## 📌 Dicas para Melhorar ou Expandir

- 🖥️ Implementar uma interface gráfica com JavaFX ou Swing para substituir o console.
- 📚 Carregar palavras de um arquivo externo ou banco de dados no `WordSelector`.
- 🎮 Adicionar níveis de dificuldade (ex.: palavras mais longas ou menos tentativas).
- 📊 Incluir pontuação baseada no número de tentativas restantes.
- 🔍 Melhorar a sugestão de tópicos.
- 🧪 Adicionar testes unitários com JUnit para validar `GameBoardService` e `WordSelector`.
- 📱 Criar uma versão com API REST para integração com frontends web ou mobile.

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).

## 👨‍💻 Autor

<a href="https://github.com/Caroline-Teixeira">Caroline 💙</a>

---

📌 *Projeto desenvolvido para o desafio da DIO (Digital Innovation One).*
