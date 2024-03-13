package lv05;

import java.util.Arrays;

public class Ex06 {

	public static void main(String[] args) {
		
		String str = "11/100/89";
		//			  012345678
		//문제1) arr 배열에 각 점수를 저장하고, 총점 출력
		//정답1) 200
		int[] arr = new int[3];
		
		//str 숫자로 변경
		String[] result = str.split("/");	//	{"11","100","98"};
		
		
		int total = 0;
		for(int i=0; i<3; i++) {
			int number = Integer.parseInt(result[i]) ;
			arr[i] = number;
			total += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.print("총점 : " + total);
		
		
		//문제2) scores 배열의 각 점수를 슬러시를 구분자로 하나의 문자열로 연결
		//정답2) 11/100/89
		
		int[] scores = {11,100,89};
		String text = "";		
		
		for(int i=0; i<scores.length; i++) {
			text += scores[i] + "/";
		}
		// text : 11/100/89/ -> 11/100/89
		//		  0123456789	012345678
		text = text.substring(0,text.length()-1);
		System.out.println();

	}

}
