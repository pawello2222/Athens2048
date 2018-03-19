package src;
import java.util.Random;
import java.util.ArrayList;

public class RandomPicker{
	private final int width;
	private final int height;
	private ArrayList<DuoTuple<Integer,Integer>> freeCells;
	private Random rand;

	// RandomPicker constructor
	public RandomPicker(int width, int height){
		this.width =  width;
		this.height = height;
		this.freeCells = new ArrayList<DuoTuple<Integer,Integer>>();
		this.rand = new Random();
	}

	// Add a Cell to the picker's list with to given coordinates
	public void addFreeCell(int x, int y){
		if(x >= width || y >= height)
			return;

		if(findCell(x, y) == -1){
			freeCells.add(new DuoTuple<Integer, Integer>(x, y));
		}
	}

	// Pick randomly a Cell among the ones listed in picker's list
	public DuoTuple<Integer,Integer> pickRandomFreeCell(){
		int size = freeCells.size();
		if(size == 0) return null;
		// Pick a cell at a random index between 0 included and size excluded
		return freeCells.get(rand.nextInt(size));
	}

	// Look for a Cel with the given coordinates
	public int findCell(int x, int y){
		int size = freeCells.size();
		for (int i = 0; i < size; i++) {
			if(freeCells.get(i).x == x){
				if(freeCells.get(i).y == y){
					return i;
				}
			}
		}
		return -1;
	}

	// Debug method to print picker's list content
	public void printFreeCells(){
		System.out.println(freeCells.toString());
	}

	// Remove the Cell with the given coordinates
	// Will do nothing if it does not exist
	public void removeFreeCell(int x, int y){
		int pos = findCell(x, y);
		if(pos > -1){
			freeCells.remove(pos);
		}
	}

}