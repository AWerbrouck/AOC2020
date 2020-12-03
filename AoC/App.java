package AoC;

import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        test();

    }
    public static void dag1(){
        List<String> list = Repair.readFiles("C:/Users/arthu/OneDrive/.old/MAIN BRANCH/Documents/GitHub/U-2021/u-20-21-s1/AoC/Java/AoC/src/testcase.txt");
        int result1 = Repair.repair1(list);
        System.out.println(result1);
        int result2 = Repair.repair2(list);
        System.out.println(result2);


    }
    public static void test(){
        
        List<String> list = ReadPuzzle.readPuzzle("d2.txt");
        for (String i1: list) {
            System.out.println(i1);
        }

    }
}
