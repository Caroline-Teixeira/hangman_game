package main.java.br.com.hangman.model;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

  private static final int MAX_ATTEMPTS = 6;
  private List<HangmanChar> word; // Palavra a ser adivinhada
  private List<Character> usedLetters; // Letras já tentadas
  private int remainingAttempts;
  private GameStatus status;

  public GameBoard() {
    this.word = new ArrayList<>();
    this.usedLetters = new ArrayList<>();
    this.remainingAttempts = MAX_ATTEMPTS;
    this.status = GameStatus.INCOMPLETO;
  }

  // Getters e setters
  public List<HangmanChar> getWord() {
    return word;
  }

  public void setWord(List<HangmanChar> word) {
    this.word = word;
  }

  public List<Character> getUsedLetters() {
    return usedLetters;
  }

  public int getRemainingAttempts() {
    return remainingAttempts;
  }

  public void setRemainingAttempts(int remainingAttempts) {
    this.remainingAttempts = remainingAttempts;
  }

  public GameStatus getStatus() {
    return status;
  }

  public void setStatus(GameStatus status) {
    this.status = status;
  }
}
