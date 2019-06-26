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
        while (!dead) {
            game.drawGrid();

            System.out.print("\nEnter x coordinate: \n");
            int x = scanner.nextInt();
            System.out.print("\nEnter y coordinate: \n");
            int y = scanner.nextInt();

            dead = game.checkSquareForMine(x, y);
        }

        System.out.print("\nYOU DIED\n");

        scanner.close();
    }
}
