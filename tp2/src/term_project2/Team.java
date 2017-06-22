package term_project2;

import java.util.*;

public class Team {
	protected Worker manager;
	protected ArrayList<Worker> members;
	
	Team(Worker m, Worker w) {
		members = new ArrayList<Worker>();
		
		// Manager 자리에 멤버가 오면 에러
		if (m.job.equals("Manager")) manager = m;
		else System.out.println("Member is not Manager");
		
		// Manager가 member에 오면 에러
		if (w.job.equals("Manager")) System.out.println("Manager is not Member");
		else members.add(w);
	}
	
}
//개발팀
class devTeam extends Team{
	static final String[] jobList = {"Manager", "SW_Developer","SW_Tester"};

	devTeam(Worker m, Worker w) {
		super(m, w);
		if (!w.job.equals(jobList[1]) && !w.job.equals(jobList[2])) {
			System.out.println("SW_Developer 또는 SW_Tester 가 아닙니다!");
			super.members.remove(0);
		}
	}
}
//개발지원팀
class subTeam extends Team{
	static final String[] jobList = {"Manager", "Staff"};
	
	subTeam(Worker m, Worker w) {
		super(m, w);
		
		if (!w.job.equals(jobList[1])) {
			System.out.println("Staff 가 아닙니다!");
			members.remove(members.size());
		}
	}
}
