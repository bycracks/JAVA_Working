package Term_Project1;
import java.util.Scanner;

class Friend {  // ����ó ����
	String name;
	int age;
	String phoneNumber;
	
	public void input() {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("�̸�: ");
		name=sc.nextLine();
		
		System.out.print("����: ");
		age=sc.nextInt();
		sc.nextLine();
		
		System.out.print("��ȭ��ȣ: ");
		phoneNumber=sc.nextLine();
	}
}

public class PhoneBook {  // ����ó å�� ������ �� ���� �ִ�.
	Friend[] db;
	int total;
	
	PhoneBook() {
		db = new Friend[30];
		total = 0;
	}
	static void printMenu() {
		System.out.println("### ģ�� ��� ���� ###");
		System.out.println("1. ����ó ���");
		System.out.println("2. ����ó ���");
		System.out.println("3. ����ó ����");
		System.out.println("4. ������");
		System.out.print("����: ");
	}
	void addNumber() {  // ��ȭ��ȣ �Է�
		Friend f = new Friend();
		f.input();
		
		db[total++] = f;
	}
	void deleteNumber() {  // ��ȭ��ȣ ����
		Scanner sc = new Scanner(System.in);
		int input;
		
		System.out.print("������ ��: ");
		input = sc.nextInt();
		sc.nextLine();
		
		for (int i=input; i<total; i++)
			db[i-1] = db[i];
		--total;
	}
	void printAll() {  // �� ����ó ���
		for (int i=0; i<total; i++)
			System.out.println((i+1)+". "+db[i].name+" "+db[i].age+"�� "+db[i].phoneNumber);
			
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
