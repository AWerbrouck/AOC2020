package AoC;

import java.util.*;

public class Trees {
    public static void main(String[] args) {
        System.out.println(dag3(1, 1) * dag3(1, 3) * dag3(1, 5) * dag3(1, 7) * dag3(2, 1));
    }

    public static int dag3(int down, int right) {
        int skip = 0;
        int trees = 0;
        int indexHorizontal = 0;
        List<String> list = ReadPuzzle.readPuzzle("d3.txt");
        int len = (list.get(0)).length();
        for (String string : list) {
            if (skip == 1) {
                char[] chararray = string.toCharArray();
                if (indexHorizontal <= len - right - 1) {
                    indexHorizontal = indexHorizontal + right;
                    char obj = chararray[indexHorizontal];
                    if (obj == '#') {
                        trees++;
                    }

                } else {
                    indexHorizontal = ((indexHorizontal + right) % len);
                    char obj = chararray[indexHorizontal];
                    if (obj == '#') {
                        trees++;
                    }
                }
                if (down == 2) {
                    skip = 0;
                }
            } else {
                skip = 1;
            }
        }
        return trees;
    }
}
