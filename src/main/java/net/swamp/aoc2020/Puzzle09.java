package net.swamp.aoc2020;

import java.util.*;

public class Puzzle09 extends AbstractPuzzle {
	public final ArrayList<Integer> intarray = Reader();
	final int preamble = 25;
	
	public Puzzle09(String puzzleInput) {
		super(puzzleInput);
	}
	
	@Override
	public int getDay() {
		return 9;
	}
	
	public ArrayList<Integer> Reader() {
		Scanner scanner = new Scanner(getPuzzleInput());
		ArrayList<Integer> arraylist = new ArrayList<>();
		while (scanner.hasNextInt()) {
			arraylist.add(scanner.nextInt());
		}
		scanner.close();
		return arraylist;
	}
	
	@Override
	public String solvePart1() {
		int invalidNumber = findInvalid(intarray);
		return String.valueOf(invalidNumber);
	}
	
	@Override
	public String solvePart2() {
		int invalidNumber = findInvalid(intarray);
		int contiguousSum = findContiguous(intarray, invalidNumber);
		return String.valueOf(contiguousSum);
	}
	
	public int findContiguous(ArrayList<Integer> intarray, int invalidNumber) {
		for (int sumIndex = 0; sumIndex < intarray.size(); sumIndex++) {
			int sum = 0;
			ArrayList<Integer> numbersInRange = new ArrayList<>();
			int i = sumIndex;
			while (sum <= invalidNumber) {
				sum += intarray.get(i);
				numbersInRange.add(intarray.get(i));
				if (sum == invalidNumber) {
					return Collections.max(numbersInRange) + Collections.min(numbersInRange);
				}
				i++;
			}
		}
		return 0;
	}
	
	public int findInvalid(ArrayList<Integer> intarray) {
		int minIndex = 0;
		int maxIndex = preamble;
		List<Integer> slidingArray = intarray.subList(minIndex, maxIndex);
		for (int sumIndex = preamble; sumIndex < intarray.size(); sumIndex++) {
			int sum = intarray.get(sumIndex);
			HashSet<Integer> s = new HashSet<Integer>();
			boolean found = false;
			int m = 0;
			while (!found && m <= slidingArray.size()) {
				for (int el = 0; el < slidingArray.size(); el++) {
					if (s.contains(sum - slidingArray.get(el))) {
						found = true;
					} else {
						s.add(slidingArray.get(el));
					}
					m++;
				}
				
			}
			if (!found) {
				return sum;
			}
			minIndex++;
			maxIndex++;
			slidingArray = intarray.subList(minIndex, maxIndex);
		}
		return 0;
	}
}





