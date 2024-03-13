package lv05;

import java.util.Random;

public class Ex39 {

	// # 경마 게임
	// 5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다.(0~3 범위)
	// 이동한거리의 합이 20이상이면 도착
	// 등수 출력
	// 조건) 단! 동시도착 예외처리

	// ㅡ ㅡ ㅡ ㅡ ㅡ 말 ㅡ -> jump 1
	// ㅡ ㅡ ㅡ ㅡ 말 ㅡ ㅡ -> jump 1
	// ㅡ ㅡ ㅡ ㅡ ㅡ 말 ㅡ -> jump 1

	public static void main(String[] args) {

		Random ran = new Random();

		final int MAX = 20;
		final int HORSE = 1;

		int horse[][] = new int[5][MAX];

		int rank[] = new int[5]; // 말 등수
		int total[] = new int[5]; // 말의 좌표 (옵션)

		// 출발 선상에 말 두기
		for (int i = 0; i < horse.length; i++) {
			int x = total[i];
			horse[i][x] = HORSE;
		}

		int record = 1;

		while (true) {

			// 트랙 출력
			System.out.println("RACE =>>>>");
			for (int i = 0; i < horse.length; i++) {
				for (int x = 0; x < MAX; x++) {
					if (horse[i][x] == HORSE)
						System.out.print("_말");
					else
						System.out.print("__");
				}
				System.out.println();
			}
			System.out.println();

			// 종료
			if (record > horse.length)
				break;

			boolean isGoal = false; // 동시 도착 예외처리 용도
			// 모든 말(1~5번)이 각각 랜덤 점프
			for (int i = 0; i < horse.length; i++) {

				if (rank[i] != 0) // 이미 도착한 말제외 넘어가기
					continue;

				int x = total[i]; // i번째 말의 현 위치
				int jump = ran.nextInt(4); // 0~4

				horse[i][x] = 0; // 말 지우기
				x += jump;

				if (x >= MAX - 1) {
					// 도착처리
					if(isGoal) {		// 이미 도착한 말이 있다는 소리
						i--;
						continue;		// 다시 한번 돌아야 하니까
					}
					x = MAX - 1;
					rank[i] = record++;
					isGoal = true;
				}
					
				horse[i][x] = HORSE; // 말 다시 그리기
				total[i] = x; // 좌표 갱신
			}

			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
		}
		// 성적표 출력
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%d번 말 : %d등\n", i + 1, rank[i]);
		}

	}

}
