package term_project2;

import java.util.*;

public class Team {
	protected Worker manager;
	protected ArrayList<Worker> members;
	
	Team(Worker m, Worker w) {
		members = new ArrayList<Worker>();
		
		// Manager �ڸ��� ����� ���� ����
		if (m.job.equals("Manager")) manager = m;
		else System.out.println("Member is not Manager");
		
		// Manager�� member�� ���� ����
		if (w.job.equals("Manager")) System.out.println("Manager is not Member");
		else members.add(w);
	}
	
}
//������
class devTeam extends Team{
	static final String[] jobList = {"Manager", "SW_Developer","SW_Tester"};

	devTeam(Worker m, Worker w) {
		super(m, w);
		if (!w.job.equals(jobList[1]) && !w.job.equals(jobList[2])) {
			System.out.println("SW_Developer �Ǵ� SW_Tester �� �ƴմϴ�!");
			super.members.remove(0);
		}
	}
}
//����������
class subTeam extends Team{
	static final String[] jobList = {"Manager", "Staff"};
	
	subTeam(Worker m, Worker w) {
		super(m, w);
		
		if (!w.job.equals(jobList[1])) {
			System.out.println("Staff �� �ƴմϴ�!");
			members.remove(members.size());
		}
	}
}
