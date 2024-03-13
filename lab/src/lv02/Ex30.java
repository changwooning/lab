package lv02;

public class Ex30 {

	public static void main(String[] args) {

		// 보조 제어문 : break, continue

		// 1) break : (자신이 속한) 반복문을 즉시 종료
		// 2) continue : (자신이 속한) 반복문의 시작점으로 돌아가게 함		

		int x = 10;								//초기식
		while (true) {							//조건식
			System.out.println(x);				
			int y = 20;							//초기식
			while(true) {						//조건식
				System.out.println(y);
				if (x == 15) {
					continue;
				}
				y++;							//증감식
				break;
			}
			x++;								//증감식
		}
				// 10 20 11 20 12 20 13 20 14 20 15 20 20 20 20 20202022002020202020202020202
	}

}
