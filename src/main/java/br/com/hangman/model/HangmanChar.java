package main.java.br.com.hangman.model;

import java.util.Objects;

public class HangmanChar {

    private final char character;
    private boolean isRevealed;
    private int position;

    public HangmanChar(final char character) {
        this.character = character;
        this.isRevealed = false;
    }

    public HangmanChar(final char character, final int position) {
        this(character);
        this.position = position;
        this.isRevealed = true;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isNotRevealed() {
        return !isRevealed;
    }

    
    public void markAsRevealed() {
        this.isRevealed = true;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(final int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HangmanChar)) {
            return false;}
            return character == ((HangmanChar) obj).character &&
                   isRevealed == ((HangmanChar) obj).isRevealed &&
                   position == ((HangmanChar) obj).position;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, isRevealed, position);
    }


    @Override
    public String toString() {
        return isRevealed ? String.valueOf(character) : "_";
    }
}
