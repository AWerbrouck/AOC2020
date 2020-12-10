package net.swamp.aoc2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Puzzle10 extends AbstractPuzzle{
	public Puzzle10(String puzzleInput) {
		super(puzzleInput);
	}
	
	@Override
	public int getDay() {
		return 10;
	}
	
	public ArrayList<Integer> Reader() {
		Scanner scanner = new Scanner(getPuzzleInput());
		ArrayList<Integer> arraylist = new ArrayList<>();
		while (scanner.hasNextInt()) {
			arraylist.add(scanner.nextInt());
		}
		scanner.close();
		Collections.sort(arraylist);
		return arraylist;
	}
	public ArrayList<Integer> input = Reader();
	
	@Override
	public String solvePart1() {
		int step_1 = 0;
		int step_2 = 0;
		if (input.get(0) == 1){
			step_1++;
		} else {step_2++;}
		for (int i = 0; i < input.size() -1 ; i++) {
			if (input.get(i+1) - input.get(i) == 1 ){
				step_1++;
			}else if (input.get(i+1) - input.get(i) == 3){
				step_2++;
			}
		}
		return String.valueOf(step_1 * (step_2 + 1));
	}
	
	@Override
	public String solvePart2(){
		input.add(input.get(input.size()-1)+3);
		int[] fibonacci = {0, 1, 1, 2, 4, 7, 13, 20, 33, 53};
		int previous = 0;
		long result = 1;
		int consecutiveCount = 1;

		for(int jolt : input){
			if (jolt == previous+1){
				consecutiveCount++;
			}
			else{
				result *= fibonacci[consecutiveCount];
				consecutiveCount = 1;
			}
			previous = jolt;
		}



		return String.valueOf(result);
	}
	
}
