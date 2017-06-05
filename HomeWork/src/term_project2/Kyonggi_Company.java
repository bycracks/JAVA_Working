package term_project2;

import java.text.SimpleDateFormat;
import java.util.*;

//개발팀
class devTeam extends Team{
	private static final String[] jobList = {"SW_Developer","SW_Tester"};

	devTeam(Worker m, Worker w) {
		super(m, w);
		if (!w.job.equals(jobList[0]) || !w.job.equals(jobList[1])) {
			System.out.println("SW Developer 또는 SW_Tester 가 아닙니다!");
			super.members.remove(1);
		}
	}
}
// 개발지원팀
class subTeam extends Team{
	private static final String jobList = "Staff";
	
	subTeam(Worker m, Worker w) {
		super(m, w);
		
		if (!w.job.equals(jobList)) {
			System.out.println("Staff 가 아닙니다!");
			members.remove(members.size());
		}
	}
}

public class Kyonggi_Company {
	static Scanner sc = new Scanner(System.in);
	Hashtable<String, Team> teamTable;
	String[] teamName = {"비서실","총무팀","인사팀","개발1팀","개발2팀","개발3팀"};
	
	
	Kyonggi_Company() {
		teamTable = new Hashtable<String, Team>();
		teamTable.put("비서실", new Team());
		teamTable.put("총무팀", new Team());
		teamTable.put("인사팀", new Team());
		teamTable.put("개발1팀", new Team());
		teamTable.put("개발2팀", new Team());
		teamTable.put("개발3팀", new Team());
	}
	static boolean mainMenu() {
		sc.reset();
		
		System.out.println("1.신규 직원 추가");
		System.out.println("2.기존 직원 수정 및 삭제");
		System.out.println("3.직원 검색");
		System.out.println("4.히스토리 확인");
		System.out.println("5.RollBack");
		System.out.println("6.종료");
		
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
		
		System.out.println("이름: ");
		
		
		
	}
	
	void searchMenu(ArrayList<Team> teams) {		
		System.out.println(" 1.이름으로 검색");
		System.out.println(" 2.부서명으로 검색");
		System.out.println(" 3.Manager로 검색");
		
		switch(sc.nextInt()) {
		case 1: 
			System.out.print("  이름입력: ");
			search(teams, sc.nextLine(), -1);
			break;
		case 2: 
			System.out.print("(비서실:0, 총무팀:1, 인사팀:2, 개발1팀:3, 개발2팀:4, 개발3팀:5)\n팀: ");
			search(teams, null, sc.nextInt());
			break;
		case 3: 
			System.out.println("  매니저 이름 입력: ");
			search(teams, sc.nextLine(), -2);
			break;
		default: System.out.println("Input Error!");
		}
	}
	
	
	Worker search(ArrayList<Team> teams, String input, int teamNum) {
		Worker w = null;
		
		if (teamNum == -1) {  // 이름 검색
			for (int i=0; i<6; i++)
				for (int j=0; j< (teams.get(i)).members.size(); j++)
					if ( (teams.get(i).members.get(j).name.equals(input)) ) {
						
						w = (teams.get(i)).members.get(j);
						
						System.out.println("  팀: "+teamName[w.teamNum]+" 이름: "+w.name+" 직업: "+w.job+" ID: "+w.ID);
					}
					
		} else if (teamNum == -2) {  // 매니저 이름 입력
			;
			
		} else {
			for (int i=0; i<teams.get(teamNum).members.size(); i++) {
				w = (teams.get(teamNum)).members.get(i);
				System.out.println("  팀: "+teamName[w.teamNum]+" 이름: "+w.name+" 직업: "+w.job+" ID: "+w.ID);
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
