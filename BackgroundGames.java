import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class BackgroundGames {

	private Team  Team1= new Team();
	private Team  Team2= new Team();
	private int[] score = new int[2];
	private int[] tempScore = new int[2];
	
	
	private ArrayList timeScored= new ArrayList();
	private ArrayList timeScored2= new ArrayList();
	
	private Player tempPlayer = new Player();
	
	private JLabel TeamName1, TeamName2, ScoreJLabel,Time;
	private JTextArea Team1Players, Team2Players,WhoScored;
	private Timer clockTimer;

	private Integer ClockTime;
	private int TotalGoals;
	
	public BackgroundGames(Team uno, Team dos) 
	{
		Team1=uno;
		Team2=dos;
	}

	public Player[] getTeam1Players()
	{
		ArrayList TempPlayers = Team1.getPlayers();
		Player[]  players = new Player[TempPlayers.size()];
		
		for(int k=0;k<TempPlayers.size();k++)
		{
			players[k]=(Player) TempPlayers.get(k);
		}
		
		return players;
	}
		
	public Player[] getTeam2Players()
	{
		ArrayList TempPlayers = Team2.getPlayers();
		Player[]  players = new Player[TempPlayers.size()];
		
		for(int k=0;k<TempPlayers.size();k++)
		{
			players[k]=(Player) TempPlayers.get(k);
		}
		return players;
	}
	
	
	public int[] getScore()
	{
		return score;
	}
	
	private void setScore(int teamscored,int scored)
	{
		score[teamscored-1]+=scored;
	}
	
	private void setPlayerScored(int TeamNumber,int PlayerNumber)
	{
		Player[] tempPlayers = new Player[4];
		if(TeamNumber == 1)	
		{
			tempPlayers = getTeam1Players();
			tempPlayers[PlayerNumber].setGoals(1);//TO CHNAGE THE VALUE OF GOALS IN EACH PLAYER
			setPlayerScored(tempPlayers[PlayerNumber]);//WHEN OTHER CLASSES REQUEST TO GET THE MOST RECENT GOAL SCORER
			
		}
		else if(TeamNumber == 2)	
		{
			tempPlayers = getTeam2Players();
			tempPlayers[PlayerNumber].setGoals(1);
			setPlayerScored(tempPlayers[PlayerNumber]);
		}
	}
	
	
	public void runGame()
	{
		int team1Rating = Team1.getTeamRating();
		int team2Rating = Team2.getTeamRating();
		int team1score=0;
		int team2score=0;
		
		Random gen1 = new Random();
		
		
		if(gen1.nextInt(4)==2)
		{
			if(team1Rating < team2Rating)
			{
				do
				{	
				 team1score= gen1.nextInt(4);
				 team2score= gen1.nextInt(4);	
				}while(team1score > team2score);
			}
		}
		
		else if(team1Rating > team2Rating )
		{
			do
			{	
			 team1score= gen1.nextInt(4);
			 team2score= gen1.nextInt(4);	
			}while(team1score > team2score);
		}	
		else if(team1Rating < team2Rating)
		{
			do
			{	
			 team1score= gen1.nextInt(4);
			 team2score= gen1.nextInt(4);	
			}while(team1score < team2score);
		}
		
			int x=0;
			do
			{
				timeScored.add(gen1.nextInt(90));
				setPlayerScored(1,gen1.nextInt(4));
				x++;	
			}while(x<=team1score);
		
			int k=0;
			do
			{
				timeScored2.add(gen1.nextInt(90));
				setPlayerScored(2,gen1.nextInt(4));
				k++;
			}while(k<=team2score);
			
			setScore(1,team1score);
			setScore(2,team2score);
		
			EndGameProcedure();

			
			
	}
	
	private void EndGameProcedure() 
	{
		if(score[0]>score[1])
		{
			Team1.setPoints(3);
		}
		else if(score[1]>score[0])
		{
			Team2.setPoints(3);
		}
		else if(score[0]==score[1])
		{
			Team1.setPoints(1);
			Team2.setPoints(1);
		}
		Team1.setGamesPlayed(Team1.getTeamName()+ score[0]+ "-" + score[1]+Team2.getTeamName() );
		Team2.setGamesPlayed(Team2.getTeamName()+ score[1]+ "-" + score[0]+Team2.getTeamName() );
		
	}

	public ArrayList Team1TimeScored()
	{
		return  timeScored;
	}
	
	public ArrayList Team2TimeScored()
	{
		return  timeScored2;
	}
	
	public Player getPlayerScored()
	{
		return tempPlayer;
	}
	
	public void setPlayerScored(Player tempsPlayer)
	{
		tempPlayer = tempsPlayer;
	}

	
	public Team[] returnTeamsPlayed()
	{
		Team[] sendArray = new Team[2];
		sendArray[0] = Team1;
		sendArray[1] = Team2;
		
		return sendArray;
	}
		
		
		
		
		
		
		
		
		
	
		
		
	}
	

