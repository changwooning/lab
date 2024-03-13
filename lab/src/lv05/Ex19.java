package lv05;

import java.io.IOException;
import java.io.FileWriter;

public class Ex19 {

	public static void main(String[] args) {

		String[] names = { "mom", "megait", "github" };
		String[] pws = { "1111", "2222", "3333" };
		int[] moneys = { 20000, 30000, 40000 };

		String fileName = "fileTest02.txt";
		String data = "";

		// 위 데이터를 아래와 같이 저장해보세요.

		// mom/1111/20000
		// megait/2222/30000
		// github/3333/40000
		for (int i = 0; i < names.length; i++) {
			data += names[i] + "/" + pws[i] + "/" + moneys[i];
			if( i < names.length - 1)
				data += "\n";
		}

		// 1. try 구문
		try {
			FileWriter fw = new FileWriter(fileName);

			fw.write(data);

			fw.close();
			System.out.println("저장완료");

		} catch (IOException e) {

			System.out.println("저장실패");
		}

	}

}
