package lv01;

import java.util.Scanner;

import java.util.Random;

public class Ex29 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		/*
		 * [if-else 구문 활용]
		 * 
		 * #가위(0)바위(1)보(2) 게임[2단계] 
		 * 1.com은 0~2 사이의 랜덤한 숫자를 저장한다. 
		 * 2.me는 0~2 사이의숫자를 입력받는다.
		 * 3. com과 me를 비교해, 
		 *      1) 비겼다 2) 내가 이겼다 3) 내가졌다. 를 출력한다.
		 */
		
		// int com = (int)(Math.random()*3);
		// int me = 0;
		
		// System.out.print("가위(0)바위(1)보(2) : ");
		// me = scan.nextInt();  -> 신뢰하지x 
		
		// 예외처리
		// if(me < 0 || me > 2) {
		//       System.out.print("Beep");
		//} else {
		// 컴퓨터가 낸 결과 출력
		// 문자열 데이터 값을 담을 변수의 자료형  : String
		
		//String comRsp = "가위";
		//String meRsp  = "가위";
		
		// if(com== 1){
		//       comRsp = "바위";
		//}
		// else if (com == 2) {
		//       comRsp == "보";
		//}
		// if( me == 1) {
		//      meRsp = "바위";
		//}
		// else if(me == 2) {
		//       meRsp = "보";
		
		
		// System.out.print("com : " + com);
		// System.out.print("com : " + comRsp);
		// System.out.print("me : " + meRsp);
		
		// 승자 출력
		//      if(
		

		int com = random.nextInt(3);
		System.out.println(com);

		System.out.print("가위(0)바위(1)보(2) : ");
		int me = scan.nextInt();

		if (me == com) {
			System.out.print("비겼다!");
		} else if ((me == 0 && com == 2) || (me == 1 && com == 0) || (me == 2 && com == 0)) {
			System.out.print("이겼다!");
		} else {
			System.out.print("졌다!");
		}

	}

}
