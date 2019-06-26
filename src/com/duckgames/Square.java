package com.duckgames;

public class Square {

    private boolean isMine;
    private boolean isFlagged = false;
    private boolean isChecked = false;
    private int neighbourMines = 0;

    Square(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getNeighbourMines() {
        return neighbourMines;
    }

    public void setNeighbourMines(int neighbourMines) {
        this.neighbourMines = neighbourMines;
    }
}
