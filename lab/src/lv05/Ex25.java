package lv05;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Ex25 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] vector = null;
		int count = 0;

		String fileName = "vector.txt";

		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;

		while (true) {

			System.out.println("count : " + count);
			System.out.println(Arrays.toString(vector));

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");

			System.out.print("메뉴 선택 : ");
			String input = scan.nextLine();
			char sel = input.charAt(0);

			if (sel == '1') {
				System.out.print("추가할 숫자 입력 : ");
				try {
					int num = scan.nextInt();

					int[] temp = vector;
					vector = new int[count + 1];

					for (int i = 0; i < count; i++)
						vector[i] = temp[i];

					vector[count] = num;
					count++;

				} catch (Exception e) {
					System.err.println("입력 값은 숫자만 가능합니다.");
				}finally {
					scan.nextLine();	//	남은 버퍼 비우기
				}
			} else if (sel == '2') {
				System.out.print("delete number : ");
				try {
					int delNum = scan.nextInt();

					int delCnt = 0;
					for (int i = 0; i < count; i++) {
						if (vector[i] == delNum)
							delCnt++;
					}
					int[] temp = vector;
					vector = new int[count - delCnt];

					int idx = 0;
					for (int i = 0; i < count; i++) {
						if (temp[i] != delNum) {
							vector[idx] = temp[i];
							idx++;
						}
					}
					count -= delCnt;

				} catch (Exception e) {
					System.out.println("입력 값은 숫자만 가능합니다.");
				}finally {
					scan.nextLine();
				}

			} else if (sel == '3') {

				// 파일 생성 및 저장
				// vector 배열의 각 인덱스의 값들을 어떤 포맷으로 저장할까?

				String data = "";

				for (int i = 0; i < count; i++)
					data += vector[i] + "\n";
				data = data.substring(0, data.length() - 1);

				try {
					fw = new FileWriter(file);
					fw.write(data);
					fw.close();
					System.out.println("파일저장완료");
				} catch (Exception e) {
					System.out.println("파일저장실패");

				}

			} else if (sel == '4') {

				// vector 배열 = > 저장된 파일 기준으로 -> 덮어 씌우기

				if (file.exists()) {
					count = 0;
					vector = null;

					String data = "";

					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);

						// 파일 불러오기
						while (br.ready()) {
							data += br.readLine() + "/";
							count++;
						}

						br.close();
						fr.close();
						System.out.println("파일저장완료");
					} catch (Exception e) {
						System.out.println("파일저장실패");
					}
					vector = new int[count];
					String[] temp = data.split("/");

					for (int i = 0; i < count; i++)
						vector[i] = Integer.parseInt(temp[i]);

				} else {
					System.out.println("불러올 파일 데이터가 없습니다.");
				}

			} else if (sel == '5') {
				System.out.println("시스템 종료합니다.");
				break;
			}

		}

	}

}
