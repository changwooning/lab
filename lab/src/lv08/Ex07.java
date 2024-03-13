package lv08;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Subject{
	
	private String title;
	private int score;
	private int code;
	
	public Subject(int code,String title) {
		this.code = code;
		this.title = title;
	}
	
	public int getCode() {
		return this.code;
	}
	public String getTitle() {
		return this.title;
	}
	public int getScore() {
		return this.score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public Subject clone() {
		Subject subject = new Subject(this.code,this.title);
		subject.setScore(this.score);
		return subject;
	}
	
	
}

class Student{
	
	private String name;		// 이름
	private int code;			// 학번
	private ArrayList<Subject> subjects;
	
	public Student(String name,int code) {
		this.name = name;
		this.code = code;
		subjects = new ArrayList<>();		// subjects 초기화
	}
	public int getCode() {
		return this.code;
	}
	public String getName() {
		return this.name;
	}
	
	public double getScoreAverage() {
		
		double average = 0;
		double total = 0;
		for(Subject subject : subjects)
			total += subject.getScore();
		
		average = total / subjects.size();
		return average;
	}
	
	public int getSubjectsSize() {
		return this.subjects.size();
	}
	
	// 코드를 가지고있는지 유무
	public boolean hasSubject(int code) {
		for(Subject subject : subjects) {
			if(subject.getCode() == code)
				return true;
		}
		return false;
	}
	
	public void addSubject(Subject subject) {		// 우회하는 방식
		subjects.add(subject);
	}
	
	public void printSubjectAll() {
		for(int i=0; i<subjects.size(); i++) {
			Subject subject = subjects.get(i);
			System.out.printf("%d) %s", i+1,subject.getTitle());
		}
	}
	
	// 수강 과목에 대한 추가 또는 삭제,수정
	// Create
	// Read
	// Update
	// Delete
	
	// R.해당 Subject
	public Subject getSubject(int idx) {
		Subject subject = subjects.get(idx);
		return subject.clone();
	}
	
	// U.해당 Subject
	public void setSubject(int idx,Subject subject) {
		Subject temp = subjects.get(idx);
		
		if(temp.getCode() == subject.getCode()) {
			temp.setScore(subject.getScore());
		}
	}
	
	// D.해당 Subject
	public void removeSubject(int idx) {
		if(idx < 0 || idx > subjects.size()-1) {
			System.err.println("유효하지 않은 범위입니다.");
			return;
		}
		subjects.remove(idx);
	}
	
	@Override
	public String toString() {
		String info = String.format("%s(%d)\n",this.name,this.code);
		
		for(Subject subject : subjects) {
			info += "\n";
			info += subject.getTitle() + " : " + subject.getScore();
		}
		return info;
	}
	
	
	
}

class Manager{
	
	private ArrayList<Student> group;
	private ArrayList<Subject> subjects;
	private Scanner scan;
	
	private final int STUDENT = 1;
	private final int SUBJECT = 2;
	private final int SCORE = 3;
	private final int SORT = 4;
	private final int FILE = 5;
	
	private final int STUDENT_JOIN = 1;
	private final int STUDENT_LEAVE = 2;
	private final int STUDENT_SEARCH = 3;
	
	private final int SUBJECT_ENROLL = 1;
	private final int SUBJECT_SELECT = 2;
	private final int SUBJECT_CANCEL = 3;
	
	private final int SCORE_UPDATE = 1;
	
	private final int SORT_CODE = 1;
	private final int SORT_NAME = 2;
	private final int SORT_SCORE = 3;
	
	private final int FILE_SAVE = 1;
	private final int FILE_LOAD = 2;
	
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	private File file;
	private String fileName;
	
	public Manager() {
		this.group = new ArrayList<>();
		this.subjects = new ArrayList<>();
		this.scan = new Scanner(System.in);
		
		this.fileName = "lms.txt";
		this.file = new File(fileName);
	}
	
	public void run() {
		
		while(true) {
			showMenu();
			int sel = inputNumber("MENU");
			runMenu(sel);
		}
		// 1. 학생
		//	  ㄴ 등록
		//	  ㄴ 제적
		//	  ㄴ 조회
		// 2. 과목
		//	  ㄴ 등록
		//	  ㄴ 신청(수강)
		//	  ㄴ 철회(수강)
		// 3. 성적
		//	  ㄴ 수정(수강과목)
		// 4. 정렬
		//	  ㄴ 학번(오름차순)
		//	  ㄴ 이름(오른차순)
		//	  ㄴ 성적(내림차순)
		// 5. 파일
		//	  ㄴ 저장
		//	  ㄴ 로드
		
	}
	private void showMenu() {
		System.out.println("1. 학생");
		System.out.println("2. 과목");
		System.out.println("3. 성적");
		System.out.println("4. 정렬");
		System.out.println("5. 파일");
	}
	
	private void showStudentSubMenu() {
		System.out.println("1) 등록");
		System.out.println("2) 제적");
		System.out.println("3) 조회(학번)");
	}
	
	private void showSubjectSubMenu() {
		System.out.println("1) 등록");
		System.out.println("2) 신청(수강)");
		System.out.println("3) 철회(수강)");
	}
	
	private void showScoreSubMenu() {
		System.out.println("1) 수정(수강과목)");
	}
	
	private void showSortSubMenu() {
		System.out.println("1) 학번(오름차순)");
		System.out.println("1) 학번(오름차순)");
		System.out.println("1) 학번(오름차순)");
	}
	
	private void showFileSubMenu() {
		System.out.println("1) 저장");
		System.out.println("2) 로드");
	}
	
	private int inputNumber(String message) {
		int number = 0;
		System.out.print(message + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	private String inputString(String message) {
		System.out.print(message + " : ");
		return scan.next();
	}
	
	private void runMenu(int sel) {
		switch(sel) {
			case(STUDENT) : 
				showStudentSubMenu();
				runStudentSubMenu(option());
				break;
			case(SUBJECT) :
				showSubjectSubMenu();
				runSubjectSubMenu(option());
				break;
			case(SCORE) :
				showScoreSubMenu();
				runScoreSubMenu(option());
				break;
			case(SORT) :
				showSortSubMenu();
				runSortSubMenu(option());
				break;
			case(FILE) :
				showFileSubMenu();
				runFileSubMenu(option());
				break;
		}
	}
	
	private void runStudentSubMenu(int option) {
		if(option == STUDENT_JOIN) 
			joinStudent();
		else if(option == STUDENT_LEAVE)
			leaveStudent();
		else if(option == STUDENT_SEARCH)
			searchStudent();
	}
	
	private void runSubjectSubMenu(int option) {
		if(option == SUBJECT_ENROLL)
			enrollSubject();
		else if(option == SUBJECT_SELECT)
			selectSubject();
		else if(option == SUBJECT_CANCEL)
			cancelSubject();
	}
	
	private void runScoreSubMenu(int option) {
		if(option == SCORE_UPDATE)
			scoreUpdate();
	}
	
	private void runSortSubMenu(int option) {
		if(option == SORT_CODE)
			sortByStudentCode();
		else if(option == SORT_NAME)
			sortByStudentName();
		else if(option == SORT_SCORE)
			sortByStudentScore();
	}
	
	private void runFileSubMenu(int option) {
		if(option == FILE_SAVE)
			saveData();
		else if(option == FILE_LOAD)
			loadData();
	}
	
	private int option() {
		return inputNumber("");
	}

	private void joinStudent() {
		int code = createRandomStudentCode();
		String name = inputString("이름");
		
		Student student = new Student(name,code);
		group.add(student);
		System.out.println("학생 등록 완료");
	}
	
	private int createRandomStudentCode() {
		int code = 0;
		Random ran = new Random();
		
		while(true) {
			code = ran.nextInt(9000) + 1000;
			
			boolean isDupl = false;
//			for(int i=0; i<group.size(); i++) {
//				Student student = group.get(i);
			// 향상된 for 문 -> 위 두줄과 같음
			for(Student student : group) {	// group 안에 있는 것을 student 에 담아줘~
				if(student.getCode() == code)
					isDupl = true;
			}	
			if(!isDupl)
				break;
		}
		return code;
	}
	
	private void leaveStudent() {
		int code = inputNumber("제적할 학번");
		
		Student student = searchStudent(code);		// 찾을 용도 파라미터로 전달받아서 수행하게끔
		
		group.remove(student);
		System.out.println("학생 제적 완료");
	}
	
	private Student searchStudent(int code) {
		Student student = null;
		
		for(Student target : group) {
			if(target.getCode() == code)
				student = target; 
		}
		return student;
	}
	
	private void searchStudent() {
		int code = inputNumber("제적할 학번");
		
		Student student = searchStudent(code);
		System.out.println(student);
	}
	
	private int createRandomSubjectCode() {
		int code = 0;
		Random ran = new Random();
		
		while(true) {
			code = ran.nextInt(9000) + 1000;
			
			boolean isDupl = false;
//			for(int i=0; i<group.size(); i++) {
//				Student student = group.get(i);
			// 향상된 for 문 -> 위 두줄과 같음
			for(Subject subject : subjects) {	// group 안에 있는 것을 student 에 담아줘~
				
				if(subject.getCode() == code)
					isDupl = true;
			}	
			if(!isDupl)
				break;
		}
		return code;
	}
	
	private void enrollSubject() {
		int code = createRandomSubjectCode();
		String title = inputString("title");
		
		Subject subject = new Subject(code,title);
		subjects.add(subject);
		System.out.println("신규과목 등록 완료");
	}
	
	private void selectSubject() {
		int code = inputNumber("학번");
		Student student = searchStudent(code);
		
		if(student == null) {
			System.err.println("학번 정보를 다시 확인하세요.");
			return;
		}
		
		printSubjectAll();
		int idx = inputNumber("선택")-1;	//	인덱스로 처리하기 위해서
		
		Subject subject = subjects.get(idx);
		int subjectCode = subject.getCode();
		
		if(student.hasSubject(subjectCode)) {
			System.out.println("이미 수강중인 과목입니다.");
			return;
		}
		
		student.addSubject(subject.clone());
		System.out.println("수강 신청 완료");
		
	}
	
	private void printSubjectAll() {
		for(int i=0; i<subjects.size(); i++) {
			Subject subject = subjects.get(i);
			System.out.printf("%d) %s\n",i+1,subjects.get(i));
		}
	}
	
	private void cancelSubject() {
		int code = inputNumber("학번");
		Student student = searchStudent(code);
		if(student == null) {
			System.err.println("학번 정보를 다시 확인하세요.");
			return;
		}
		student.printSubjectAll();
		int idx = inputNumber("선택")-1;
		
		student.removeSubject(idx);
		System.out.println("수강 철회 완료");
		
	}
	
	private void scoreUpdate() {
		
		int code = inputNumber("학번");
		Student student = searchStudent(code);
		
		if(student == null) {
			System.err.println("학번 정보를 다시 확인하세요.");
			return;
		}
		
		student.printSubjectAll();
		int idx = inputNumber("선택")-1;
		int score = inputNumber("성적");
		
		Subject subject = student.getSubject(idx);
		subject.setScore(score);
		
		student.setSubject(idx, subject);		// 	수정
		System.out.println("성적 수정 완료");
		
	}
	
	private void sortByStudentCode() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int first = i;
			
			for(int j=i; j<group.size(); j++) {
				Student target = group.get(i);
				
				if(student.getCode() > target.getCode()) {
					student = target;
					first = j;
				}
			}
			if(first != i) {		// 	요거 설명 다시
				group.set(first, group.get(i));
				group.set(i, student);
			}
		}
	}
	
	private void sortByStudentName() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int first = i;
			
			for(int j=i; j<group.size(); j++) {
				Student target = group.get(i);
				
				if(student.getName().compareTo(target.getName()) > 0) {
					student = target;
					first = j;
				}
			}
			if(first != i) {		// 	요거 설명 다시
				group.set(first, group.get(i));
				group.set(i, student);
			}
		}
	}
	
	private void sortByStudentScore() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int first = i;
			
			for(int j=i; j<group.size(); j++) {
				Student target = group.get(i);
				
				if(student.getScoreAverage() < target.getScoreAverage()) {
					student = target;
					first = j;
				}
			}
			if(first != i) {		// 	요거 설명 다시
				group.set(first, group.get(i));
				group.set(i, student);
			}
		}
	}
	
	private void saveData() {
		
		// 포멧 일단 정하기
		// 과목코드1,과목명1/과목코드2,과목명2/과목코드3,과목명3...
		// 학번1/이름1
		// 학번2/이름2/과목코드1,성적1
		// 학번3/이름3/과목코드1,성적1/과목코드2,성적2
		
		String data = createDataString();
		
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(data);
			fileWriter.close();
			System.out.println("파일저장 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("파일저장 실패");
		}
	}
	
	private String createDataString() {
		
		// subject 정보
		String data = "";
		if(subjects.size() > 0) {
			for(Subject subject : subjects) {
				data += subject.getCode() + "," + subject.getTitle();
				data += "/";
			}
			data = data.substring(0,data.length()-1);
		}
		
		// group 정보
		for(Student student : group) {
			data += "\n" + student.getCode() + "/" + student.getName();
			
			for(int j=0; j<student.getSubjectsSize(); j++) {
				Subject subject = student.getSubject(j);
				
				data += "/" + subject.getCode() + "," + subject.getScore();
			}
		}
		
		return data;
	}
	
	private void loadData() {
		if(file.exists()) {
			String data = "";
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				
				while(bufferedReader.ready()) {
					data += bufferedReader.readLine() + "\n";
				}
				
				bufferedReader.close();
				fileReader.close();
				parseLoadedData(data);
				System.out.println("파일 로드 완료");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("파일 로드 실패");
			}
			
		}
	}
	
	private void parseLoadedData(String data) {
		
		this.group.clear();
		this.subjects.clear();
		
		String[] lines = data.split("\n");
		
		// subject
		String[] subjects = lines[0].split("/");
		for(int i=0; i<subjects.length; i++) {
			String[] info = subjects[i].split(",");
			
			int code = Integer.parseInt(info[0]);
			String title = info[1];
			
			Subject subject = new Subject(code,title);
			this.subjects.add(subject);
		}
		
		// group
		for(int i=0; i<lines.length; i++) {
			String[] info = lines[i].split("/");
			
			int code = Integer.parseInt(info[0]);
			String name = info[1];
			
			Student student = new Student(name,code);
			
			for(int j=2; j<info.length; j++) {
				String[] subInfo = info[j].split(",");
				
				int subCode = Integer.parseInt(subInfo[0]);
				int subSocre = Integer.parseInt(subInfo[1]);
				
				Subject subject = searchSubject(subCode);
				
				if(subject != null) {
					subject.setScore(subSocre);
					student.addSubject(subject.clone());
				}
			}
			this.group.add(student);
		}
	}
	
	private Subject searchSubject(int code) {
		for(Subject subject : subjects) {
			if(subject.getCode() == code)
				return subject;
		}
		return null;
	}
	
}

public class Ex07 {

	public static void main(String[] args) {
		
		Manager system = new Manager();
		system.run();

	}

}
