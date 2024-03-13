package lv05;

import java.util.Calendar;

public class Ex03 {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		
		// charAt
		// substring
		
		// 두 가지 버전으로 풀이
		
		String jumin =  "950209-1234567";
					//   01234567
		// 문제 1) 나이 출력
		// 정답 2) 00세
		
		int num = Integer.parseInt(jumin.substring(0, 2));
		System.out.println(year - (1900+num)); 
		
		String num1 = "19";
		int number1 = Integer.parseInt(String.valueOf(num1 + jumin.charAt(0) + jumin.charAt(1)));	// 95
		System.out.println(number1);
		
		
		// 문제 2) 성별 출력
		// 정답 2) 남성
		
		int number3 = Integer.parseInt(jumin.substring(7,8));
		if(number3 % 2 == 1) {
			System.out.println("남성");
		}else
			System.out.println("여성");
		
		int number4 = Integer.parseInt(String.valueOf(jumin.charAt(7)));
		if(number4 % 2 == 1) {
			System.out.println("남성");
		}else
			System.out.println("여성");
		
		
		
		
		// 1,3,5 -> 남
		// 2,4,6 -> 여

	}

}
