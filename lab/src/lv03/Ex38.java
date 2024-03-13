package lv03;

public class Ex38 {

	public static void main(String[] args) {

		
		//이해가 필
		
		
		
		// 문제1)
		// #
		// ##
		// ###

		for (int i = 0; i < 3; i++) { // 0 1 2
			for (int j = 0; j <= i; j++) { // 1 2 3
				System.out.print("#");
			}
			System.out.println();
		}

		// 문제2)
		// ###
		// ##
		// #

		for (int i = 0; i < 3; i++) { // 2 1 0
			for (int j = 0; j <= 2 - i; j++) { // 3 2 1
				System.out.print("#");
			}
			System.out.println();
		}

		// 문제3)
		// @##
		// @@#
		// @@@

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("@");
			}
			for (int j = 0; j <= 1 - i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}

		// 문제4)
		// **#\n
		// *###\n
		// #####\n

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <2-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("#");
			}
			System.out.println();
		}

	}

}
