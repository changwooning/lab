package lv02;

public class Ex02 {

	public static void main(String[] args) {

		// 문제1) 1~10까지 반복해 5~9 출력
		// 정답1) 5,6,7,8,9

		int num = 1;
		while (num <= 10) {
			// num : 1~10
			//System.out.println("num : " + num);   >>> 확인 방법
			if(num >= 5 && num <= 9) {
				System.out.print(num + " ");
			}
			num += 1;
		}
		System.out.println();

		// 문제2) 10~1까지 반복해 6~3 거꾸로 출력
		// 정답2) 6,5,4,3
		
		int num1 = 10;
		while (num1 > 0) {
			// 10~1
			if(num1 <= 6 && num1 >= 3) {
				System.out.print(num1 + " ");
			}
			num1 -= 1;
		}
		System.out.println();
		

		// 문제3) 1~10까지 반복해 짝수만 출력
		// 정답3) 2,4,6,8,10
		
		int num2 = 1;
		while(num2 <= 10) {
			// num2 : 1~10
			if(num2 % 2 == 0) {
				System.out.print(num2 + " ");
			}
			num2 += 1;
		}
		System.out.println();

	

	}

}
