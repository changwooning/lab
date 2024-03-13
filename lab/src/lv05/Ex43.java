package lv05;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Ex43 {
	
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
		
	
		String[][] board = null;	// => {"제목","내용"}
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
		
		
		while(true) {
			
			boolean isBoardUpdate = false;
			
			
			pageCount = count / pageSize + 1;
			
			
			
			
			System.out.println("---------------");
			System.out.println("[게시판]");
			for(int i=0; i<count; i++) {
					System.out.printf("%d.  %s\n", i+1,board[i][0]);
			}
			System.out.printf("[%d/%dpage] (%d)\n",curPageNum,pageCount,count);
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
			if(sel == 1) {
				
				
				curPageNum --;
				
			}
			// 2. 이후
			else if(sel == 2) {
				
				curPageNum ++;
				
			}
			// 3. 추가하기
			else if(sel == 3) {
				
				System.out.print("제목 입력 : ");
				String name = scan.next();
				System.out.print("내용 입력 : ");
				String input = scan.next();
				
				
				String[][] tempBoard = board;
				board = new String[count + 1][];
					
				for(int i=0; i<count; i++)
					board[i] = tempBoard[i];
					
				board[count] = new String[2];
				board[count][0] = name;
				board[count][1] = input;
				count ++;
				
				isBoardUpdate = true;
				
			}
			// 4. 삭제하기
			else if(sel == 4) {
				
				for(int i=0; i<count; i++) {
					System.out.printf("%d %s\n",i+1,board[i][0]);
				}
				
				System.out.print("삭제할 번호 : ");
				int delNum = scan.nextInt()-1;
				
				if(delNum < 0 || delNum > count-1)
					continue;
				
				String[][] tempBoard = board;
				board = new String[count-1][2];
				
				int idx = 0;
				for(int i=0; i<count; i++) {
					if(i != delNum) {
					board[idx] = tempBoard[i];
					idx ++;
					}
				}
				count --;
				
				isBoardUpdate = true;
				
			}
			// 5. 내용확인
			else if(sel == 5) {
				
			}
			else if(sel == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			if(isBoardUpdate) {
				
				String data = "";
				for(int i=0; i<count; i++) {
					data += board[i][0] + "/" + board[i][1];
					if(i <count -1)
						data += "\n";
				}
				try {
					
					fw = new FileWriter(fileName);
					fw.write(data);
					fw.close();
					System.out.println("파일 저장 완료");
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("파일 저장 실패");
				}
				
			}
			
			
			
		}
		
		
				

	}

}
