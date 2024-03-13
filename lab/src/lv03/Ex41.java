package lv03;

import java.util.Scanner;

public class Ex41 {

	// [반복문 심화예제]

	// 1. -1이 나올 때까지 일련의 수를 입력받는다.
	// 2. 위 수 중 key 값이 몇 번째에 포함되어 있는가를 출력하는 프로그램을
	// 3. 단, key가 여러개 포함되어 있을 경우 앞에 나타난 거의 위치를 출력하고
	// 4. key가 일련의 수 안에 없는 경우 "not found"를 출력하시오.

	// 예)
	// result 값 입력 : 99
	//
	// 입력 : 10
	// 입력 : 99
	// 입력 : 20
	// 입력 : 99
	// 입력 : 30
	// 입력 : 99
	// 입력 : 10
	// 입력 : -1
	//
	// 결과 : key값 99가 첫번째 나타난 거의 2번째 이다.

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int key = 99;
		
		int input = 0;
		int find = 0;									// 첫번째 키 값의 번째수를 기억(발견 여부)
		
		int count = 1;									//입력 횟수를 세는 용도
		while (input != -1) {
			
			System.out.printf("%d번째 입력 : ",count);
			input = scan.nextInt();
			
			if(input == key && find == 0)
				find = count;
			
			count ++;

		}
		if(find == 0)
			System.out.println("not found");
		else
			System.out.printf("key값 99가 첫번째 나타난 것은 %d번째이다.",find);
		// 경우의 수 ==> -1 ==> 키는 입력받은적 없다.(not found)
		// 경우의 수 ==> 99, 77, -1, ==> 키는 1번이다.
		// 경우의 수 ==> 55, 99, 99, 99, 3, -1 ==> 키는 2번이다.

	}

}
