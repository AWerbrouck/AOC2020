package net.swamp.aoc2020;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle04 extends AbstractPuzzle {
	public final String[] regexen_deel1 = {
			".*\\bbyr:.*",
			".*\\biyr:.*",
			".*\\beyr:.*",
			".*\\bhgt:.*",
			".*\\bhcl:.*",
			".*\\becl:.*",
			".*\\bpid:.*"
	};
	public final String[] regexen_deel2 = {
			".*\\bbyr:(\\d{4})\\b.*",
			".*\\biyr:(\\d{4})\\b.*",
			".*\\beyr:(\\d{4})\\b.*",
			".*\\bhgt:(\\d+)(cm|in)\\b.*",
			".*\\bhcl:#[0-9a-f]{6}\\b.*",
			".*\\becl:(?:amb|blu|brn|gry|grn|hzl|oth)\\b.*",
			".*\\bpid:\\d{9}\\b.*"
	};
	private final String[] list = reader();
	
	public Puzzle04(String puzzleInput) {
		super(puzzleInput);
	}
	
	@SuppressWarnings("SameReturnValue")
	@Override
	public int getDay() {
		return 4;
	}
	
	@Override
	public String solvePart1() {
		
		int count = 0;
		for (String line : list) {
			boolean valid = true;
			for (String regex : regexen_deel1) {
				valid &= line.matches(regex);
			}
			if (valid) {
				++count;
			}
		}
		return String.valueOf(count);
		
		
	}
	
	@Override
	public String solvePart2() {
		int count = 0;
		for (String line : list) {
			boolean valid = true;
			for (int i = 0; i < regexen_deel2.length; ++i) {
				Matcher m = Pattern.compile(regexen_deel2[i])
				                   .matcher(line);
				valid &= m.find();
				if (valid) {
					switch (i) {
						case 0:
							int value = Integer.parseInt(m.group(1));
							valid = value >= 1920 && value <= 2002;
							break;
						case 1:
							value = Integer.parseInt(m.group(1));
							valid = value >= 2010 && value <= 2020;
							break;
						case 2:
							value = Integer.parseInt(m.group(1));
							valid = value >= 2020 && value <= 2030;
							break;
						case 3:
							value = Integer.parseInt(m.group(1));
							switch (m.group(2)) {
								case "cm":
									valid = value >= 150 && value <= 193;
									break;
								case "in":
									valid = value >= 59 && value <= 76;
									break;
							}
							break;
						default:
							break;
					}
				}
			}
			if (valid) {
				++count;
			}
		}
		return String.valueOf(count);
	}
	
	public String[] reader() {
		
		try (var scanner = new Scanner(getPuzzleInput())) {
			List<String> listtemp = new ArrayList<>();
			while (scanner.hasNextLine()) {
				listtemp.add(scanner.nextLine());
			}
			String[] list = listtemp.toArray(new String[0]);
			list = String.join("\n", list)
			             .replaceAll("\\b\\n\\b", " ")
			             .split("\\n\\n");
			return list;
		}
	}
	
}