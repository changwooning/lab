package lv05;

public class Ex01 {

	public static void main(String[] args) {
		
		// 문자열
		// ㄴ 문자의 나열 (배열)
		// ㄴ char[] 
		
		// "apple"
		// {'a','p','p','l','e'}
		//	 0	 1	 2	 3	 4		<- index 존재
		
		// 형 변환 Type casting
		
		// 문자 -> 숫자
		char a = 'a';
		int num = (int)a;  // => int 생략 가능
		
		System.out.println("num : " + num);	 // 97 (ascii decimal) 
		
		// 숫자 -> 숫자
		char b = (char) ++num;
		
		System.out.println("b  : " + b);	// b
		
		// 문자열 -> 숫자
		// ㄴ 문자열이 모든 캐릭터가 숫자여야한다.
		
		String str = "12345";
		System.out.println(str + 1);		// 123451 (문자열 확장)
		
		num = Integer.parseInt(str);		// 형변환 불가한 경우 발생,NumberFormat Excetion
		System.out.println(num + 1);		// 12346
		
		
		// 숫자-> 문자열
		num = 1000;
		str = String.valueOf(num);			// 모든타입 가능
		
		System.out.println(str + 1);		// 10001
		
		// str = num + ""; => t사용가능
		
		
		
	}

}
