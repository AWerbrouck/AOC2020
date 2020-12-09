package AoC;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Encoding {
	
	int preamble = 25;
	
	public static int findContiguous(ArrayList<Integer> intarray, int invalidNumber) {
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
	
	public void part1(ArrayList<Integer> intarray) {
		int invalidNumber = findInvalid(intarray);
		System.out.println("dag 9 deel1: " +invalidNumber);
	}
	
	public void part2(ArrayList<Integer> intarray) {
		int invalidNumber = findInvalid(intarray);
		int contiguousSum = findContiguous(intarray, invalidNumber);
		System.out.println("dag 9 deel2: " + contiguousSum);
		
		
	}
	
	public void day9() throws FileNotFoundException {
		ArrayList<Integer> intarray = ReadPuzzle.readPuzzleArray("d9.txt");
		part1(intarray);
		part2(intarray);
		
	}
}
