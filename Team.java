import java.util.ArrayList;
import java.util.Random;

public class Team 
{
	public String TeamName;
	public int TeamRating=64;
	public int Points=0;
	private Random gen1 = new Random();
	
	private ArrayList <Player> Players = new ArrayList<Player>();
	public int gamesplayed=0;
	public int AvgGoals=0;
	private String GamesPlayed;
	
	private String[] CityNames = {"Manchester","Chicago","Liverpool","London","New Jersey","Shanghai","Paris","Mexico City","Madrid","Frankfurt","Los Angeles","Berlin","Pyongyang","Buenos Aires","Tokyo","San Diego","Clevland","North Carolina","Toronto","Quebec","Somerset","Camden","Seoul","Barcelona","Oklahoma City","Sacramento","Cairo","Indianapolis","Dubai","Torino"};
	private String[] Mascots = {"FC","AC","CF","SC"};
	
	public Team() 
	{
		
	}
	
	public void setTeamName(String name)
	{
		TeamName = name;
	}
	
	public String getTeamName()
	{
		return TeamName;
	}
	
	public void setTeamRating()
	{
		int tempRating=0;
		
		for(int i=0; i<Players.size(); i++)
		{
			Player tempPlayer = new Player();
			tempPlayer= Players.get(i);
			tempRating += tempPlayer.getRating();
		}
		
		TeamRating = tempRating / Players.size();
	}
	
	public int getTeamRating()
	{
		return TeamRating;
	}
	
	public void setPoints(int Point)
	{
		Points += Point;
	}
	
	public int getPoints()
	{
		return Points;
	}
	
	public void setAvgGoals()
	{
		int tempGoals=0;
		
		for(int i=0; i<Players.size(); i++)
		{
			Player tempPlayer = new Player();
			tempPlayer= Players.get(i);
			tempGoals += tempPlayer.getGoals();
		}
		
		TeamRating = tempGoals / Players.size();
	}
	
	public int getAvgGoals()
	{
		return AvgGoals;
	}
	
	public void createTeam()
	{
		for(int i=0; i<4; i++)
		{
			Player TempPlayer = new Player();
			TempPlayer.createPlayer(TeamRating);
			Players.add(TempPlayer);
		}
		setTeamRating();
		setTeamName(Mascots[gen1.nextInt(Mascots.length)]+" "+CityNames[gen1.nextInt(CityNames.length)]);
		System.out.println(TeamName);
	}
	
	public String getTopScorerName()
	{
		int top=0;
		String topper = "";
		
		for(int i=0; i<Players.size(); i++)
		{
			Player TempPlayer = new Player();
			
			TempPlayer = Players.get(i);
			
			if( TempPlayer.getGoals()> top)
			{
				topper = TempPlayer.getFirstName()+" "+TempPlayer.getLastName() +" : "+ TempPlayer.getGoals() + " goals";
				top=TempPlayer.getGoals();
			}
			
		}
		
		return topper;
	}
	
	public ArrayList getPlayers()
	{
		return Players;
	}
	
	public String getGamesPlayed()
	{
		return GamesPlayed;
	}
	
	public void setGamesPlayed(String addGame)
	{
		GamesPlayed+=addGame;
		
		
		
	}
	
	
}
