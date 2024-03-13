package lv05practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;


public class Practice52 {
	
	// 콘솔 게시판

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
			
			System.out.println("1.이전");
			System.out.println("2.이후");
			System.out.println("3.추가");
			System.out.println("4.삭제");
			System.out.println("5.내용확인");
			System.out.println("0.종료");
			
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1 && 1< curPageNum) {
				
				curPageNum --;
			}
			else if(sel == 2 && curPageNum < pageCount) {
				
				curPageNum ++;
				
			}
			else if(sel == 3) {
				scan.nextLine();
				
				
				System.out.print("title : ");
				String title = scan.nextLine();
				
				System.out.println("content : ");
				System.out.println("문장 끝에 .마침표 종료");
				
				String content = "";
					
				while(true) {
					String line = scan.nextLine();
					content += line + "<br>";
					
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
				count++;
				
			}
			else if(sel == 4) {
				
				System.out.print("삭제한 게시글 번호 : ");
				int delIdx = scan.nextInt();
				
				if(delIdx < 0 || delIdx > count -1)
					continue;
				
				String[][] temp = board;
				board = new String[count -1][];
				
				int idx = 0; 
				for(int i=0; i<count; i++) {
					if(i != delIdx) {
						board[idx] = temp[i];
						idx ++;
					}
				}
				count --;
				
			}
			else if(sel == 5) {
				
				System.out.print("불어올 게시글 번호 : ");
				int idx = scan.nextInt();
				
				if(idx < 0 || idx > count -1)
					continue;
				
				System.out.printf(" %s\n",board[idx][0]);
				
				System.out.println("내용 : ");
				String[] line = board[idx][1].split("<br>");
				
				for(int i=0; i<line.length; i++) {
					System.out.println(line[i]);
				}
				
			}
			
			
			
			
			
		}
		
		
		
		

	}

}
