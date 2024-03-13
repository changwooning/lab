package lv05test;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Test502 {

	// lv5 test
	// # 벡터 컨트롤러

	// 1106
	// 1120

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

			System.out.println(Arrays.toString(vector));

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");

			System.out.print("선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				System.out.print("추가할 값 : ");
				int num = scan.nextInt();

				int[] temp = vector;
				vector = new int[count + 1];

				for (int i = 0; i < count; i++)
					vector[i] = temp[i];

				vector[count] = num;
				count++;

			} else if (sel == 2) {

				System.out.print("삭제할 인덱스 : ");
				int delIdx = scan.nextInt();

				if (delIdx < 0 || delIdx > count - 1)
					continue;

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

			} else if (sel == 3) {

				String data = "";
				for (int i = 0; i < count; i++) {
					data += vector[i];

					if (i < count - 1)
						data += "/";
				}

				try {

					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
					System.out.println("파일저장완료");

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("파일저장실패");
				}

			} else if (sel == 4) {

				if (file.exists()) {

					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);

						String[] data = br.readLine().split("/");
						count = data.length;
						vector = new int[count];

						for(int i=0; i<count; i++)
							vector[i] = Integer.parseInt(data[i]);
						
						br.close();
						fr.close();
						System.out.println("파일 로드 완료");

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("파일 로드 실패");
					}
					
					
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}

			} else if (sel == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
