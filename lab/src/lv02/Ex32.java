package lv02;

public class Ex32 {

	public static void main(String[] args) {

		//제어문 : 프로그램의 실행 흐름을 제어하는 문장
		
		//1.조건문 : if if-else switch-case
		//2.반복문 : while for do-while
		//3.보조제어문 : break continue
		
		//do-while문
		
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("실행문 a");
			isRun = false;
		}
		
		do {
			System.out.println("실행문 b");
		}while(isRun);
		
		
		//switch-case문
		
		// 1 : VIP
		// 2 : GOLD
		// 3 : SILVER
		
		
		
		
		int grade = 4;
		
		switch(grade) {
		case 1 :
			System.out.println("VIP 1입니다.");
		case 2 :
			System.out.println("GOLD 2입니다.");
		case 3 :
			System.out.println("SILVER 3입니다.");
		default :
			System.out.println("no 입니다.");
		}
		
		
		
		
		
		
	}

}
