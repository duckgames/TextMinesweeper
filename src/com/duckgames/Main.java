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

        game.drawGrid();

        System.out.print("Press any key to quit\n");
        scanner.next();

        scanner.close();
    }
}
