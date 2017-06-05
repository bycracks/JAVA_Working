package term_project2;

import java.text.SimpleDateFormat;
import java.util.*;

//������
class devTeam extends Team{
	private static final String[] jobList = {"SW_Developer","SW_Tester"};

	devTeam(Worker m, Worker w) {
		super(m, w);
		if (!w.job.equals(jobList[0]) || !w.job.equals(jobList[1])) {
			System.out.println("SW Developer �Ǵ� SW_Tester �� �ƴմϴ�!");
			super.members.remove(1);
		}
	}
}
// ����������
class subTeam extends Team{
	private static final String jobList = "Staff";
	
	subTeam(Worker m, Worker w) {
		super(m, w);
		
		if (!w.job.equals(jobList)) {
			System.out.println("Staff �� �ƴմϴ�!");
			members.remove(members.size());
		}
	}
}

public class Kyonggi_Company {
	static Scanner sc = new Scanner(System.in);
	Hashtable<String, Team> teamTable;
	String[] teamName = {"�񼭽�","�ѹ���","�λ���","����1��","����2��","����3��"};
	
	
	Kyonggi_Company() {
		teamTable = new Hashtable<String, Team>();
		teamTable.put("�񼭽�", new Team());
		teamTable.put("�ѹ���", new Team());
		teamTable.put("�λ���", new Team());
		teamTable.put("����1��", new Team());
		teamTable.put("����2��", new Team());
		teamTable.put("����3��", new Team());
	}
	static boolean mainMenu() {
		sc.reset();
		
		System.out.println("1.�ű� ���� �߰�");
		System.out.println("2.���� ���� ���� �� ����");
		System.out.println("3.���� �˻�");
		System.out.println("4.�����丮 Ȯ��");
		System.out.println("5.RollBack");
		System.out.println("6.����");
		
		switch(sc.nextInt()) {
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: break;
		case 6: return false;
		default: System.out.println("Input Error!!");
		}
		
		return true;
	}
	void addWorker() {
		sc.reset();
		
		System.out.println("�̸�: ");
		
		
		
	}
	
	void searchMenu(ArrayList<Team> teams) {		
		System.out.println(" 1.�̸����� �˻�");
		System.out.println(" 2.�μ������� �˻�");
		System.out.println(" 3.Manager�� �˻�");
		
		switch(sc.nextInt()) {
		case 1: 
			System.out.print("  �̸��Է�: ");
			search(teams, sc.nextLine(), -1);
			break;
		case 2: 
			System.out.print("(�񼭽�:0, �ѹ���:1, �λ���:2, ����1��:3, ����2��:4, ����3��:5)\n��: ");
			search(teams, null, sc.nextInt());
			break;
		case 3: 
			System.out.println("  �Ŵ��� �̸� �Է�: ");
			search(teams, sc.nextLine(), -2);
			break;
		default: System.out.println("Input Error!");
		}
	}
	
	
	Worker search(ArrayList<Team> teams, String input, int teamNum) {
		Worker w = null;
		
		if (teamNum == -1) {  // �̸� �˻�
			for (int i=0; i<6; i++)
				for (int j=0; j< (teams.get(i)).members.size(); j++)
					if ( (teams.get(i).members.get(j).name.equals(input)) ) {
						
						w = (teams.get(i)).members.get(j);
						
						System.out.println("  ��: "+teamName[w.teamNum]+" �̸�: "+w.name+" ����: "+w.job+" ID: "+w.ID);
					}
					
		} else if (teamNum == -2) {  // �Ŵ��� �̸� �Է�
			;
			
		} else {
			for (int i=0; i<teams.get(teamNum).members.size(); i++) {
				w = (teams.get(teamNum)).members.get(i);
				System.out.println("  ��: "+teamName[w.teamNum]+" �̸�: "+w.name+" ����: "+w.job+" ID: "+w.ID);
			}
		}
		return w;
		
	}

	public static void main (String[] args) {
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		//String str = dayTime.format(new Date(time));
		
		while(mainMenu());
		
		
		
	}
}
