package term_project2;

import java.util.*;

public class Worker {
	int teamNum;
	String job;
	String name;
	String ID;
	
	
	// ºñ¼­½Ç:0, ÃÑ¹«ÆÀ:1, ÀÎ»çÆÀ:2, °³¹ß1ÆÀ:3, °³¹ß2ÆÀ:4, °³¹ß3ÆÀ:5
	Worker(int tn) {
		Scanner sc = new Scanner(System.in);
		teamNum = tn;
		
		if (teamNum/3 == 0) {
			System.out.print("job: (0)"+subTeam.jobList[0]);
			System.out.println(" (1)"+subTeam.jobList[1]);
			
			switch(sc.nextInt()) {
			case 0: job = subTeam.jobList[0]; break;
			case 1: job = subTeam.jobList[1]; break;
			default: System.out.println("Input Error!!"); return;
			}
		}
		else {
			System.out.print("job: (0)"+devTeam.jobList[0]);
			System.out.print(" (1)"+devTeam.jobList[1]);
			System.out.println(" (2)"+devTeam.jobList[2]);
			
			switch(sc.nextInt()) {
			case 0: job = devTeam.jobList[0]; break;
			case 1: job = devTeam.jobList[1]; break;
			case 2: job = devTeam.jobList[2]; break;
			default: System.out.println("Input Error!!"); return;
			}
		}
		sc.nextLine();
		
		System.out.print("ÀÌ¸§: "); 
		name = sc.next();
		sc.nextLine();
		
		System.out.print("Á÷¿øID: ");
		ID = sc.next();
		sc.nextLine();
	}
	Worker(int tn, String j, String n, String id) {
		teamNum = tn;
		job = j;
		name = n;
		ID = id;
	}
}