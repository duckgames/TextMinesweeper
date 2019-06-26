package com.duckgames;

import java.util.Random;

public class Game {

    private int gridWidth, gridHeight;
    private int numMines;
    private Square[][] grid;

    Game(int gridWidth, int gridHeight, int numMines) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.numMines = numMines;

        this.grid = new Square[gridWidth][gridHeight];

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int mines = 0;
        while (mines < numMines) {
            int x = random.nextInt(gridWidth);
            int y = random.nextInt(gridHeight);

            if (grid[x][y] == null) {
                grid[x][y] = new Square(true);
                mines++;
            }
        }

        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = new Square(false);
                    grid[i][j].setNeighbourMines(checkForNeighbourMines(i, j));
                }
            }
        }
    }

    public Square[][] getGrid() {
        return grid;
    }

    public void drawGrid() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                if (grid[i][j].isMine()) {
                    System.out.print("|M");
                }
                else {
                    System.out.printf("|%d", grid[i][j].getNeighbourMines());
                }
            }
            System.out.print("|\n");
        }
    }

    private int checkForNeighbourMines(int x, int y) {
        int mines = 0;
        int startX = x - 1;
        int startY = y - 1;
        int toCheckX, toCheckY;

        for (int i = 0; i < 3; i++) {
            toCheckX = startX + i;

            if (toCheckX < 0 || toCheckX >= gridWidth) {
                continue;
            }

            for (int j = 0; j < 3; j++) {
                toCheckY = startY + j;

                if (toCheckY < 0 || toCheckY >= gridHeight) {
                    continue;
                }

                if ((toCheckX == x && toCheckY == y)) {
                    continue;
                }

                if (grid[toCheckX][toCheckY] != null && grid[toCheckX][toCheckY].isMine()) {
                    mines++;
                }
            }
        }

        return mines;
    }
}
