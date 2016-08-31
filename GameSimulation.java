import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class GameSimulation extends JFrame
{
	private Team  Team1= new Team();
	private Team  Team2= new Team();
	private int[] score = new int[2];
	private int[] tempScore = new int[2];
	private ArrayList scories1 = new ArrayList();
	private ArrayList scories2 = new ArrayList();
	private int whichPlayerScored1=0;
	private int whichPlayerScored2=0;
	
	
	private ArrayList timeScored= new ArrayList();
	private ArrayList timeScored2= new ArrayList();
	
	private Player tempPlayer = new Player();
	
	private JLabel TeamName1, TeamName2, ScoreJLabel,Time;
	private JTextArea Team1Players, Team2Players,WhoScored;
	private Timer clockTimer;

	private Integer ClockTime=0;
	private int TotalGoals;
	
	public GameSimulation(Team Teamuno, Team Teamdos) 
	{
		Team1= Teamuno;
		Team2= Teamdos;
		createUserInterFace();
		runVisuals();
	}
	
	private void createUserInterFace() 
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		 TeamName1 = new JLabel();
		TeamName1.setBounds(10, 10, 400, 40);
		TeamName1.setText(Team1.getTeamName());
		TeamName1.setFont(new Font("Arial Black",Font.BOLD,25));
		contentPane.add(TeamName1);
		
		
		  TeamName2= new JLabel();
		TeamName2.setBounds(332, 10, 400, 40);
		TeamName2.setText(Team2.getTeamName());
		TeamName2.setFont(new Font("Arial Black",Font.BOLD,25));
		contentPane.add(TeamName2);
		
		 ScoreJLabel  = new JLabel();
		ScoreJLabel.setBounds(225, 100, 200, 40);
		ScoreJLabel.setFont(new Font("Arial Black",Font.BOLD,30));
		int[] TempScore = new int[2];
		ScoreJLabel.setText(TempScore[0]+"-"+TempScore[1]);
		contentPane.add(ScoreJLabel);
		
		Time = new JLabel("0'");
		Time.setBounds(228, 60, 200, 40);
		Time.setFont(new Font("Arial Black",Font.BOLD,30));
		contentPane.add(Time);
		
	
		
		Team1Players = new JTextArea();
		Team1Players.setBounds(10, 120, 150, 140);
		Team1Players.setEditable(false);
		Team1Players.setFont(new Font("Arial Black",Font.BOLD,13));
		ArrayList getPlayers1 = Team1.getPlayers();
		String tempname = new String();
		for(int i=0;i<4;i++)
		{
			Player TempPlayer = (Player) getPlayers1.get(i);
			String tempname1 = TempPlayer.getFirstName();
			String LetterName = String.valueOf(tempname1.charAt(0));
			Team1Players.append(String.valueOf(i+1)+". "+LetterName+"."+TempPlayer.getLastName()+"\n");
		}	
		contentPane.add(Team1Players);
		
		Team2Players = new JTextArea();
		Team2Players.setBounds(340, 120, 150, 140);
		Team2Players.setEditable(false);
		Team2Players.setFont(new Font("Arial Black",Font.BOLD,13));
		ArrayList getPlayers2 = Team2.getPlayers();
		for(int i=0;i<4;i++)
		{
			Player TempPlayer = (Player) getPlayers2.get(i);
			String tempname1 = TempPlayer.getFirstName();
			String LetterName = String.valueOf(tempname1.charAt(0));
			Team2Players.append(String.valueOf(i+1)+". "+LetterName+"."+TempPlayer.getLastName()+"\n");
		}
		contentPane.add(Team2Players);
		
		
		WhoScored = new JTextArea();
		WhoScored.setBounds(10, 270, 560, 200);
		WhoScored.setEditable(false);
		WhoScored.setFont(new Font("Arial Black",Font.BOLD,12));
		contentPane.add(WhoScored);
		
		
		
		ActionListener timerActionListener = 
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						clockTimerActionPerformed(event);
					}
				};		
		clockTimer= new Timer(10,timerActionListener);
		
		
		
		setTitle("Game Simulation");
		setSize(630,550);
		setVisible(true);
		setLayout(null);
		
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
			scories1.add(tempPlayers[PlayerNumber]);
		}
		else if(TeamNumber == 2)	
		{
			tempPlayers = getTeam2Players();
			tempPlayers[PlayerNumber].setGoals(1);
			setPlayerScored(tempPlayers[PlayerNumber]);
			scories2.add(tempPlayers[PlayerNumber]);

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

	
	private void runVisuals()
	{
		
		runGame();
		TotalGoals = score[0]+score[1];
		System.out.println(TotalGoals);
		System.out.println(timeScored);
		System.out.println(timeScored2);
	
		
		
		
		
		
		clockTimer.start();
		 
	}
	
	private void clockTimerActionPerformed(ActionEvent event) 
	{
		
		
		
		if(ClockTime<90)
		{
		ClockTime+=1;
		Time.setText(String.valueOf(ClockTime)+"'");
		}
		else
		{
			ScoreJLabel.setText(String.valueOf(tempScore[0]+"-"+tempScore[1]));
			clockTimer.stop();
			EndGameProcedure();
			JOptionPane.showMessageDialog(null, 
					 " GAME OVER. EXIT THE WINDOW",
						"GAME OVER", JOptionPane.INFORMATION_MESSAGE);	
		}
		
		for(int i=0;i<timeScored.size();i++)
		{
			if(ClockTime==timeScored.get(i))
			{
				tempScore[0]+=1;
				ScoreJLabel.setText(String.valueOf(tempScore[0]+"-"+tempScore[1]));
				Player TempPlayer = (Player) scories1.get(whichPlayerScored1);
				
				
				WhoScored.append(Time.getText()+" "+TempPlayer.getFirstName()+" "+TempPlayer.getLastName()+" scored a goal for " +Team1.getTeamName()+" \n" );
				whichPlayerScored1++;
			}
		}
		for(int i=0;i<timeScored2.size();i++)
		{
			if(ClockTime==timeScored2.get(i))
			{
				tempScore[1]+=1;	
				ScoreJLabel.setText(String.valueOf(tempScore[0]+"-"+tempScore[1]));
				Player TempPlayer = (Player) scories2.get(whichPlayerScored2);
				
				WhoScored.append(Time.getText()+" "+TempPlayer.getFirstName()+" "+TempPlayer.getLastName()+" scored a goal for " +Team2.getTeamName()+" \n" );
				whichPlayerScored2++;

			}
		}
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

	public Team[] returnTeamsPlayed()
	{
		Team[] sendArray = new Team[2];
		sendArray[0] = Team1;
		sendArray[1] = Team2;
		
		return sendArray;
	}
	
	
	
}
