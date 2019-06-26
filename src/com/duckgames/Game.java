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

        this.grid = new Square[gridHeight][gridWidth];

        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = new Square();
                }
            }
        }

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int mines = 0;
        while (mines < numMines) {
            int x = random.nextInt(gridWidth);
            int y = random.nextInt(gridHeight);

            if (!grid[y][x].isMine()) {
                grid[y][x].setMine(true);
                incrementNeighbourMines(x, y);
                mines++;
            }
        }
    }

    public Square[][] getGrid() {
        return grid;
    }

    public void drawGrid() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {

              //      if (grid[i][j].isMine()) {
              //          System.out.print("|M");
              //     }
                if (!grid[i][j].isChecked()) {
                    System.out.print("| ");
                }
                else {
                    if (grid[i][j].getNeighbourMines() > 0) {
                        System.out.printf("|%d", grid[i][j].getNeighbourMines());
                    }
                    else {
                        System.out.print("|X");
                    }
                }
            }
            System.out.print("|\n");
        }
    }

    public boolean isMine(int x, int y) {
        return grid[y][x].isMine();
    }

    public void checkNeighboursForMines(int x, int y) {
        if (!grid[y][x].isChecked()) {
            grid[y][x].setChecked(true);

            if (grid[y][x].getNeighbourMines() == 0) {

                if (x - 1 >= 0)
                    checkNeighboursForMines(x - 1, y);

                if (x + 1 < gridWidth)
                    checkNeighboursForMines(x + 1, y);

                if (y - 1 >= 0)
                    checkNeighboursForMines(x, y - 1);

                if (y + 1 < gridHeight)
                    checkNeighboursForMines(x, y + 1);
            }
        }
    }

    private void incrementNeighbourMines(int x, int y) {
        int startX = x - 1;
        int startY = y - 1;
        int endX = startX + 3;
        int endY = startY + 3;

        for (int i = Math.max(0, startX); i < Math.min(gridWidth, endX); i++) {
            for (int j = Math.max(0, startY); j < Math.min(gridHeight, endY); j++) {
                if (!grid[j][i].isMine()) {
                    grid[j][i].incrementNeighbourMines();
                }
            }
        }
    }
}
