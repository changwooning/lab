package lv05practice;

public class Practice33 {

	public static void main(String[] args) {
		
		String[][] student = {
				{"bbb","강남","1002"},
				{"aaa","신촌","1001"},
				{"ccc","대치","1003"},
				{"ddd","강동","1004"}};
		
		String[][] score = {
				{"1001","100","20","30"},
				{"1002","10","60","60"},
				{"1003","23","63","31"},
				{"1004","45","30","35"},	
		};
		
		int max = 0;
		String hakbun = "";
		
		for(int i=0; i<score.length; i++) {
			
			String num = score[i][0];
			int total = 0;
			
			for(int j=1; j<score[i].length; j++) {
				total += Integer.parseInt(score[i][j]);
			}
			if(max < total) {
				max = total;
				hakbun = num;
			}
		}
		
		for(int i=0; i<student.length; i++) {
			if(student[i][2].equals(hakbun))
				System.out.printf("1등학생 %s의 성적은 %d점입니다.",student[i][0],max);
		}
		
		

	}

}
