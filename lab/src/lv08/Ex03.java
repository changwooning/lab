package lv08;


public class Ex03 {
	public static void main(String[] args) {
		
		// String Pool
		
		String str1 = "손창우";
		String str2 = "손창우";
		
		System.out.println(str1 == str2);			// true
		
		String str3 = new String("손창우");
		
		System.out.println(str1 == str3);			// false
		System.out.println(str1.equals(str3));		// true
		System.out.println(str1.equals(str2));		// true
		
		
		System.out.println(System.identityHashCode(str1));	// 305808283
		System.out.println(System.identityHashCode(str2));	// 305808283
		System.out.println(System.identityHashCode(str3));	// 2111991224
		
		// Integer Pool
		// ㄴ -128 ~ +127
		
		Integer num1 = 127;
		Integer num2 = 127;

		System.out.println(num1 == num2);	// true
		
		Integer num3 = 128;
		Integer num4 = 128;
		
		System.out.println(num3 == num4);	// false
		
		System.out.println(System.identityHashCode(num1));	// 292938459
		System.out.println(System.identityHashCode(num2));	// 292938459
		System.out.println(System.identityHashCode(num3));	// 917142466
		System.out.println(System.identityHashCode(num4));	// 1993134103
		
		
		
	}

}
