package net.swamp.aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle01 extends AbstractPuzzle {
	
	public Puzzle01(String puzzleInput) {
		super(puzzleInput);
	}
	
	@Override
	public int getDay() {
		return 1;
	}
	
	@Override
	public String solvePart1() {
		List<Integer> list = new ArrayList<>();
		try (var scanner = new Scanner(getPuzzleInput())) {
			while (scanner.hasNextInt()) {
				list.add(scanner.nextInt());
			}
			for (int firstNumeric : list) {
				for (int secondNumeric : list) {
					if (firstNumeric + secondNumeric == 2020) {
						return String.valueOf(firstNumeric * secondNumeric);
					}
				}
			}
			
		}
		throw new IllegalStateException("Unable to find the solution");
	}
	
	@Override
	public String solvePart2() {
		List<Integer> list = new ArrayList<>();
		try (var scanner = new Scanner(getPuzzleInput())) {
			while (scanner.hasNextInt()) {
				list.add(scanner.nextInt());
			}
			for (int firstNumeric : list) {
				for (int secondNumeric : list) {
					for (int thirdNumeric : list) {
						if (firstNumeric + secondNumeric + thirdNumeric == 2020) {
							return String.valueOf(firstNumeric * secondNumeric * thirdNumeric);
						}
					}
				}
			}
		}
		throw new IllegalStateException("Unable to find the solution");
	}
}
