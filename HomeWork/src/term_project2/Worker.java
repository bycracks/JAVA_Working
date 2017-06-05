package term_project2;

import java.util.*;

public class Worker {
	int teamNum;
	String job;
	String name;
	String ID;
	
	
	// ºñ¼­½Ç:0, ÃÑ¹«ÆÀ:1, ÀÎ»çÆÀ:2, °³¹ß1ÆÀ:3, °³¹ß2ÆÀ:4, °³¹ß3ÆÀ:5
	Worker() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("(ºñ¼­½Ç:0, ÃÑ¹«ÆÀ:1, ÀÎ»çÆÀ:2, °³¹ß1ÆÀ:3, °³¹ß2ÆÀ:4, °³¹ß3ÆÀ:5)\nÆÀ: ");
		teamNum = sc.nextInt();
		sc.nextLine();
		
		if (teamNum/3 == 0) {
			System.out.println("Á÷¾÷: STAFF");
		}
		else {
			System.out.println("JobList: SW_Developer(0), SW_Tester(1) ? ");
			System.out.print("Á÷¾÷: ");
			
			switch(sc.nextInt()) {
			case 0: System.out.println("SW_Developer");		break;
			case 1: System.out.println("SW_Tester");		break;
			default: System.out.println("Input Error!!");	break;
			}
		}
		
		System.out.print("ÀÌ¸§: ");
		name = sc.nextLine();
		
		System.out.print("Á÷¿øID: ");
		ID = sc.nextLine();
	}	
}