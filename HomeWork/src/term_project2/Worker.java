package term_project2;

import java.util.*;

public class Worker {
	int teamNum;
	String job;
	String name;
	String ID;
	
	
	// �񼭽�:0, �ѹ���:1, �λ���:2, ����1��:3, ����2��:4, ����3��:5
	Worker() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("(�񼭽�:0, �ѹ���:1, �λ���:2, ����1��:3, ����2��:4, ����3��:5)\n��: ");
		teamNum = sc.nextInt();
		sc.nextLine();
		
		if (teamNum/3 == 0) {
			System.out.println("����: STAFF");
		}
		else {
			System.out.println("JobList: SW_Developer(0), SW_Tester(1) ? ");
			System.out.print("����: ");
			
			switch(sc.nextInt()) {
			case 0: System.out.println("SW_Developer");		break;
			case 1: System.out.println("SW_Tester");		break;
			default: System.out.println("Input Error!!");	break;
			}
		}
		
		System.out.print("�̸�: ");
		name = sc.nextLine();
		
		System.out.print("����ID: ");
		ID = sc.nextLine();
	}	
}