package lv08;
import java.util.Scanner;
import java.util.ArrayList;


public class Ex02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> list = new ArrayList<>();	// 선언 및 초기화
		
		list.add(1);
		list.add(0);
		list.add(2);
		list.add(1);
		list.add(1);
		
		for(int i=0; i<list.size(); i++)
			System.out.println(System.identityHashCode(list.get(i)));

		while (true) {
			
			// 전체 출력
			for(int i=0; i<list.size(); i++)
				System.out.print(list.get(i) + " ");
			
			// 1.추가 2.인덱스로 삭제 3.값으로 삭제 4. 삽입 5.종료
			System.out.print("\n메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				System.out.print("data : ");
				int data = scan.nextInt();
				list.add(data);
				
			}
			else if(sel == 2) {
				
				System.out.print("idx : " );
				int idx = scan.nextInt();
				
				if(idx < 0 || idx > list.size()-1)
					continue;
				
				list.remove(idx);
				
			}
			else if(sel == 3) {
				
				System.out.print("data : ");
				Integer data = scan.nextInt();
				// data = new Integer(scan.nextInt());
				
				int idx = -1;
				for(int i=0; i<list.size(); i++)
					if(list.get(i).equals(data))
						idx = i;				// 여기까지는 마지막 값을 삭제하는데
				
				if(idx == -1)
					continue;
				
				list.remove(list.get(idx));		
				// 여기서 Integer Pool 안에 있는 값이니까 
				// 그값이 동일한 값이 첫번째 있으므로 첫번째 값이 삭제 된다
				
				
			}
			else if(sel == 4) {
				
				System.out.print("idx : ");
				int idx = scan.nextInt();
				System.out.print("data : ");
				int data = scan.nextInt();
				
				if(idx < 0 || idx > list.size()-1)
					continue;
				
				list.add(idx,data);
				
				
			}
			else if(sel == 5) {
				break;
			}

		}

	}

}
