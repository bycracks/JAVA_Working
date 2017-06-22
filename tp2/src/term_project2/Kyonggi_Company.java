package term_project2;

import java.text.SimpleDateFormat;
import java.util.*;

public class Kyonggi_Company {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Team> teamTable;
	String[] teamName = {"�񼭽�","�ѹ���","�λ���","����1��","����2��","����3��"};
	
	
	Kyonggi_Company() {
		teamTable = new ArrayList<Team>();
		teamTable.add( new subTeam(new Worker(0,subTeam.jobList[0],"��Ŵ�","1701"), new Worker(0,subTeam.jobList[1],"�轺��","1702")) );
		teamTable.add( new subTeam(new Worker(1,subTeam.jobList[0],"�̸Ŵ�","1711"), new Worker(1,subTeam.jobList[1],"�̽���","1712")) );
		teamTable.add( new subTeam(new Worker(2,subTeam.jobList[0],"�ȸŴ�","1721"), new Worker(2,subTeam.jobList[1],"�Ƚ���","1722")) );
		teamTable.add( new devTeam(new Worker(3,devTeam.jobList[0],"���Ŵ�","1731"), new Worker(3,devTeam.jobList[1],"������","1732")) );
		teamTable.add( new devTeam(new Worker(4,devTeam.jobList[0],"�ϸŴ�","1741"), new Worker(4,devTeam.jobList[1],"�ϰ���","1742")) );
		teamTable.add( new devTeam(new Worker(5,devTeam.jobList[0],"�ӸŴ�","1751"), new Worker(5,devTeam.jobList[1],"�Ӱ���","1752")) );
	}
	static boolean mainMenu(Kyonggi_Company kc) {
		sc.reset();
		
		System.out.println("1.�ű� ���� �߰�");
		System.out.println("2.���� ���� ���� �� ����");
		System.out.println("3.���� �˻�");
		System.out.println("4.�����丮 Ȯ��");
		System.out.println("5.RollBack");
		System.out.println("6.����");
		System.out.print("�Է�: ");
		
		switch(Integer.parseInt(sc.nextLine())) {
		case 1: kc.addWorker(kc.teamTable);		break;
		case 2: kc.editWorker(kc); 				break;
		case 3: kc.searchMenu(kc.teamTable);	break;
		case 4: break;
		case 5: break;
		case 6: return false;
		default: System.out.println("Input Error!!");
		}
		
		return true;
	}
	void addWorker(ArrayList<Team> teams) {
		System.out.print(" (�񼭽�:0, �ѹ���:1, �λ���:2, ����1��:3, ����2��:4, ����3��:5)\n��: ");
		int tn = sc.nextInt();
		sc.nextLine();
		
		(teams.get(tn)).members.add(new Worker(tn));
	}
	void editWorker(Kyonggi_Company kc) {
		Worker w = null;
		System.out.print( "�̸� or ����ID �Է�");
		ArrayList<Worker> tmp = search(kc.teamTable, sc.next(), -1);
		
		System.out.print(" ����: ");
		w = tmp.get(sc.nextInt()-1);
		sc.nextLine();
		
		System.out.println(" 1)����  2)����");
		switch (sc.nextInt()) {
		case 1:		
			System.out.print("\n �̸�: ");
			w.name = sc.next();
			sc.nextLine();
			
			System.out.print(" (�񼭽�:0, �ѹ���:1, �λ���:2, ����1��:3, ����2��:4, ����3��:5)\n��: ");
			w.teamNum = sc.nextInt();
			sc.nextLine();
			
			System.out.print(" job: ");
			if (w.teamNum/3 == 0) {
				System.out.print("job: (0)"+subTeam.jobList[0]);
				System.out.println(" (1)"+subTeam.jobList[1]);
				
				switch(sc.nextInt()) {
				case 0: w.job = subTeam.jobList[0]; break;
				case 1: w.job = subTeam.jobList[1]; break;
				default: System.out.println("Input Error!!"); return;
				}
			}	
			else {
				System.out.print("job: (0)"+devTeam.jobList[0]);
				System.out.print(" (1)"+devTeam.jobList[1]);
				System.out.println(" (2)"+devTeam.jobList[2]);
			
				switch(sc.nextInt()) {
				case 0: w.job = devTeam.jobList[0]; break;
				case 1: w.job = devTeam.jobList[1]; break;
				case 2: w.job = devTeam.jobList[2]; break;
				default: System.out.println("Input Error!!"); return;
				}
			}
			break;
		case 2: 
			for (int i=0; i<6; i++) {
				if (w.job.equals("Manager"))
					w = null;
				else
					kc.teamTable.get(i).members.remove(w);
			}
		
		default: System.out.println("Input Error!!");
		}
		sc.nextLine();
		
		System.out.print("�̸�: "); 
		w.name = sc.nextLine();
		
		System.out.print("����ID: ");
		w.ID = sc.nextLine();
		
		
	}
	
	void searchMenu(ArrayList<Team> teams) {		
		System.out.println(" 1) �̸����� �˻�");
		System.out.println(" 2) �μ������� �˻�");
		System.out.print(" 3) Manager�� �˻�   ");
		
		switch(sc.nextInt()) {
		case 1: 
			System.out.print("  �̸� or ID �Է�: ");
			search(teams, sc.next(), -1);
			sc.nextLine();
			break;
		case 2: 
			System.out.print("  (�񼭽�:0, �ѹ���:1, �λ���:2, ����1��:3, ����2��:4, ����3��:5) ");
			search(teams, null, sc.nextInt());
			sc.nextLine();
			break;
		case 3: 
			System.out.print("  �Ŵ��� �� �Է�: ");
			search(teams, sc.next(), -2);
			sc.nextLine();
			break;
		default: System.out.println("Input Error!");
		}
	}
	
	
	ArrayList<Worker> search(ArrayList<Team> teams, String input, int teamNum) {
		ArrayList<Worker> tmp = new ArrayList<Worker>();
		Worker w = null;
		
		if (teamNum == -1) { // �̸� �� ID�� �˻�
			for (int i=0; i<6; i++)
				for (int j=0; j< (teams.get(i)).members.size(); j++)
					if ( teams.get(i).members.get(j).name.equals(input)
							|| teams.get(i).members.get(j).ID.equals(input) ) {
						w = (teams.get(i)).members.get(j);
						tmp.add(w);
						
						System.out.println("  "+tmp.size()+") ��:"+teamName[w.teamNum]+", �̸�:"+w.name+", ����:"+w.job+", ID:"+w.ID);
					}
					
		}else if (teamNum == -2){ // �Ŵ��� ������ �˻�
			for (int i=0; i<6; i++) {
				if ( teams.get(i).manager.name.equals(input) )
					for (int j=0; j< (teams.get(i)).members.size(); j++) {
						w = (teams.get(i)).members.get(j);
						tmp.add(w);
					
						System.out.println("  "+tmp.size()+") ��:"+teamName[w.teamNum]+", �̸�:"+w.name+", ����:"+w.job+", ID:"+w.ID);
					}
			}
					
		}else if (0 <= teamNum && teamNum <= 5){ // �μ��� �˻�
			System.out.println("  ��:"+teamName[teamNum]+", �̸�:"+teams.get(teamNum).manager.name+", ����:"+teams.get(teamNum).manager.job+", ID:"+teams.get(teamNum).manager.ID);
			for (int i=0; i<teams.get(teamNum).members.size(); i++) {
				w = (teams.get(teamNum)).members.get(i);
				tmp.add(w);
				System.out.println("  "+tmp.size()+")�̸�:"+w.name+", ����:"+w.job+", ID:"+w.ID);
			}
		}
		else {
			System.out.println("Input Error!!");
			return null;
		}
		
		if (tmp.isEmpty()) System.out.println("  ����� �����ϴ�.");
		
		return tmp;
		
	}

	public static void main (String[] args) {
		/*
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		//String str = dayTime.format(new Date(time));
		 */
		Kyonggi_Company kc = new Kyonggi_Company();
		
		while(mainMenu(kc));
		
	}
}
