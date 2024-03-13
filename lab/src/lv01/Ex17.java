package lv01;

import java.util.Scanner;

public class Ex17 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("com, 가위(0)바위(1)보(2)");
		int com = scan.nextInt();
		
		System.out.print("me, 가위(0)바위(1)보(2)");
		int me = scan.nextInt();
		
		if((me == 0 && com == 1) || (me == 1 && com == 2) || (me == 2 && com == 0)) {
			
		}
	}

}
