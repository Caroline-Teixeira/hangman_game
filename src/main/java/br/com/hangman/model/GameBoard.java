package br.com.hangman.model;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private static final int MAX_ATTEMPTS = 6;
    private List<HangmanChar> word;
    private List<Character> usedLetters;
    private int remainingAttempts;
    private GameStatus status;

    public GameBoard() {
        this.word = new ArrayList<>();
        this.usedLetters = new ArrayList<>();
        this.remainingAttempts = MAX_ATTEMPTS;
        this.status = GameStatus.INCOMPLETO;
    }

    public void reset() {
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

    public void setUsedLetters(List<Character> usedLetters) {
        this.usedLetters = usedLetters;
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