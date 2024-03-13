package lv07;
import java.util.Arrays;
import java.util.Random;
// 1개 게임만 당첨인 5개짜리 로또세트 완성

// 게임 한 줄
class Lotto{
	
	// 접근 제어자
	// ㄴ 클래스 안에 멤버를 외부에서 접근할 수 있는 범주를 설정하는 것		1-4 비교 잘하기
	// 1) private		<- 클래스 내부 범위에서만 접근이 가능
	// 2) (defalit)
	// 3) protected
	// 4) public		<- 모든 범위에서 접근이 가능하다.
	
	// 정보 은닉 활용하여 -> 캡슐화를 구현할 수 있게됨  정보은닉 
	// ㄴ 대부분의 필드를 숨기고, 
	// ㄴ 선택적으로 객체 내부의 정보를 공개 하는 것
	
	
	private final int SEVEN = 7;
	private final int GOAL = 3;
	
	private boolean isGoal;
	private int[] lotto;
	
	
	// 생성자 사용하기 
	public Lotto(){
		
		lotto = new int[SEVEN];
		
		for(int i=0; i<SEVEN; i++)
			lotto[i] = (int)(Math.random() * 3) == 0 ? SEVEN : 0;
		
		checkGoal();
		
	}
	
	// getter & setter
	// ㄴ private field 를 처리하는 메소드

	// getter 를 만드는 법
	// public 리턴타입 get 변수명() { return this.변수명;}
	public boolean getIsGoal() {		// 게터
		
		return isGoal;
		
	}
	// setter 를 만드는법
	// public void set 변수명(변수타입 변수명) { this.변수명 = 변수명;} => 주석 참조 게터를 만드는 법
	private void setIsGoal(boolean isGoal) {		// 세터
		
		this.isGoal = isGoal;
		
	}
	
	private void checkGoal() {
		
		boolean isGoal = false;
		
		int cnt = 0;
		for(int i=0; i<SEVEN; i++) {
			if(lotto[i] == SEVEN)
				cnt ++;
			else
				cnt = 0;
			
			if(cnt == GOAL)
				isGoal = true;
		}
		
		setIsGoal(isGoal);
	}

	
	
	@Override
	public String toString() {
		
		return Arrays.toString(lotto) + (isGoal ? "<<< GOAL!" : "");
		
	}
	
	
}

// 여러개의 게임 (당첨 단 1개만 무조건 발생)
class LottoSet{
	
	final int NUMBER;
	
	Lotto[] set;
	
	LottoSet(int number){
		
		NUMBER = number;
		
	}
	
	void printGameSet() {
		
		for(int i=0; i<NUMBER; i++)
			System.out.println(set[i]);
		
	}
	
	void setGame() {
		
		set = new Lotto[NUMBER];
		
		boolean isGoal = false;
		for(int i=0; i<NUMBER; i++) {
			set[i] = new Lotto();
			
//			set[i].isGoal = true; // 수정을 허용하지 않음
								  // 조회는 허용
			if(set[i].getIsGoal() && !isGoal)
				isGoal = true;
			else if(set[i].getIsGoal())	// 중복 당첨일 때
				i--;
			
			if(i == NUMBER - 1 && !isGoal)
				i = -1;
		}
	}
	
	
	void run() {
		
		setGame();
		printGameSet();
		
	}
	
}
public class Ex08 {

	public static void main(String[] args) {
		
		LottoSet game = new LottoSet(5);
		game.run();

	}

}
