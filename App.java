package AoC;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        List<String> list = Repair.readFiles("C:/Users/arthu/OneDrive/.old/MAIN BRANCH/Documents/GitHub/U-2021/u-20-21-s1/AoC/Java/AoC/src/testcase.txt");
        int result = Repair.repair(list);
        System.out.println(result);

    }
}
