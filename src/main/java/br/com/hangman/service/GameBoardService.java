package main.java.br.com.hangman.service;

import java.util.ArrayList;
import java.util.List;
import main.java.br.com.hangman.exception.GameIsFinishedException;
import main.java.br.com.hangman.exception.LetterAlreadyInputtedException;
import main.java.br.com.hangman.model.GameBoard;
import main.java.br.com.hangman.model.GameStatus;
import main.java.br.com.hangman.model.HangmanChar;
import main.java.br.com.hangman.util.WordSelector;

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
    String selectedWord = wordSelector.getRandomWordByTopic(topic);
    List<HangmanChar> word = new ArrayList<>();
    for (int i = 0; i < selectedWord.length(); i++) {
      word.add(new HangmanChar(selectedWord.charAt(i)));
    }
    gameBoard.setWord(word);
  }

  public void processInput(char letter)
    throws LetterAlreadyInputtedException, GameIsFinishedException {
    if (gameBoard.getUsedLetters().contains(letter)) {
      throw new LetterAlreadyInputtedException("Letra já utilizada: " + letter);
    }
    if (gameBoard.getStatus() != GameStatus.INCOMPLETO) {
      throw new GameIsFinishedException("O jogo já terminou!");
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
    boolean allRevealed = gameBoard
      .getWord()
      .stream()
      .allMatch(HangmanChar::isRevealed);
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
