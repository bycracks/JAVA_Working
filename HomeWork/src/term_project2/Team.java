package term_project2;

import java.util.*;

public class Team {
	protected Worker manager;
	protected ArrayList<Worker> members;
	
	Team() {
		manager = new Worker();
		members = new ArrayList<Worker>();
	}
	
	Team(Worker m, Worker w) {
		manager = m;
		members.add(w);
		
		// Manager 자리에 멤버가 오면 에러
		if (m.job.equals("Manager")) manager = m;
		else System.out.println("Member is not Manager");
		
		// Manager가 member에 오면 에러
		if (w.job.equals("Manager")) System.out.println("Manager is not Member");
		else members.add(w);
	}
	
}