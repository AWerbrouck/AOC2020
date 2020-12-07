package AoC;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadPuzzle {
	public static void main(String[] args) {
	
	}
	
	public static List<String> readPuzzle(String fileName) {
		try {
			Scanner scanner = new Scanner(new File("./puzzels/" + fileName));
			List<String> list = new ArrayList<>();
			while (scanner.hasNextLine()) {
				list.add(scanner.nextLine());
			}
			scanner.close();
			return list;
		} catch (FileNotFoundException exception) {
			System.out.println("An error occurred.");
			exception.printStackTrace();
		}
		return null;
	}
	
	public static String[] getInput(String fileName) {
		try {
			return Files.lines(Path.of(fileName)).toArray(String[]::new);
		} catch (IOException e) {
			e.printStackTrace();
			return new String[0];
		}
	}
	
	public static String[] puzzleString(String fileName) throws IOException {
		return Files.readString(Paths.get("./puzzels/" + fileName)).split("\\n\\n");
		
	}
	public static int[] readPuzzleInt(String fileName) throws FileNotFoundException {
		int[] intArray = new int[]{};
		Scanner scanner = new Scanner(new File("./puzzels/" + fileName));
		int i = 0;
		while(scanner.hasNextInt()){
			i++;
			intArray[i] = scanner.nextInt();
		}
		return intArray;
		
	}
	
	static List<String> readStringsBySeparator(String fileName, String separator) throws IOException {
		List<String> result = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(new File("./puzzels/" + fileName)));
		StringBuilder sb = new StringBuilder();
		while (br.ready()) {
			sb.append(br.readLine());
			sb.append("\n");
		}
		String[] split = sb.toString().split(separator);
		Collections.addAll(result, split);
		return result;
	}
}
