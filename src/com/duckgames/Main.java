package com.duckgames;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int gridWidth, gridHeight;
        int numMines;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to Minesweeper!\nEnter grid width: \n");
        gridWidth = scanner.nextInt();
        System.out.print("\nEnter grid height: \n");
        gridHeight = scanner.nextInt();
        System.out.print("\nHow many mines? \n");
        numMines = scanner.nextInt();

        Game game = new Game(gridWidth, gridHeight, numMines);

        boolean dead = false;
        boolean won = false;
        while (!dead && !won) {
            game.drawGrid();

            System.out.print("\nEnter x coordinate: \n");
            int x = scanner.nextInt();
            System.out.print("\nEnter y coordinate: \n");
            int y = scanner.nextInt();

            dead = game.isMine(x, y);
            game.checkNeighboursForMines(x, y);
            won = game.checkForWin();
        }

        game.drawGrid();

        if (dead)
            System.out.print("\nYOU DIED\n");
        if (won)
            System.out.print("\nYOU WON\n");


        scanner.close();
    }
}
