package lv05;

import java.util.Calendar;

public class Ex04 {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		// charAt
		// substring

		String jumin = "950209-1234567"; // 청년 (30세)

		String mz = "3478";

		boolean age = mz.contains(jumin.substring(7, 8));
		int num = -1;
		if (age)
			num = Integer.parseInt("20" + jumin.substring(0, 2));
		else {
			num = Integer.parseInt("19" + jumin.substring(0, 2));
		}
		if (year - num > 0 && year - num < 40)
			System.out.println("청년");
		else
			System.out.println("노인");

		// jumin.substring(7) 1,2,5,6 => 1900
		// jumin.substring(7) 1,2,5,6 => 아니면 2000

	}

}
