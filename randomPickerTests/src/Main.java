package src;
public class Main {

	public static void main(String[] args) {
		int[][] grid = new int[4][4];
		RandomPicker picker =  new RandomPicker(4, 4);
		picker.addFreeCell(1, 2);

		picker.addFreeCell(0, 1);
		picker.addFreeCell(1, 2);
		picker.removeFreeCell(0, 1);
		picker.addFreeCell(3, 3);
		picker.addFreeCell(2, 2);
		picker.addFreeCell(1, 1);
		picker.addFreeCell(1, 0);
		picker.addFreeCell(1, 3);
		picker.addFreeCell(3, 1);

		picker.printFreeCells();
		for(int i = 0; i < 3; i++){
			System.out.println("Random pick : "+ picker.pickRandomFreeCell().toString());
		}
	}

}
