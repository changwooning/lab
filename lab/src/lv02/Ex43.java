package lv02;

public class Ex43 {

	public static void main(String[] args) {

		//문제4) 50에서 100까지 자연수중에서 9의 배수의 개수를 출력 # 답 : 6 (54,63,72,81,90,99)
		int cnt = 0;
		int n = 50;
		while(n <= 100) {
			if(n % 9 == 0) {
				cnt += 1;
			}
			
			n += 1;
		}
		System.out.println(cnt);
		
		//문제5) 28의 배수 중에서 가장 큰 세자리 수를 출력 == 답 : 980
		n = 999;
		while(n % 28 != 0) {
		
			n -= 1;
		}
		System.out.println(n);
		System.out.println();
		
		int max = 0;
		n = 100;
		while(n < 1000) {
			if(n % 28 == 0) {
				max = n;
			}
			n += 1;
		}
		System.out.println(max);
		
		//문제6) 8의 배수를 작은수부터 5개 출력 == > 답 : 8,16,24,32,40
		n = 1;
		while(n <= 5) {
			System.out.print(n * 8 + " ");
		
			n += 1;
		}
		
	}

}
