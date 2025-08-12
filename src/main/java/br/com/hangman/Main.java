package br.com.hangman;

import br.com.hangman.view.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Jogo da Forca DIO");
        Menu game = new Menu();
        game.start();
        System.out.println("Obrigado por jogar!");
    }
}
