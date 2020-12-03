package AoC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ReadPuzzle{
    public static void main(String[] args) {
        
    }

    public static List<String> readPuzzle(String fileName) {
        try {
            Scanner scanner = new Scanner(new File("./puzzels/"+fileName));
            List<String> list = new ArrayList<String>();
            while (scanner.hasNextLine()){
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
}
