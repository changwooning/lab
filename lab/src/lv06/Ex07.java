package lv06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// # 더하기 게임
// 1. 1부터 10 사이의 랜덤한 값을 중복 없이 game 배열에 6개 저장한다.
// 2. 6개의 배열의 인덱스를 0부터 5사이의 랜덤 값 3개를 중복 없이 선택해
//		그 인덱스의 값의 합을 출력한다.
// 3. 사용자는 중복없이 3개의 인덱스를 골라 그 합을 맞추는 게임이다.
//  예) 4, 7, 5, 3, 2, 9 
//  문제 : 12  ==> 인덱스 3개를 골라서 합을 맞추면 된다.
//  정답) 1, 3, 4 (여러가지 경우의 수가 나올수는 있다)

class Game {

	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	int total;

	int[] game = new int[6];
	int[] idx = new int[3];
	int[] myIdx = new int[3];

	void setGame() {

		// set game
		for (int i = 0; i < game.length; i++) {
			game[i] = ran.nextInt(10) + 1;
			for (int j = 0; j < i; j++) {
				if (game[i] == game[j])
					i--;
			}
		}

	}

	void makeQuiz() {

		// quiz
		for (int i = 0; i < idx.length; i++) {
			idx[i] = ran.nextInt(game.length);

			boolean isDupl = false;
			for (int j = 0; j < i; j++) {
				if (idx[i] == idx[j])
					isDupl = true;
			}
			if (isDupl)
				i--;
			else
				total += game[idx[i]];

		}
	}

	void printQuiz() {

		// print quiz
		System.out.println(Arrays.toString(game));
		System.out.println("total : " + total);

	}

	int inputIndex() {

		// input
		int result = 0;
		for (int i = 0; i < myIdx.length; i++) {
			System.out.printf("index %d : ", i + 1);
			myIdx[i] = scan.nextInt();

			if (myIdx[i] < 0 || myIdx[i] > game.length - 1) {
				i--;
				continue;
			}

			boolean isDupl = false;
			for (int j = 0; j < i; j++)
				if (myIdx[i] == myIdx[j])
					isDupl = true;
			if (isDupl)
				i--;
			else
				result += game[myIdx[i]];
		}

		return result;
	}
	
	int GetResult() {
		
		int result = 0;
		result = inputIndex();
		return result;
		
	}

	void printResult(int result) {

		// result
		if (total == result)		
			System.out.println("딩동댕");
		else
			System.out.println("땡~");
	}

	void run() {

		setGame();
		makeQuiz();
		printQuiz();
		printResult(GetResult());
		
	}
}

public class Ex07 {

	public static void main(String[] args) {

		Game game = new Game();
		game.run();

	}

}
