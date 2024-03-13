package lv05practice;

import java.util.Scanner;

public class Practice14 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] word = { "java", "spring", "mysql", "jsp" };

		for (int i = 0; i < 400; i++) {
			int idx = (int) (Math.random() * 4);
			String temp = word[0];
			word[0] = word[idx];
			word[idx] = temp;
		}

		for (int i = 0; i < word.length; i++) {
			int idx = (int) (Math.random() * word[i].length());
			String temp = "";
			while (true) {
				for (int j = 0; j < word[i].length(); j++) {
					if (j == idx)
						System.out.print("*");
					else
						System.out.print(word[i].charAt(j));
				}
				
				System.out.println();
				System.out.print("정답 : ");
				String input = scan.next();
				System.out.println("입력한 값 : " + input);
				if(!input.equals(word[i]))
					System.out.println("틀렸습니다.");
				else {
					System.out.println(i == word.length-1 ? "끝" : "정답입니다! 다음문제");
					break;
				}
				
			}
		}

	}

}
