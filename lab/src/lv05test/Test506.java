package lv05test;

import java.util.Arrays;

public class Test506 {
	
	// lv5 test

	public static void main(String[] args) {
		
		String data = "123+46";		
		String delimiter = "+";
		
		// test cast
		// 123+46+1
		// 1+2+3+4+5		
		
		// 위 수의 합을 구하시오
		// split() 메서드 로직을 직접 만들기
		
		
		String result = "";
		int sum = 0;
		for(int i=0; i<data.length(); i++) {
			if(data.charAt(i) == delimiter.charAt(0))
				result += data.charAt(i);
		}
		
		
	}

}
