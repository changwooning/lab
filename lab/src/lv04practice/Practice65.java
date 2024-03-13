package lv04practice;

public class Practice65 {

	public static void main(String[] args) {
		
		// 문제) 문자열 배열을 '가나다' 순으로 (오름차순) 정렬하기
		// 정답) { 김선영 박소정 손창우 윤소원 전누리}
		String[] names = {"윤소원" , "김선영" , "손창우" , "박소정" , "전누리"};
		
		for(int i=0; i<5-1; i++) {
			int idx = i;
			for(int j=i+1; j<5; j++) {
				if(names[idx].compareTo(names[j]) > 0)
					idx = j;
			}
			//값교체
			String temp = names[i];
			names[i] = names[idx];
			names[idx] = temp;
		}
		for(int i=0; i<5; i++) {
			System.out.print(names[i] + " ");
		}

	}

}
