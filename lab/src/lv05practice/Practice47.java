package lv05practice;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Practice47 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String fileName = "board.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		String[][] board = null;
		int count = 0;		// 전체 게시글 수
		int pageSize = 5;	// 한 페이지에 보여줄 게시글 수
		int curPageNum = 1;	// 현재 페이지 번호
		int pageCount = 0;	// 전체 페이지 개수
		int startRow = 0;	// 현재 페이지의 게시글 시작 번호
		int endRow = 0;		// 현재 페이지의 게시글 마지막 번호
		
		if(file.exists()) {
			
			String data = "";
			count = 0;
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				while(br.ready()) {
					data += br.readLine() + "\n";
				}
				
				br.close();
				fr.close();
				System.out.println("파일 로드 완료");
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("파일 로드 실패");
			}
			
			board = new String[count][2];

			String[] temp = data.split("\n");
			
			count = temp.length;
			
			
			for(int i=0; i<count; i++) {
				String[] info = temp[i].split("/");
				
				board[i][0] = info[0];
				board[i][1] = info[1];
			}
			
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
		
		boolean isRun = true;
		while(isRun) {
			
			startRow = (curPageNum - 1) * pageSize;
			endRow = startRow + pageSize - 1;
			endRow = endRow >= count ? count -1 : endRow;
			
			pageCount = count / pageSize;
			pageCount = count % pageSize > 0 ? ++ pageCount : pageCount;
			
			
			System.out.printf("total : %d\n",count);
			System.out.printf("page : %d/%d\n", curPageNum,pageCount);
			for(int i=startRow; i<=endRow; i++)
				System.out.printf("%d) %s\n", i+1,board[i][0]);
			
			
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
				
				System.out.println("content : ");
				System.out.println("문장의 끝에 .마침표를 붙이면 종료");
				
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
				count ++;
				
			}
			else if(sel == 4) {
				
				System.out.print("삭제할 게시글의 번호 : ");
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
				count -- ;
				
				
			}
			else if(sel == 5) {
				
				System.out.print("조회할 게시글의 번호 : ");
				int idx = scan.nextInt();
				
				if(idx < 0 || idx > count -1)
					continue;
				
				System.out.printf("제목 : %s\n", board[idx][0]);
				System.out.println("내용 : ");
				
				String[] content = board[idx][1].split("<br>");
				
				for(int i=0; i<content.length; i++)
					System.out.println(content[i]);
			}
			else if(sel == 0) {
				
				System.out.println("프로그램을 종료합니다.");
				isRun = false;
			}
			
			String data = "";
			for(int i=0; i<count; i++) {
				data += board[i];
				if(i < count -1)
					data += "\n";
			}
			try {
				fw = new FileWriter(fileName);
				fw.write(data);
				fw.close();
				System.out.println("파일저장 완료");
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("파일저장 실패");
			}
			
			
		}

	}

}
