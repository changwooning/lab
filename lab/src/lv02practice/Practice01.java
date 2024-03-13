package lv02practice;


public class Practice01 {

	public static void main(String[] args) {
		
		// 문제1) 1~10까지 반복해 5~9 출력   1~10까지 반복문 5~9까지 조건문
		// 정답1) 5,6,7,8,9
		int n = 1;
		while(n <= 10) {
			if(n >= 5 && n <= 9)
				System.out.print(n + " ");
			n++;
		}
		
		System.out.println();
		
		for(int i=1; i<=10; i++) {
			if(i >=5 && i<= 9)
				System.out.print(i + " ");
		}
		
		System.out.println();
		// 문제2) 10~1까지 반복해 6~3 거꾸로 출력
		// 정답2) 6,5,4,3
		n = 10;
		while(n > 0) {
			if(n > 2 && n < 7)
				System.out.print(n + " ");
			n--;
		}
		
		System.out.println();

		for(int i=10; i>0; i--) {
			if(i>2 && i<7)
				System.out.print(i + " ");
			 
		}
		System.out.println();
		
		
		// 문제3) 1~10까지 반복해 짝수만 출력
		// 정답3) 2,4,6,8,10
		n = 1;
		while(n <= 10) {
			if(n % 2 == 0)
				System.out.print(n + " ");
			n++;
		}
		
		System.out.println();
		
		for(int i=1; i<=10; i++) {
			if(i % 2 == 0)
				System.out.print(i + " ");
		}
		
		
		
		
	}

}
