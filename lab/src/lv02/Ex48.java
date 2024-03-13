package lv02;

public class Ex48 {
	// # 369게임
		// 1. 1~50까지 반복을 한다.
		// 2. 그 안에서 해당 숫자의 369게임의 결과를 출력한다.
		// 예) 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 ...
		//
	
	//1931
	//1936

	public static void main(String[] args) {
		
		//50회 반복
		int n = 1;
		while(n <= 50) {
			
			//십의 자리
			int x = n / 10;
			//일의자리
			int y = n % 10;
			
			int cnt = 0;
			
			//십의자리 박수증가
			if(x % 3 == 0 && x != 0)
				cnt += 1;
			//일의자리 박수증가
			if(y % 3 == 0 && y != 0)
				cnt += 1;
			
			if(cnt > 0) {
				while(cnt > 0) {
					System.out.print("짝");
					cnt -= 1;
				}
			}else {
				System.out.print(n + " ");
			}
			
			
			n += 1;
		}

	}

}
