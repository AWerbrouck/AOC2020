package AoC;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Repair extends App{

    public static void main(String[] args) {
    }

    public static List<String> readFiles(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            List<String> list = new ArrayList<String>();
            while (scanner.hasNext()){
                list.add(scanner.next());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();   
        }
        return null;
    }

    public static int repair(List<String> list) {

        for (String i1: list) {
            for (String i2: list) {

                int j1 = Integer.parseInt(i1);
                int j2 = Integer.parseInt(i2);

                if (j1 + j2 == 2020) {
                    return j1 * j2;
                }
            }
        }
        return 0;
    }
}



// Kan je de tekst lezen?