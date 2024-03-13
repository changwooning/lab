package lv05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;

public class Ex21 {

	public static void main(String[] args) {

		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;

		String fileName = "fileTest02.txt";

		try {

			FileReader fr = new FileReader(fileName); // 존재여부
			BufferedReader br = new BufferedReader(fr); //

			// 1. 줄 개수 확인
			int cnt = 0;
			while (true) {
				if (br.readLine() != null) {
					cnt++;
				}else
					break;
			}
			// 1-1. 종료
			br.close();
			fr.close();

			// 1-2. 다시 불러옴 (fr,br)
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			// 2. 줄 개수확인한것을 새로 초기화
			ids = new String[cnt];
			pws = new String[cnt];
			moneys = new int[cnt];
			
			// 3. for문으로 개수만큼 돌리고
			for(int i=0; i<cnt; i++) {
				// 3-1. 한줄씩 확인(읽고)하고
				String temp = br.readLine();
				// 3-2. 구분하고
				String[] temp2 = temp.split("/");
				// 3-3. 저장하고
				ids[i] = temp2[0];
				pws[i] = temp2[1];
				moneys[i] = Integer.parseInt(temp2[2]);
			}
			// 4. 다시 종료
			br.close();
			fr.close();
			
			// 5. 출력
			System.out.println("파일저장 완료");
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(moneys));

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일저장 실패");
		}

	}

}
