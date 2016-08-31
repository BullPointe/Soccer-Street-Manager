import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class League 
{
	private ArrayList <Team> Teams= new ArrayList<Team>();
	public ArrayList <Team> LeagueTable = new ArrayList<Team>();
	private Random gen1 = new Random();
	public ArrayList <Team[][]> Weeks = new ArrayList<Team[][]>();
	public Schedule YearSchedule[] = new Schedule[10];
	
	
	public League() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void addTeams(Team Team)
	{
		Teams.add(Team);
		for(int i=0;i<=6;i++)
		{
			Team TempTeam = new Team();
			TempTeam.createTeam();
			Teams.add(TempTeam);
			System.out.println(Teams);
		}
	}
	
	
	public ArrayList getTeams()
	{
		return Teams;
	}
	
	public void setLeagueTable()
	{
		ArrayList <Team> TempTeams = new ArrayList<Team>();
		
		
		for(int k =0; k< Teams.size();k++)
		{
			Team StartingTeam = new Team();
			StartingTeam = Teams.get(k);
		
		if(TempTeams.size() != 0)
		{
			for(int g=0; g<TempTeams.size();g++)
			{
				Team CheckingTeam = new Team();
				CheckingTeam =TempTeams.get(g);
				
				if(StartingTeam.getPoints()>=CheckingTeam.getPoints())
				{
					TempTeams.add(g,StartingTeam);
					break;
				}
				else if(g==TempTeams.size()-1)
				{
					TempTeams.add(StartingTeam);
				}
				
			}
				
		}//END IF STATEMENT 
		else
		{
			TempTeams.add(StartingTeam);
		}
		}//END OUTER LOOP
		
		LeagueTable = TempTeams;		
	}//END CLASS SETLEAGUETABLE
	
	public ArrayList getLeagueTable()
	{
		return LeagueTable;
	}
	
	private Schedule createEachWeekSchedule()
	{
		Schedule EachWeekSchedule = new Schedule(Teams);
		boolean[] UsedTeam = new boolean[8];
		
		for(int i=0;i<4; i++ )
		{
			
			int GeneratedNumber1;
			int GeneratedNumber2;
			
			do
			{
				
				GeneratedNumber1 = gen1.nextInt(8);
				System.out.println(GeneratedNumber1);
				GeneratedNumber2 = gen1.nextInt(8);
				System.out.println(GeneratedNumber2);
				
			
			}while((UsedTeam[GeneratedNumber1]==true||UsedTeam[GeneratedNumber2]==true));
			if(UsedTeam[GeneratedNumber1]==false&UsedTeam[GeneratedNumber2]==false)
			{
					UsedTeam[GeneratedNumber1]=true;
					UsedTeam[GeneratedNumber2]=true;
					EachWeekSchedule.setMatchUp(Teams.get(GeneratedNumber1), Teams.get(GeneratedNumber2), i);
			}
			
		}
		return EachWeekSchedule;
		
		
	}//END CREATE SCHEDULE 
	
	public void CreateGrandSchedule()
	{
		
		for(int i=0;i<10;i++)
		{
			YearSchedule[i]=createEachWeekSchedule();
		}
		System.out.println(Teams.size());
		System.out.println(Teams.size()/2);
		
	}
	
	public Schedule[] getGrandSchedule()
	{
		return YearSchedule;
	}

	public void setTeams(ArrayList tempTeams) 
	{
		Teams = tempTeams;
		
	}
}
