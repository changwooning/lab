package lv06test;

import java.util.Random;
//1. OMR카드: 클래스 + 메소드
//1. 배열 answer는 시험문제의 정답지
//2. 배열 hgd에 1~5사이의 랜덤 숫자 5개 저장
//3. answer와 hgd 값을 비교해 정오표를 출력
//4. 한문제당 20점
//ex) 
// answer={1,3,4,2,5}
// hgd = {1,1,4,4,3}
// 정오표 = {o,x,o,x,x}
// 성적 = 40점


class OMR {
	
	// test6 1번
	// 1005
	// 1028
	Random ran = new Random();
	
   int answer[] = { 1, 3, 4, 2, 5 };
   int hgd[];
   int score;
   
   
   void result() {
	   
	   for(int i=0; i<answer.length; i++)
		   System.out.printf("%d) %d : %d [%s]\n", i+1, answer[i],hgd[i], answer[i] == hgd[i] ? "O" : "X");
	   System.out.print("성적 : "+ score);
		   
	   
   }
   
   void	setRandom() {
	   
	   for(int i=0; i<answer.length; i++) {
		   int rNum = ran.nextInt(5)+1;
		   hgd[i] = rNum;
		   if(answer[i] == hgd[i])
			   score += 20;
		   
	   }
	   
	   
   }
   
   void setGame() {
	   
	   hgd = new int[5];
	   int cnt = 0;
	   
   }
   
   void run() {
	   
	   setGame();
	   setRandom();
	   result();
	   
	   
   }
   
}

public class Test601 {
	
	

	public static void main(String[] args) {
		
		OMR omr = new OMR();
		omr.run();

	}

}
