package net.swamp.aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle03 extends AbstractPuzzle {
	private final List<String> list = reader();
	
	public Puzzle03(String puzzleInput) {
		super(puzzleInput);
	}
	
	@Override
	public int getDay() {
		return 3;
	}
	
	public List<String> reader() {
		
		try (var scanner = new Scanner(getPuzzleInput())) {
			List<String> list = new ArrayList<>();
			while (scanner.hasNextLine()) {
				list.add(scanner.nextLine());
			}
			return list;
		}
	}
	
	@Override
	public String solvePart1() {
		return String.valueOf(Trees(3, 1));
	}
	
	@Override
	public String solvePart2() {
		return String.valueOf(Trees(1, 1) * Trees(3, 1) * Trees(5, 1) * Trees(7, 1) * Trees(1, 2));
	}
	
	public int Trees(int right, int down) {
		int trees = 0;
		int H = 0;
		assert list != null;
		int len = (list.get(0)).length();
		for (int i = down; i < list.size(); i += down) {
			H = (H + right) % len;
			if (list.get(i)
			        .charAt(H) == '#') {
				trees++;
			}
		}
		return trees;
	}
	
}
