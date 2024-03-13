package lv05;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex44 {
	
	// # 콘솔 게시판
		// 1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다.
		// 2. 현재 페이지 번호에 해당되는 게시글만 볼 수 있다.
		// 3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다.	0열->제목 1열-> 게시글
		// 4. 게시글을 추가하고 삭제할 때마다 파일입출력을 통해 데이터가 바로바로 저장된다.
		// 5. 실행시 저장되어 있는 파일이 존재한다면, 바로 파일을 불러오도록 설계한다.
		//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName = "board.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		
		String[][] board = null;	// => {{"제목","내용"},{"제목","내용"},{"제목","내용"}}
		int count = 0;			// 전체 게시글 수
		int pageSize = 5;		// 한 페이지에 보여줄 게시글 수
		int curPageNum = 1;		// 현재 페이지 번호
		int pageCount = 0;		// 전체 페이지 개수
		int startRow = 0;		// 현재 페이지의 게시글 시작 번호
		int endRow = 0;			// 현재 페이지의 게시글 마지막 번호
		
		if(file.exists()) {
			
			String data = "";
			
			try {
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				while(br.ready()) {
					data = br.readLine();
					count ++;
				}
				
				br.close();
				fr.close();
				System.out.println("파일로드 완료");
				
			}catch(Exception e) {
				
				System.out.println("파일로드 실패");
			}
			
			board = new String[count][];
			String[] info = data.split("\n");
			
			for(int i=0; i<count; i++) {
				board[i] = info[i].split("/");
			}
			
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
		
		boolean isRun = true;
		while(isRun) {
			
			// paging중요한 처리..
			startRow = (curPageNum - 1) * pageSize;
			endRow = startRow + pageSize - 1;		//	 인덱스로 사용하기 때문에 -1 해줌
			endRow = endRow >= count ? count - 1 : endRow;		// 인덱스라서 = 포함
			
			pageCount = count / pageSize;
			pageCount = count % pageSize > 0 ? ++ pageCount : pageCount;
			
			
			System.out.println("---- BOARD ----");
			System.out.printf("total : %d\n", count);
			System.out.printf("page : %d/%d\n", curPageNum,pageCount);
			System.out.println("---------------");
			for(int i=startRow; i<=endRow; i++)
				System.out.printf("%d) %s\n", i+1,board[i][0]);
			System.out.println("---------------");
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");
			System.out.println("[0]종료하기");
			System.out.println("---------------");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			// 1. 이전
			if(sel == 1 && 1 < curPageNum) {
				
				curPageNum --;
				
			}
			// 2. 이후
			else if(sel == 2 && curPageNum < pageCount) {
				
				curPageNum ++;
			}
			// 3. 추가하기
			else if(sel == 3) {
				scan.nextLine();
				
				System.out.print("title : ");
				String title = scan.nextLine();
				
				System.out.println("content : ");
				System.out.println("(문장의 끝에 .마침표를 붙이면 종료");
				
				String content = "";
				while(true) {
					String line = scan.nextLine();
					content += line + "<br>";  	// 줄바꿈
					
					if(line.charAt(line.length()-1) == '.')
						break;
				}
				
				
				String[][] temp = board;
				board = new String[count + 1][];
				
				for(int i=0; i<count; i++) 
					board[i] = temp[i];
				
				board[count] = new String[2];
				board[count][0] = title;
				board[count][1] = content;
				count ++;
				
				
			}
			// 4. 삭제하기
			else if(sel == 4) {
				
				System.out.print("삭제할 게시글의 번호 : ");
				int delIdx = scan.nextInt();
				
				if(delIdx < 0 || delIdx > count -1)
					continue;
				
				String[][] temp = board;
				board = new String[count-1][];
				
				int idx = 0;
				for(int i=0; i<count; i++) {
					if(i != delIdx) {
						board[idx] = temp[i];
						idx ++;
					}
				}
				count --;
				
			}
			// 5. 내용확인
			else if(sel == 5) {
				
				System.out.print("조회할 게시글의 번호 : ");
				int idx = scan.nextInt()-1;
				
				if(idx < 0 || idx > count -1)
					continue;
				
				// 죄회
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
			
			// 저장
			
			String data = "";
			
			for(int i=0; i<count; i++) {
				String title  = board[i][0];
				String content  = board[i][1];
				
				data += title + "/" + content;
				
				if(i < count-1)
					data += "\n";
			}
			
			try {
				
				fw = new FileWriter(fileName);
				fw.write(data);
				fw.close();
				
				System.out.println("파일저장 완료");
			}catch(Exception e) {
				System.out.println("파일저장 실패");
			}
			
			
			
		}
		
	}

}
