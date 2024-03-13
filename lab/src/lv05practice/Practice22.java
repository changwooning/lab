package lv05practice;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Practice22 {

	public static void main(String[] args) {

		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;

		String fileName = "fileTest02.txt";

		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		String data = "";

		if (file.exists()) {		// 파일이 존재하는지 확인여부
			try {
				// fr와 br을 사용하여 파일 읽기 시도
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				// 파일에서 데이터를 읽어와서 문자열 data에 추가
				while (br.ready()) 	// 읽을 문자열이 있을때까지 반복
					data += br.readLine() + "\n";

				br.close();
				fr.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			String[] temp = data.split("\n");

			int cnt = temp.length;

			// 배열 초기화
			ids = new String[cnt];
			pws = new String[cnt];
			moneys = new int[cnt];

			for (int i = 0; i < cnt; i++) {
				String[] info = temp[i].split("/");

				ids[i] += info[0];
				pws[i] += info[1];
				moneys[i] += Integer.parseInt(info[2]);
			}
		}else
			System.out.println("파일이 존재하지 않습니다.");
	}

}
