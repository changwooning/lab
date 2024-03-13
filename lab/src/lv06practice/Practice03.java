package lv06practice;
import java.util.Scanner;

class Theater2{
	
	Scanner scan = new Scanner(System.in);
	
	int total;
	int[] seat = new int[7];
	
	final int PRICE = 12000;
	
	void run() {
		
		
		
		while(true) {
			
			System.out.println("GGV");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				for(int i=0; i<seat.length; i++)
					System.out.print(i+1 +" ");
				System.out.println();
				
				// print
				for(int i=0; i<seat.length; i++) {
					if(seat[i] == 0)
						System.out.print("◻︎ ");
					else
						System.out.print("◼ ");
				}
				
				// input
				System.out.print("\n좌석번호 : ");
				int idx = scan.nextInt()-1;
				
				if(idx < 0 || idx > seat.length-1)
					continue;
				
				if(seat[idx] == 1) {
					System.out.println("이미 예매된 좌석입니다.");
					continue;
				}
				
				seat[idx] = 1;
				
				total += PRICE;
				
			}
			else if(sel == 2) {
				break;
			}
		}
		System.out.printf("총 매출액 %d원입니다.", total);
		
		
	}
	
	
}

public class Practice03 {

	public static void main(String[] args) {
		
		Theater2 game = new Theater2();
		game.run();

	}

}
