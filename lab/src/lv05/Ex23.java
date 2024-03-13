package lv05;

import java.io.FileWriter;

import java.io.File;

public class Ex23 {

	public static void main(String[] args) {

		// 파일 디렉토리
		// ㄴ 기본 경로 : 프로젝트 하위에 위치
		// * 변경가능 (위치)

		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.specification.maintenance.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.class.path"));

		// 바탕화면 (유저 홈 경로 하위에 desktop)에 파일 생성
		// ㄴ /Users/sonchangwoo/desktop/test.txt
		System.out.println();

		String fileName = "test.txt";

		String filePath = System.getProperty("user.home");
		String sep = System.getProperty("file.separator");
		

//	    filePath += sep + "desktop" + sep + fileName;
		filePath += sep + "desktop";
		System.out.println(filePath);

//		File file = new File(filePath);
		File file = new File(filePath,fileName);
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
			fw.write("손창우는 레벨통과 못함");
			fw.close();
			System.out.println("파일저장 완료");

		} catch (Exception e) {
			//e.printStackTrace();
			// System.out.println(e.getMessage());
			System.out.println("파일저장 실패");
		}

	}

}
