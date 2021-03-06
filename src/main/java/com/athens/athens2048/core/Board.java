package com.athens.athens2048.core;

import com.athens.athens2048.random.DuoTuple;
import com.athens.athens2048.random.RandomTilePicker;


public class Board {

    private Tile tiles[][];
    private Tile firstTiles[][];
    private ScoredCounter scoredCounter;
    private int tilesFilledAtStart;

    public Board(ScoredCounter scoredCounter, int tilesFilledAtStart) {
        this.scoredCounter = scoredCounter;
        this.tilesFilledAtStart = tilesFilledAtStart;
    }

    public void initFromBoard(Board board) {
        if (tiles == null) {
            tiles = new Tile[board.getHeight()][board.getWidth()];
        }

        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++)
                tiles[i][j] = new Tile(board.getTileValue(i,j));
        }
    }

    public void initFirstStage(int height, int width) {
        if (firstTiles == null) {
            firstTiles = new Tile[height][width];
        }

        // Actually instantiate firstTiles's tiles or fill it with zeros
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(firstTiles[i][j] == null)
                    firstTiles[i][j] = new Tile(0);
                else
                    firstTiles[i][j].setNumber(0);
            }
        }

        for (int i = 0; i < tilesFilledAtStart; i++) {
            DuoTuple<Integer, Integer> randomPoint = RandomTilePicker.getInstance().update(firstTiles);

            if (randomPoint != null) {
                firstTiles[randomPoint.x][randomPoint.y].setNumber(pickRandomTileValue());
            }
        }
    }

    public void resetToFirstStage(int height, int width) {
        if (tiles == null) {
            tiles = new Tile[height][width];
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                // Copy firstTiles's values to game's tiles array
                if (tiles[i][j] == null)
                    tiles[i][j] = new Tile(firstTiles[i][j].getNumber());
                else
                    tiles[i][j].setNumber(firstTiles[i][j].getNumber());
        }
    }

    public void setTileValue(DuoTuple<Integer, Integer> coordinates, int value) {
        tiles[coordinates.x][coordinates.y].setNumber(value);
    }

    public int getTileValue(int x, int y){
        return tiles[x][y].getNumber();
    }

    public int getWidth(){
        return tiles[0].length;
    }

    public int getHeight(){
        return tiles.length;
    }

    public DuoTuple<Integer, Integer> pickRandomTileCoordinates() {
        return RandomTilePicker.getInstance().update(tiles);
    }

    public int pickRandomTileValue(){
        return RandomTilePicker.getInstance().pickRandomTileValue();
    }

    public boolean update(Direction direction, int position, int startIndex, int endIndex, boolean updateScore) {
        boolean merged = false;
        if (slide(direction, position, startIndex, endIndex))
            merged = true;

        int diff = startIndex < endIndex ? 1 : -1;

        for (int i = startIndex; i * diff <= (endIndex - diff) * diff; i += diff) {
            Tile currTile = Direction.isHorizontal(direction) ? tiles[position][i] : tiles[i][position];
            Tile nextTile = Direction.isHorizontal(direction) ? tiles[position][i + diff] : tiles[i + diff][position];

            if (currTile.getNumber() == nextTile.getNumber() && currTile.getNumber() != 0) {
                // merge
                merged = true;
                if(updateScore) {
                    scoredCounter.setScore(scoredCounter.getScore()+ 2 * currTile.getNumber());
                }
                currTile.setNumber(2 * currTile.getNumber());

                // brings every tile to the left
                int j = i + diff;
                while (j * diff <= (endIndex - diff) * diff) {
                    if (Direction.isHorizontal(direction))
                        tiles[position][j].setNumber(tiles[position][j + diff].getNumber());
                    else
                        tiles[j][position].setNumber(tiles[j + diff][position].getNumber());

                    j += diff;
                }

                // makes the last tile = 0
                if (Direction.isHorizontal(direction))
                    tiles[position][j].setNumber(0);
                else
                    tiles[j][position].setNumber(0);
            }
        }
        return merged;
    }

    private boolean slide(Direction direction, int position, int startIndex, int endIndex) {
        boolean shifted = false;
        int diff = startIndex < endIndex ? 1 : -1;

        for (int i = startIndex + diff; i * diff <= endIndex * diff; i += diff) {
            Tile currTile = Direction.isHorizontal(direction) ? tiles[position][i] : tiles[i][position];
            Tile prevTile = Direction.isHorizontal(direction) ? tiles[position][i - diff] : tiles[i - diff][position];

            int currIndex = i;
            if (currTile.getNumber() == 0)
                continue;
            while (prevTile.getNumber() == 0) {
                shifted = true;
                prevTile.setNumber(currTile.getNumber());
                currTile.setNumber(0);
                currIndex -= diff;
                if (currIndex != startIndex) {
                    currTile = prevTile;
                    prevTile = Direction.isHorizontal(direction)
                            ? tiles[position][currIndex - diff] : tiles[currIndex - diff][position];
                }
                else
                    break;
            }
        }

        return shifted;
    }
}
