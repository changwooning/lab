package lv02;

public class Ex09 {

	public static void main(String[] args) {
		
		
		//문제1) 9의 배수중 일의 자리가 6인 첫번째 배수 출력 ==> 답 :36
		
		// while 찾고싶을때 정답의 조건문을 찾아라 
		int x = 1;
		while((x * 9) % 10 != 6) {
			x += 1;
		}
		System.out.println(x * 9);
		// 9 18 27 45 
		
		
		boolean isRun = true;
		
		int n = 1;
		while(isRun) {
			if (n % 9 == 0 && n % 10 == 6) {
				//System.out.print(n);
				isRun = false;
			}
			n ++;
		}
		//System.out.print(n-1);
		
		
		//문제2) 9의 배수중 십의 자리가 6인 첫번째 배수 출력 ==> 답 :63
		// (x * 9) / 10 != 6;
		x = 1;
		while((x * 9) / 10 != 6) {
			x += 1;
		}
		System.out.println(x * 9);
		
		isRun = true;
		n = 1;
		while(isRun) {
			
		}
		//문제3) 8의 배수중 150보다 작고 150에 가장 가까운수를 출력 ==> 답 :144
		
		n = 150;
		while(n % 8 != 0) {
			n --;
		}
		System.out.println(n);
		
	

	}

}
