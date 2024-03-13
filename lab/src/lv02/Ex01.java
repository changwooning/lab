package lv02;

public class Ex01 {

	public static void main(String[] args) {
		
		//제어문 : 프로그램의 실행 흐름을 제어하는 문장
		// 1) 조건문 : if문 , if-else문
		// 2) 반복문 : while문 , for문
		// 3) 보조제어문
		
		//반복문
		//ㄴ 반복 구문을 만드는 것
		
		//문법
		//while(조건식) {실행문;}
		
		//반복의 종료(반복의 구간을 설정)를 제어하기 위해서는
		//다음의 세 가지 식 필요함
		
		// 1. 초기식
		// 2. 조건식
		// 3. 증감식
		
		//무한 루프 (종료되지 않음)
//		while(true) {
//			System.out.println("hi");
//		}
		
		int num = 1; 								//초기식 : 반복문의 조건식에 참조될 변수
		while(num <= 10) {							//조건식 : 초기식의 변수를 참조한 조건식
			System.out.println("num : " + num);		
			num += 1;								//증감식 : 조건식에 참조된 변수를 변화시킴
		}											//ㄴ 위치를 while 영역 최하단에 위치해라
		
	}
	

}
