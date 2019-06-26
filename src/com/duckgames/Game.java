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

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int mines = 0;
        while (mines < numMines) {
            int x = random.nextInt(gridWidth);
            int y = random.nextInt(gridHeight);

            if (grid[y][x] == null) {
                grid[y][x] = new Square(true);
                mines++;
            }
        }

        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = new Square(false);
                    grid[i][j].setNeighbourMines(countNeighbourMines(i, j));
                }
            }
        }
    }

    public Square[][] getGrid() {
        return grid;
    }

    public void drawGrid() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (!grid[i][j].isChecked()) {
                    System.out.print("| ");
                }
                else {
                    if (grid[i][j].isMine()) {
                        System.out.print("|M");
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
            }
            System.out.print("|\n");
        }
    }

    public boolean checkSquareForMine(int x, int y) {
        if (grid[y][x].isMine()) return true;

        grid[y][x].setChecked(true);
        return false;
    }

    private int countNeighbourMines(int x, int y) {
        int mines = 0;
        int startX = x - 1;
        int startY = y - 1;
        int toCheckX, toCheckY;

        for (int i = 0; i < 3; i++) {
            toCheckY = startY + i;

            if (toCheckY < 0 || toCheckY >= gridHeight) {
                continue;
            }

            for (int j = 0; j < 3; j++) {
                toCheckX = startX + j;

                if (toCheckX < 0 || toCheckX >= gridWidth) {
                    continue;
                }

                if ((toCheckX == x && toCheckY == y)) {
                    continue;
                }

                if (grid[toCheckY][toCheckX] != null && grid[toCheckY][toCheckX].isMine()) {
                    mines++;
                }
            }
        }

        return mines;
    }
}
