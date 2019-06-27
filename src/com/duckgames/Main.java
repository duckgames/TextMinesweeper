package com.duckgames;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            game(scanner);

            System.out.print("\nPress y to play again or any other key to quit.\n");

            while (!scanner.hasNext()) { }

            char c = scanner.next().charAt(0);

            if (c != 'y' && c != 'Y')
                quit = true;
        }
        scanner.close();
    }

    public static void game(Scanner scanner) {
        int gridWidth, gridHeight;
        int numMines;

        System.out.print("Welcome to Minesweeper!\nEnter grid width:\n");
        gridWidth = scanner.nextInt();
        System.out.print("\nEnter grid height:\n");
        gridHeight = scanner.nextInt();
        System.out.print("\nHow many mines?\n");
        numMines = scanner.nextInt();

        Game game = new Game(gridWidth, gridHeight, numMines);

        boolean dead = false;
        boolean won = false;
        while (!dead && !won) {
            game.drawGrid();

            System.out.print("\nSelect 1 to search a square or 2 to place or remove a flag.\n");
            
            int selection = 0;
            
            while (selection != 1 && selection != 2) {
                selection = scanner.nextInt();
            }

            System.out.printf("\nEnter x coordinate between 0 and %d:\n", gridWidth - 1);
            int x = -1;
            while (x == -1) {
                int temp = scanner.nextInt();
                if (temp >= 0 && temp < gridWidth) {
                    x = temp;
                }
            }
            System.out.printf("\nEnter y coordinate between 0 and %d:\n", gridHeight - 1);

            int y = -1;
            while (y == -1) {
                int temp = scanner.nextInt();
                if (temp >= 0 && temp < gridHeight) {
                    y = temp;
                }
            }
            
            if (selection == 1) {
                dead = game.isMine(x, y);
                game.checkNeighboursForMines(x, y);
            }
            else {
                game.changeFlagStatus(x, y);
            }
            won = game.checkForWin();
        }

        game.drawGrid();

        if (dead)
            System.out.print("\nYOU DIED\n");
        if (won)
            System.out.print("\nYOU WON\n");
    }
}
