package lv03;

public class Ex09 {

	public static void main(String[] args) {

		// 문제1) a의 값과 b의 값을 번갈아가면서 c에 저장
		// 예) c = {10,40,20,50,30,60}

		int a[] = { 10, 20, 30 };
		int b[] = { 40, 50, 60 };
		int c[] = { 0, 0, 0, 0, 0, 0 };

		int index = 0;
		for (int i = 0; i < 3; i++) { // a[0],b[0] 1,2 중복 3번 반복
			c[index] = a[i];
			index++;
			c[index] = b[i];
			index++;
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();

		// 문제2) aa배열의 값들을 앞으로 한칸씩 당기고 맨뒤에 bb의 값을 저장
		int aa[] = { 10, 20, 30, 40, 50 };
		int bb = 90;
		// 예) aa = {20,30,40,50,90};
		// 반복되는 규칙을 찾아라

		for (int i = 0; i < 5; i++) {
			if (i == 4) {
				aa[4] = bb;
			} else {
				aa[i] = aa[i + 1];
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.print(aa[i] + " ");
		}

		// 문제3) cc의 배열을 뒤로 하나씩 밀어낸후 맨 앞에 dd의 값을 저장
		int cc[] = { 10, 20, 30, 40, 50 };
		int dd = 60;
		// 예) cc[] = {60,10,20,30,40};
		// 예외도 조건과 똑같이
		
		for (int i=4; i>0; i--) {
			cc[i] = cc[i-1];
		}
		cc[0] = dd;
		
		//{ 10, 20, 30, 40, 40 }  i : 4
		//{ 10, 20, 30, 30, 40 }  i : 3
		//{ 10, 20, 20, 30, 40 }  i : 2
		//{ 10, 10, 20, 30, 40 }  i : 1
		
		
//		for(int i=0; i<4; i++) {    안되는 예
//			cc[i+1] = cc[i];
//		}
		
		
		
//		for (int i = 4; i >= 0; i--) {
//			if (i == 0) {
//				cc[i] = dd;
//			} else {
//				cc[i] = cc[i -1];
//			}
//		}
//		
//		for(int i=0; i<5; i++) {
//			System.out.print(cc[i] + " ");
//		}

	}

}
