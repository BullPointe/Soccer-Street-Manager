import java.util.ArrayList;

public class Schedule
{
	
	
	private ArrayList <Team>Teams = new ArrayList<Team>();
	int k = Teams.size()/2;
	private Team[][] EachWeek = new Team[2][4];
	
	
	public Schedule(ArrayList Team) 
	{
		Teams = Team;
	}
	
	public void setMatchUp(Team Team1, Team Team2, int Matchup)
	{
		EachWeek[0][Matchup]= Team1;
		EachWeek[1][Matchup]= Team2;
	
	}
	public Team[][] getSchedule()
	{
		return EachWeek;
	}
	
	
	
	

}
