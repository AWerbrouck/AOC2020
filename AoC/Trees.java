package AoC;

import java.util.*;

public class Trees {
    public static void main(String[] args) {
        System.out.println(dag3(1, 1) * dag3(1, 3) * dag3(1, 5) * dag3(1, 7) * dag3(2, 1));
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
