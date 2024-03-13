package lv05;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Ex24 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] vector = null;
		int count = 0;

		String fileName = "vector.txt";
		File file = new File(fileName);

		FileWriter fw = null;

		FileReader fr = null;
		BufferedReader br = null;
		String data = "";

		while (true) {

			System.out.println("count : " + count);
			System.out.println(Arrays.toString(vector));

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기"); // 인덱스 또는 값으로 삭제하기 (전체 삭제 아님)
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				System.out.print("숫자 입력 : ");
				int num = scan.nextInt();

				int[] temp = vector;
				vector = new int[count + 1];

				for (int i = 0; i < count; i++)
					vector[i] = temp[i];

				vector[count] = num;
				count++;

			} else if (sel == 2) {

				System.out.println("[2-1]삭제(인덱스)");
				System.out.println("[2-1]삭제(값)");

				System.out.print("선택 : ");
				int ssel = scan.nextInt();

				if (ssel == 1) {
					System.out.print("삭제할 인덱스 : ");
					int delIdx = scan.nextInt();

					if (delIdx < 0 || delIdx > count - 1) {
						System.out.println("입력 범위 오류");
						continue;
					}

					int[] temp = vector;
					vector = new int[count - 1];

					int idx = 0;
					for (int i = 0; i < count; i++) {
						if (i != delIdx) {
							vector[idx] = temp[i];
							idx++;
						}
					}
					count--;
				} else if (ssel == 2) {
					System.out.print("삭제할 값 : ");
					int delData = scan.nextInt();

					int delCnt = 0;
					for (int i = 0; i < count; i++) {
						if (vector[i] == delData)
							delCnt++;
					}

					int[] temp = vector;
					vector = new int[count - delCnt];

					int idx = 0;
					for (int i = 0; i < count; i++) {
						if (temp[i] != delData) {
							vector[idx] = temp[i];
							idx++;
						}
					}
					count -= delCnt;
				}

			} else if (sel == 3) {

				try {
					fw = new FileWriter(fileName);
					String temp = "";

					for (int i = 0; i < count; i++) {
						temp += vector[i];
						if (i < vector.length - 1) {
							temp += "/";
						}
					}
					fw.write(temp);

					fw.close();
					System.out.println("저장완료");
				} catch (IOException e) {
					System.out.println("저장실패");
				}
			} else if (sel == 4) {

				if (file.exists()) {
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);

						if (br.ready()) {
							data = br.readLine(); //
						}
						br.close();
						fw.close();

					} catch (IOException e) {
						e.printStackTrace();
					}

					String[] temp = data.split("/");

					count = temp.length; // 길이를 같게 해줄려고

					vector = new int[count];

					for (int i = 0; i < count; i++)
						vector[i] = Integer.parseInt(temp[i]);
				} else
					System.out.println("파일이 존재하지 않습니다.");

			} else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}

		}

	}

}
