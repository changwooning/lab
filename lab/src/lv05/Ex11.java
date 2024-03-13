package lv05;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String words[] = { "java", "mysql", "jsp", "spring" };
		for (int i = 0; i < 500; i++) {
			int index = (int) (Math.random() * 4);
			String temp = words[0];
			words[0] = words[index];
			words[index] = temp;
		}
		for (int i = 0; i < words.length; i++) {
			String temp = "";
			int index = (int) (Math.random() * words[i].length());
			while (true) {
				for (int j = 0; j < words[i].length(); j++) {
					if (j == index)
						System.out.print("*");
					else
						System.out.print(words[i].charAt(j));
				}
				System.out.println("문제: " + temp);
				System.out.print("정답: ");
				String answer = scan.next();
				System.out.println("입력한 값: " + answer);
				if (!answer.equals(words[i])) {
					System.out.println("틀렸습니다.");
				} else {
					System.out.println(i == words.length - 1 ? "끝!!" : "정답입니다! 다음문제");
					break;
				}
			}
		}

	}

}
