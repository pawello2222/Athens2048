package com.athens.athens2048;


public class Tile {
    /**
     * Represents a single tile on the board.
     */

    private int number;

    Tile(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
