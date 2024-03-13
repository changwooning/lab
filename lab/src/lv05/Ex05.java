package lv05;

import java.util.Calendar;

public class Ex05 {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		
		String jumin = "950209-1234567"; // 청년 (30세)

		String mz = "3478";

		String birth = jumin.substring(0,2);	//jumin.charAt(0) + jumin.charAt(1)
		String gender = jumin.substring(7,8);	// jumin.charAt(7) + ""
												// String.value(jumin.charAt(7))
		
		//문제1) 나이 출력
		// 정답1) 00세
		
		int target = Integer.parseInt(birth);
		target = mz.contains(gender) ? target + 2000 : target + 1900;
		
		System.out.println(year - target + 1);
		
		// 문제2) 성별출력
		// 정답2) 남성
		
		System.out.println(Integer.parseInt(gender) % 2 == 1 ? "남" : "여");
		
		
		
	}

}
