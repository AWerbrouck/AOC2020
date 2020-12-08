package AoC;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws Exception {
//		dag1();
//		dag2();
//		dag3();
//		dag4();
//		dag5();
//		dag6();
//		day7();
		day8();
	}
	
	public static void dag1() {
		Repair.dag1();
	}
	
	public static void dag2() {
		Password.dag2();
	}
	
	public static void dag3() {
		System.out.println("dag 3 1,1: " + Trees.dag3(1, 1));
		System.out.println("dag 3 1,3: " + Trees.dag3(1, 3));
		System.out.println("dag 3 1,5: " + Trees.dag3(1, 5));
		System.out.println("dag 3 1,7: " + Trees.dag3(1, 7));
		System.out.println("dag 3 2,1: " + Trees.dag3(2, 1));
	}
	
	public static void dag4() {
		Passport.dag4();
	}
	
	public static void dag5() throws IOException {
		Binairy.dag5();
	}
	
	public static void dag6() throws IOException {
		Customs.dag6();
	}
	public static void day7() throws IOException {
		Bags.day7();
	}
	public static void day8() {
		Handheld handheld = new Handheld();
		handheld.day8();
	}
}
