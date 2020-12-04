package AoC;

import java.util.List;

public class Trees {
	public static void main(String[] args) {
	
	}
	
	public static int dag3(int down, int right) {
		int trees = 0;
		int H = 0;
		List<String> list = ReadPuzzle.readPuzzle("d3.txt");
		int len = (list.get(0)).length();
		for (int i = down; i < list.size(); i += down) {
			H = (H + right) % len;
			if (list.get(i).charAt(H) == '#') {
				trees++;
			}
		}
		return trees;
	}
}
