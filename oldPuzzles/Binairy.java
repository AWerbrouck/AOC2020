package AoC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Binairy {
	public static void main(String[] args) {
	}
	
	public static void deel1(int[] intarr) {
		System.out.println("dag 5 deel1: " + intarr[intarr.length - 1]);
	}
	
	public static void deel2(int[] intarr) {
		System.out.println("dag 5 deel2: " + ((intarr[0] + intarr[intarr.length - 1]) * (intarr.length + 1) / 2 - Arrays.stream(intarr).sum()));
	}
	
	
	public static void dag5() throws IOException {
		int[] intarr = Files.readAllLines(Paths.get("./puzzels/dag5.txt")).stream()
				.map(line -> line
						.replaceAll("[FL]", "0")
						.replaceAll("[BR]", "1"))
				.mapToInt(line -> Integer.parseInt(line, 2))
				.sorted()
				.toArray();
		deel1(intarr);
		deel2(intarr);
	}
}
