package Term_Project1;
import java.util.Scanner;

class Friend {  // 연락처 형식
	String name;
	int age;
	String phoneNumber;
	
	public void input() {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("이름: ");
		name=sc.nextLine();
		
		System.out.print("나이: ");
		age=sc.nextInt();
		sc.nextLine();
		
		System.out.print("전화번호: ");
		phoneNumber=sc.nextLine();
	}
}

public class PhoneBook {  // 연락처 책이 여러개 일 수도 있다.
	Friend[] db;
	int total;
	
	PhoneBook() {
		db = new Friend[30];
		total = 0;
	}
	static void printMenu() {
		System.out.println("### 친구 목록 관리 ###");
		System.out.println("1. 연락처 출력");
		System.out.println("2. 연락처 등록");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 끝내기");
		System.out.print("선택: ");
	}
	void addNumber() {  // 전화번호 입력
		Friend f = new Friend();
		f.input();
		
		db[total++] = f;
	}
	void deleteNumber() {  // 전화번호 삭제
		Scanner sc = new Scanner(System.in);
		int input;
		
		System.out.print("삭제할 행: ");
		input = sc.nextInt();
		sc.nextLine();
		
		for (int i=input; i<total; i++)
			db[i-1] = db[i];
		--total;
	}
	void printAll() {  // 총 연락처 출력
		for (int i=0; i<total; i++)
			System.out.println((i+1)+". "+db[i].name+" "+db[i].age+"세 "+db[i].phoneNumber);
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PhoneBook pb = new PhoneBook();
		int input=0;
	
		while (input != 4) {
			printMenu();
			sc.reset();
			input = sc.nextInt();
			
			switch(input) {
			case 1: pb.printAll();			break;
			case 2: pb.addNumber();			break;
			case 3: pb.deleteNumber(); 		break;
			case 4:							break;
			default:System.out.println("Input Error!!");
			}
		}		
	}	
	
}
