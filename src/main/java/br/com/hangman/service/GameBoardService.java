package br.com.hangman.service;

import br.com.hangman.exception.GameIsFinishedException;
import br.com.hangman.exception.LetterAlreadyInputtedException;
import br.com.hangman.model.GameBoard;
import br.com.hangman.model.GameStatus;
import br.com.hangman.model.HangmanChar;
import br.com.hangman.util.WordSelector;

import java.util.ArrayList;
import java.util.List;

public class GameBoardService {
    private final GameBoard gameBoard;
    private final WordSelector wordSelector;

    public GameBoardService() {
        this.gameBoard = new GameBoard();
        this.wordSelector = new WordSelector();
    }

    public List<String> getAvailableTopics() {
        return wordSelector.getAvailableTopics();
    }

    public void initializeWord(String topic) {
        gameBoard.reset(); // reinicialização completa
        String selectedWord = wordSelector.getRandomWordByTopic(topic);
        List<HangmanChar> word = new ArrayList<>();
        for (int i = 0; i < selectedWord.length(); i++) {
            word.add(new HangmanChar(selectedWord.charAt(i)));
        }
        gameBoard.setWord(word);
    }

    public void processInput(char letter) throws LetterAlreadyInputtedException, GameIsFinishedException {
        if (gameBoard.getStatus() != GameStatus.INCOMPLETO) {
            throw new GameIsFinishedException("O jogo já terminou!");
        }
        if (gameBoard.getUsedLetters().contains(letter)) {
            throw new LetterAlreadyInputtedException("Letra já utilizada: " + letter);
        }
        gameBoard.getUsedLetters().add(letter);
        boolean found = false;
        for (HangmanChar c : gameBoard.getWord()) {
            if (c.getCharacter() == letter) {
                c.markAsRevealed();
                found = true;
            }
        }
        if (!found) {
            gameBoard.setRemainingAttempts(gameBoard.getRemainingAttempts() - 1);
        }
    }

    public void updateGameStatus() {
        if (gameBoard.getWord().isEmpty()) {
            return; // Evita verificação se a palavra não foi inicializada
        }
        
        boolean allRevealed = gameBoard.getWord().stream().allMatch(HangmanChar::isRevealed);
        if (allRevealed) {
            gameBoard.setStatus(GameStatus.VENCEU);
        } else if (gameBoard.getRemainingAttempts() <= 0) {
            gameBoard.setStatus(GameStatus.PERDEU);
        }
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}