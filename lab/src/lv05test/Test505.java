package lv05test;

public class Test505 {
	
	// lv5 test
	// 1530

	public static void main(String[] args) {
		
		String [][] student = {
				{"aaa","신촌","1001"}, 	//128
				{"bbb","강남","1002"},	//155
				{"ccc","대치","1003"},	//170
				{"ddd","강동","1004"}		//157
			};
		
		String[][] score = {
				{"번호" ,"과목" , "점수"},
				{"1001" ,"국어","20"},
				{"1002" ,"국어","50"},
				{"1003" ,"국어","60"},
				{"1004" ,"국어","17"},
				{"1001" ,"수학","65"},
				{"1002" ,"수학","15"},
				{"1003" ,"수학","80"},
				{"1004" ,"수학","70"},
				{"1001" ,"영어","43"},
				{"1002" ,"영어","90"},
				{"1003" ,"영어","30"},
				{"1004" ,"영어","70"}
		};
		
		// 학생 정보와 성적이 담긴 데이터 이다.
		// student  => 1.id 2.주소 3.번호
		// score 	=> 1.번호 2.국어 3.수학 4.영어 점수이다.
		// 문제1) 전체 성적이 1등인 학생 이름 출력
		
		
		int max = 0;
		String name = "";
		for(int i=0; i<student.length; i++) {
			int total = 0;
			for(int j=1; j<score.length; j++) {
				if(student[i][2].equals(score[j][0]))
					total += Integer.parseInt(score[j][2]);
			}
			if(total > max) {
				max = total;
				name = student[i][0];
			}
		}
		
		System.out.printf("성적 : %s 이름 : %s",max,name);
		
		
		
		
		
		
		
		

	}

}
