package net.swamp.aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Puzzle02 extends AbstractPuzzle {
	private final List<String> list = reader();
	
	public Puzzle02(String puzzleInput) {
		super(puzzleInput);
	}
	
	@Override
	public int getDay() {
		return 2;
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
		int illegalPassword = 0;
		
		for (String string : list) {
			if (checker(string, 1)) {
				illegalPassword++;
			}
		}
		
		return String.valueOf(illegalPassword);
	}
	
	@Override
	public String solvePart2() {
		int illegalPassword = 0;
		
		for (String string : list) {
			if (checker(string, 2)) {
				illegalPassword++;
			}
		}
		return String.valueOf(illegalPassword);
	}
	
	public boolean checker(String string, int part) {
		Pattern pNumber = Pattern.compile("[^\\d]*([\\d]+)[^\\d]+([\\d]+)");
		Pattern pString = Pattern.compile("[^a-z]*([a-z]+)[^a-z]*([a-z]+)");
		Matcher mNumber = pNumber.matcher(string);
		Matcher mString = pString.matcher(string);
		if (mNumber.find() && mString.find()) {
			int min = parseInt(mNumber.group(1));
			int max = parseInt(mNumber.group(2));
			String one = mString.group(1);
			String two = mString.group(2);
			if (part == 1) {
				int count = countPart1(one.charAt(0), two);
				if (min <= count && count <= max) {
					return true;
				}
			}
			if (part == 2) {
				return countPart2(one.charAt(0), two, min, max);
			}
		}
		return false;
	}
	
	public boolean countPart2(char character, String string, int x, int y) {
		char[] charray = string.toCharArray();
		if ((charray[x - 1] == character) && (charray[y - 1] != character)) {
			return true;
		} else return (charray[x - 1] != character) && (charray[y - 1] == character);
	}
	
	public int countPart1(char character, String string) {
		int amount = 0;
		for (char ch : string.toCharArray()) {
			if (ch == character) {
				amount++;
			}
		}
		return amount;
	}
	
	
}
