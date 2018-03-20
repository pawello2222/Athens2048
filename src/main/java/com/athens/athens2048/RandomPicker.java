package com.athens.athens2048;
import java.util.Random;
import java.util.ArrayList;

public class RandomPicker{
	private final int width;
	private final int height;
	private ArrayList<DuoTuple<Integer,Integer>> freeTiles;
	private Random rand;

	// RandomPicker constructor
	public RandomPicker(int width, int height){
		this.width =  width;
		this.height = height;
		this.freeTiles = new ArrayList<>();
		this.rand = new Random();
	}

	// Add a Cell to the picker's list with to given coordinates
	public void addFreeTile(int x, int y){
		if(x >= width || y >= height)
			return;

		if(findTile(x, y) == -1){
			freeTiles.add(new DuoTuple<>(x, y));
		}
	}

	// Pick randomly a Cell among the ones listed in picker's list
	public DuoTuple<Integer,Integer> pickRandomFreeTile(){
		int size = freeTiles.size();
		if(size == 0) return null;
		// Pick a cell at a random index between 0 included and size excluded
		return freeTiles.get(rand.nextInt(size));
	}

	// Look for a Cell with the given coordinates
	public int findTile(int x, int y){
		int size = freeTiles.size();
		for (int i = 0; i < size; i++) {
			if(freeTiles.get(i).x == x){
				if(freeTiles.get(i).y == y){
					return i;
				}
			}
		}
		return -1;
	}

	// Debug method to print picker's list content
	public void printFreeTiles(){
		System.out.println(freeTiles.toString());
	}

	// Remove the Tile with the given coordinates
	// Will do nothing if it does not exist
	public void removeFreeTile(int x, int y){
		int pos = findTile(x, y);
		if(pos > -1){
			freeTiles.remove(pos);
		}
	}

	public int freeTilesCount(){
	    return freeTiles.size();
    }

}