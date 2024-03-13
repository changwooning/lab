package lv01test;

import java.util.Scanner;

public class Test_03 {

	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 14:52
	// 종료 15:01
	// 소요 00:00

	/*
	 * #놀이기구 이용제한 1, 키를 입력받는다. 2. 입력받은 키가 120이상이면 , 놀이기구를 이용할 수 있다. 3. 키가 120 미만이면,
	 * 놀이기구를 이용할 수 없다. 4. 단 부모님과 함께 온 경우 놀이기구 이용이 가능하다 . 예) 부모님과 함께 오셨나요? (yes :1 ,
	 * no : 2)
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("키를 입력하세요! : ");
		int heigh = scan.nextInt();

		if (heigh >= 120) {
			System.out.print("이용가능");
		} else {
			System.out.println("이용불가");
			System.out.print("부모님과 함께 오셨나요? : ");

			int answer = scan.nextInt();

			
			//예외처리 
			
			if (answer == 1) {
				System.out.print("이용가능");
			}
			if (answer == 2) {
				System.out.print("이용불가");
			}
		}

	}

}
