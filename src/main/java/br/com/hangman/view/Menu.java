package main.java.br.com.hangman.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.br.com.hangman.exception.GameIsFinishedException;
import main.java.br.com.hangman.exception.LetterAlreadyInputtedException;
import main.java.br.com.hangman.model.GameStatus;
import main.java.br.com.hangman.model.HangmanChar;
import main.java.br.com.hangman.service.GameBoardService;
import main.java.br.com.hangman.util.ConsolePrinter;
import main.java.br.com.hangman.util.HangmanDisplay;

public class Menu {

    private final GameBoardService service;
    private final Scanner scanner;
    private final HangmanDisplay hangmanDisplay;
    
    // Construtor
    public Menu() {
        this.service = new GameBoardService();
        this.scanner = new Scanner(System.in);
        this.hangmanDisplay = new HangmanDisplay();
    }

    public void start() {
        while (true) {
            System.out.println("=== Menu do Jogo da Forca ===");
            System.out.println("1. Iniciar Novo Jogo");
            System.out.println("2. Informar uma Letra");
            System.out.println("3. Exibir Estado Atual");
            System.out.println("4. Sair");
            System.out.println("===========================");
            System.out.print("Escolha uma opção (1-4): ");
            
            
            try {
                String input = scanner.nextLine().trim();
                int option = Integer.parseInt(input);
                switch (option) {
                    case 1 -> {
                        startGame();
                        printGameState();
                    }
                    case 2 -> {
                        inputLetter(); 
                        printGameState();         
                    }   
                    case 3 -> {
                        printGameState();
                    }
                    case 4 -> {
                        ConsolePrinter.printWarning("Saindo...");
                        scanner.close();
                        return;
                    }
                    default -> ConsolePrinter.printError("Opção inválida! Tente novamente.");
                        
                }
                // Após cada ação, verifica se o jogo terminou
                service.updateGameStatus();
                if (service.getGameBoard().getStatus() != GameStatus.INCOMPLETO) {
                    displayFinalResult();
                }
            }
            catch (NumberFormatException e) {
                ConsolePrinter.printError("Erro: A entrada deve ser um número válido.");
            }
        }
    }

    // Início do jogo
    private void startGame() {
        System.out.println("Escolha um tópico:");
        service.getAvailableTopics().forEach(topic -> System.out.println("- " + topic));
        System.out.print("Digite o tópico: ");
        String topic = scanner.nextLine().trim().toLowerCase();
        service.initializeWord(topic);
        ConsolePrinter.printSuccess("Novo jogo iniciado.");
        ConsolePrinter.printInfo("Status do jogo: " + service.getGameBoard().getStatus());
    }

    // Informar uma letra
    private void inputLetter() {
        try {
            System.out.print("Digite uma letra: ");
            String input = scanner.nextLine().toUpperCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                ConsolePrinter.printError("Erro: Digite apenas uma letra válida!");
                return;
            }
            char letter = input.charAt(0);
            service.processInput(letter);
            ConsolePrinter.printSuccess("Letra processada.");
            ConsolePrinter.printInfo("Status do jogo: " + service.getGameBoard().getStatus());
        } catch (InputMismatchException e) {
            ConsolePrinter.printError("Erro: Digite apenas números válidos!");
            scanner.nextLine(); 
        } catch (LetterAlreadyInputtedException | GameIsFinishedException e) {
            ConsolePrinter.printError("Erro: " + e.getMessage());
        }
    }

    // Imprime o estado do jogo
    private void printGameState() {
        System.out.println(" ");
        // Exibe a forca gráfica
        hangmanDisplay.displayHangman(6 - service.getGameBoard().getRemainingAttempts());
        
        // Exibe a palavra oculta
        for (HangmanChar c : service.getGameBoard().getWord()) {
            System.out.print(c + " ");
        }
        System.out.println("\nTentativas restantes: " + service.getGameBoard().getRemainingAttempts());
        System.out.println("Letras usadas: " + service.getGameBoard().getUsedLetters());
    }

    // Exibe o resultado final se o jogo terminou
    private void displayFinalResult() {
        printGameState();
        if (service.getGameBoard().getStatus() == GameStatus.VENCEU) {
            ConsolePrinter.printSuccess("Parabéns, você venceu!");
        } else {
            ConsolePrinter.printError("Você perdeu! A palavra era: " + 
                service.getGameBoard().getWord().stream()
                    .map(c -> String.valueOf(c.getCharacter()))
                    .collect(java.util.stream.Collectors.joining("")));
        }
        // Opção para reiniciar ou sair
        System.out.println("Deseja iniciar um novo jogo? (S/N): ");
        String response = scanner.nextLine().trim().toUpperCase();
        if ("S".equals(response)) {
            startGame();
        } else {
            ConsolePrinter.printWarning("Saindo...");
            scanner.close();
            System.exit(0);
        }
    }
}