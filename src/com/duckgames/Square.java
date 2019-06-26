package com.duckgames;

public class Square {

    private boolean isMine = false;
    private boolean isFlagged = false;
    private boolean isChecked = false;
    private int neighbourMines = 0;

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

    public void incrementNeighbourMines() {
        this.neighbourMines++;
    }
}
