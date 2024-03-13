package lv04;

import java.util.Arrays;

public class Ex37 {

	public static void main(String[] args) {
		
		//문자열 비교
		
		// 1) A.equals(B)
		// ㄴ 문자열의 일치 여부를 boolean 으로 변환
		
		String str1 = "손창우";
		String str2 = "연건우";
		
		System.out.println(str1.equals(str2));

		// 2) A.compareTo(B)
		// ㄴ 문자열의 순서를 비교하여 "무엇을" 정수로 변환하냐
		// ㄴ A 문자열이 B 문자열과 비교했을 때 , 문자열 시퀀스의 위치를
		//	음수		: 앞에 있다.
		//	0		: 같다
		//	양수		: 뒤에 있다.
		
		String str3 = "a";
		String str4 = "b";
		String str5 = "b";
		
		System.out.println(str3.compareTo(str4));	// -1
		System.out.println(str4.compareTo(str3));	// 1
		System.out.println(str4.compareTo(str5));	// 0
		
		// 문제) 문자열 배열을 '가나다' 순으로 (오름차순) 정렬하기
		// 정답) { 김선영 박소정 손창우 윤소원 전누리}
		String[] names = {"윤소원" , "김선영" , "손창우" , "박소정" , "전누리"};
		
		for(int i=0; i<5-1; i++) {
			int idx = i;
			for(int j=i+1; j< 5; j++) {
				if(names[idx].compareTo(names[j]) > 0) // => 이해하기
						idx = j;	
			}
			String temp = names[i];
			names[i] = names[idx];
			names[idx] = temp; 
			
		}
		for(int i=0; i<5; i++) {
			System.out.print(names[i] + " ");
		}
		
		//선생님 풀이
		
		for(int i=0; i<names.length-1; i++) {
			int idx = i;
			for(int j=i+1; j<names.length; j++) {
				if(names[idx].compareTo(names[j]) > 0)
					idx = j;
			}
			String temp = names[i];
			names[i] = names[idx];
			names[idx] = temp;
		}
		System.out.println(Arrays.toString(names));
		
		
		
		
	}

}
