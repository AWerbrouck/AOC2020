package AoC;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Customs {
	
	public static void main(String[] args) {
	
	}

	public static int deel1(String[] forms){
		return Stream.of(forms)
				.map(s -> s.replaceAll("\\n", ""))
				.mapToInt(s -> (int) s.chars().distinct().count())
				.sum();
	
	}
	public static int deel2(String[] forms){
		return Stream.of(forms)
				.mapToInt(Customs::perGroup)
				.sum();
	}
	
	public static int perGroup(String string){
		List<String> group = List.of(string.split("\\n"));
		Set<Integer> iedereen = group.get(0).chars().boxed().collect(toSet());
		group.stream()
				.map(ant -> ant.chars().boxed().collect(toSet()))
				.forEach(iedereen::retainAll);
		return iedereen.size();
	}
	
	public static void dag6() throws IOException {
		String[] forms = ReadPuzzle.puzzleString("dag6.txt");
		System.out.println("dag 6 deel1: " + deel1(forms));
		System.out.println("dag 6 deel2: " + deel2(forms));
			
	}
}

