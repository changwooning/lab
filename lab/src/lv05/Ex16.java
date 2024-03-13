package lv05;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {

		// 예외처리를 위한 구문
		// try-catch 문

		// 0. Exception

		// 1. ArrayIndexOutOfBoundsException
//		int[] arr = new int[3];
//		System.out.println(arr[3]);
//		try {
//		int[] arr = new int[3];
//		System.out.println(arr[3]);
//		}catch(ArrayIndexOutOfBoundsException e) {
//			//e.printStackTrace();
//			System.out.println("인덱스 범위가 유효하지 않습니다.");
//			
//		}
//		System.out.println("hello");

		// 2. NullPointerException
//		try {
//		String str = null;
//		System.out.println(str.length());
//		}catch(NullPointerException e) {
//			//e.printStackTrace();		//오류문을 알고싶어서 상세내역을 알수있음
//			System.out.println("배열의 길이가 존재하지 않습니다.");
//		}
//		System.out.println("java");

		// 3. ArithmeticException
//		try {
//		System.out.println(10/0);
//		}catch(ArithmeticException e) {
//			System.out.println("나누어 지지 않습니다.");
//		}
//		System.out.println("그래요?");

		// 4. InputMismatchException
//		Scanner scan = new Scanner(System.in);
//		System.out.print("num : ");
//		int num = 0;
//		try {
//			num = scan.nextInt();
//		} catch (Exception e) {
//			e.printStackTrace();
//			num = 1;
//		}finally {
//			System.out.printf("선택한 번호는 %d입니다.",num);
//		}
//		System.out.printf("선택한 번호는 %d입니다.",num);

		// 5. NumberFormatException
		String number = "1234a";
		try {
		int num = Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
	}

}
