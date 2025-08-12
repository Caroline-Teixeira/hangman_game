package main.java.br.com.hangman.exception;

public class LetterAlreadyInputtedException extends RuntimeException {

    public LetterAlreadyInputtedException(String message) {
        super(message);
    }


}
