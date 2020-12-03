package AoC;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        dag1();

    }
    public static void dag1(){
        List<String> list = Repair.readFiles("C:/Users/arthu/OneDrive/.old/MAIN BRANCH/Documents/GitHub/U-2021/u-20-21-s1/AoC/Java/AoC/src/testcase.txt");
        int result1 = Repair.repair1(list);
        System.out.println(result1);
        int result2 = Repair.repair2(list);
        System.out.println(result2);


    }
}
