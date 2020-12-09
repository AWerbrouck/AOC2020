package AoC;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Handheld {
	public int run(ArrayList<InstructionCount> instructions) {
		Set<InstructionCount> visited = new HashSet<>();
		int accumulator = 0;
		int currIndex = 0;
		while (currIndex < instructions.size()) {
			InstructionCount currInstruction = instructions.get(currIndex);
			if (visited.contains(currInstruction)) {
				return accumulator;
			}
			
			if (currInstruction.type.equals("acc")) {
				accumulator += currInstruction.steps;
			}
			
			if (currInstruction.type.equals("jmp")) {
				currIndex += (currInstruction.steps - 1);
			}
			if (currInstruction.type.equals("nop")) {
			
			}
			visited.add(currInstruction);
			currIndex++;
		}
		return accumulator;
		
	}
	
	public int fixloop(ArrayList<InstructionCount> instructions) {
		int currIndex = 0;
		while (currIndex < instructions.size()) {
			InstructionCount currInstruction = instructions.get(currIndex);
			if (!currInstruction.type.equals("acc")) {
				if (currInstruction.type.equals("jmp"))
					currInstruction.type = "nop";
				else if (currInstruction.type.equals("nop"))
					currInstruction.type = "jmp";
				
				if (fixed(instructions))
					return run(instructions);
				
				if (currInstruction.type.equals("jmp"))
					currInstruction.type = "nop";
				else if (currInstruction.type.equals("nop"))
					currInstruction.type = "jmp";
			}
			currIndex++;
		}
		return 0;
	}
	
	public boolean fixed(ArrayList<InstructionCount> instructions) {
		Set<InstructionCount> visited = new HashSet<>();
		int currIndex = 0;
		while (currIndex < instructions.size()) {
			InstructionCount currInstruction = instructions.get(currIndex);
			if (visited.contains(currInstruction))
				return false;
			
			if (currInstruction.type.equals("jmp"))
				currIndex += (currInstruction.steps - 1);
			
			visited.add(currInstruction);
			currIndex++;
		}
		return true;
	}
	
	public void part1(ArrayList<InstructionCount> instructions) {
		System.out.println("dag 8 deel1: " + run(instructions));
		
	}
	
	public void part2(ArrayList<InstructionCount> instructions) {
		System.out.println("dag 8 deel2: " + fixloop(instructions));
	}
	
	public ArrayList<InstructionCount> createArray() {
		ArrayList<InstructionCount> instructions;
		instructions = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File("./puzzels/d8.txt"));
			
			while (scanner.hasNext()) {
				String[] line = scanner.nextLine()
				                       .split("[+ \\s++]");
				instructions.add(new InstructionCount(line[0], line[line.length - 1]));
			}
		} catch (Exception exception) {
			System.out.println(exception.toString());
		}
		return instructions;
		
	}
	
	public void day8() {
		part1(createArray());
		part2(createArray());
		
	}
	
	class InstructionCount {
		int steps;
		String type;
		
		InstructionCount(String type, String steps) {
			this.type = type;
			this.steps = Integer.parseInt(steps);
		}
	}
	
}
