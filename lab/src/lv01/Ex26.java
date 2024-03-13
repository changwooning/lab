package lv01;

public class Ex26 {

	public static void main(String[] args) {
		
		// 랜덤 Random : 난수 추출 (두번째 방법)
		
		double random = Math.random(); // 0부터 1미만 까지의 실수를 난수로 변환 (0.1212)
		System.out.println(random);
		
		// 정수 난수로 변환하기
		int min = 1;
		int max = 5;
		
		// double -> int
//		int rNum = (int) (Math.random() * (난수의개수)) + 시작값;
		int rNum = (int) (Math.random() * (max - min + 1)) + min;
		System.out.println(rNum);
		
		
		// 문제 1 1~10
		doble rNum1 = random.nextInt(10) + 1;
		System.out.println(rNum1);
		rNum = (int)(Math.random() * 10) + 1;
		System.out.println(rNum1);
		
		// 문제 2 3~7
		int ranNum2 = ran.nextInt(5) + 3;
		System.out.println(ranNum2);
		rNum = (int)(Math.random() * 5) + 2;
		System.out.println(rNum);
		
		// 문제 3 -3~3
		int ranNum3 = ran.nextInt(7) -3;
		System.out.println(ranNum3);
		rNum = (int)(Math.random() * 7) + -3;
		System.out.println(rNum);
		
		// 문제 4 2~5
		int ranNum4 = ran.nextInt(4) + 2;
		System.out.println(ranNum4);
		rNum = (int)(Math.random() * 4) + 2;
		System.out.println(rNum);
		
		// 문제 5 1000~9999
		int ranNum5 = ran.nextInt(9000) + 1000;
		System.out.println(ranNum5);
		rNum = (int)(Math.random() * 9000) + 1000;
		System.out.println(rNum);
		
		

	}

}
