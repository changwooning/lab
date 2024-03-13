package lv04;

import java.util.Scanner;

public class Ex32 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		// 문자열 비교
		// == 사용 x
		// equals() 메소드 사용
		
		// java : String Contstant Pool (Heap)
		
		String str1 = "손창우";
		String str2 = "손창우";
		String str3 = scan.next();			// 손창우
		String str4 = new String("손창우");	// 손창우
		
		System.out.println(str1 == str2);	// true
		System.out.println(str2 == str3);	// false
		System.out.println(str2 == str4);	// false
		System.out.println(str3 == str4);	// false
		
		//고유 ID 조회
		System.out.println(System.identityHashCode(str1));	//381707837
		System.out.println(System.identityHashCode(str2));	//381707837
		System.out.println(System.identityHashCode(str3));	//589446616
		System.out.println(System.identityHashCode(str4));	//1321640594
		
		
		// 문자열의 각 캐릭터(문자 한개씩)를 비교해주는
		// 기 구현된 메소드인 equals를 써서
		// 문자열의 비교를 정확히 할 수 있다.
		
		
		
		
		
	}

}
