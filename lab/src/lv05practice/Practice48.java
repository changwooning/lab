package lv05practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;


public class Practice48 {

	// 콘솔 게시판
	// 0322
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[][] board = null;
		String fileName = "board.txt";
		
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		int count = 0;
		int pageSize = 5;
		int curPageNum = 1;
		int pageCount = 0;
		int startRow = 0;
		int endRow = 0;
		
		while(true) {
			
			startRow = (curPageNum -1) * pageSize;
			
			
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가");
			System.out.println("[4]삭제");
			System.out.println("[5]내용확인");
			System.out.println("[0]종료");
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1 && 1 < curPageNum) {
				
				curPageNum --;
				
			}
			else if(sel == 2 && curPageNum < pageCount) {
				
				curPageNum ++;
				
			}
			else if(sel == 3) {
				scan.nextLine();
				
				System.out.print("title : ");
				String title = scan.nextLine();
				
				System.out.println("contetn : ");
				System.out.println("문장 맨뒤에 .마침표 종료하기");
				
				String content = "";
				while(true) {
					
					String line = scan.nextLine();
					content = line + "<br>";
					if(line.charAt(line.length()-1) == '.')
						break;
				}
				
				String[][] temp = board;
				board = new String[count+1][];
				
				for(int i=0; i<count; i++)
					board[i] = temp[i];
				
				board[count] = new String[2];
				board[count][0] = title;
				board[count][1] = content;
				count ++;
				
			}
			else if(sel == 4) {
				
				
				
			}
			else if(sel == 5) {
				
				System.out.print("조회할 게시글 번호 : ");
				int idx = scan.nextInt();
				
				if(idx < 0 || idx > count -1)
					continue;
				
				System.out.printf("제목 : %s\n", board[idx][0]);
				System.out.println("내용 : ");
				
				String[] content = board[idx][1].split("<br>");
				
				for(int i=0; i<content.length; i++)
					System.out.println(content[i]);
				
			}
			else if(sel == 5) {}
			
			
			
		}
		
		
		
	
		
		

	}

}
