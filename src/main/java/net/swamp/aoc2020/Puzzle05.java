package net.swamp.aoc2020;

import java.util.Arrays;
import java.util.Scanner;

public class Puzzle05 extends AbstractPuzzle {
	private final int[] intarr = Reader();
	
	public Puzzle05(String puzzleInput) {
		super(puzzleInput);
	}
	
	@Override
	public int getDay() {
		return 5;
	}
	
	public int[] Reader() {
		
		try (var scanner = new Scanner(getPuzzleInput())) {
			return getPuzzleInput().lines()
			                       .map(line -> line
					                               .replaceAll("[FL]", "0")
					                               .replaceAll("[BR]", "1"))
			                       .mapToInt(line -> Integer.parseInt(line, 2))
			                       .sorted()
			                       .toArray();
		}
	}
	
	@Override
	public String solvePart1() {
		return String.valueOf(intarr[intarr.length - 1]);
	}
	
	@Override
	public String solvePart2() {
		return String.valueOf(((intarr[0] + intarr[intarr.length - 1]) * (intarr.length + 1) / 2 - Arrays.stream(intarr)
		                                                                                                 .sum()));
	}
	
}