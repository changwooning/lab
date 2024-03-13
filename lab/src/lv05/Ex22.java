package lv05;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;

public class Ex22 {

	public static void main(String[] args) {

		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;

		String fileName = "fileTest02.txt";

		File file = new File(fileName);	

		FileReader fr = null; // 보기
		BufferedReader br = null; // 불러오고

		String data = "";

		if (file.exists()) {

			try {

				fr = new FileReader(file);		// new FileReader(fileName);
				br = new BufferedReader(fr);
				
				while(br.ready()) {
					data += br.readLine() + "\n";	//밑에 주석대신 사용
				}

//				String line = br.readLine();
//				while (line != null) {
//					data += line + "\n";
//					line = br.readLine();
//				}

				br.close();
				fr.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			String[] temp = data.split("\n");

			int cnt = temp.length;

			ids = new String[cnt];
			pws = new String[cnt];
			moneys = new int[cnt];

			for (int i = 0; i < cnt; i++) {
				String[] info = temp[i].split("/");

				ids[i] = info[0];
				pws[i] = info[1];
				moneys[i] = Integer.parseInt(info[2]);
			}
		} else
			System.out.println("파일이 존재하지 않습니다.");

	}

}
