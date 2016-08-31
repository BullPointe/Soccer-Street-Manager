import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Hub extends JFrame
{
	
	private JButton NextGame,ViewTable,ViewTeam;
	private JLabel HubMessage, ShowWeekNumber;
	private League MainLeague = new League();
	private int WeekNumber;
	private Team UserTeam;
	
	
	public Hub(League RecieveLeague, Team Team) 
	{
		MainLeague = RecieveLeague;
		UserTeam = Team;
		System.out.println(MainLeague.getTeams());
		createUserInterface();
	}

	private void createUserInterface()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		HubMessage = new JLabel("Game Hub");
		HubMessage.setBounds(165, 30, 200, 30);
		HubMessage.setFont(new Font("Arial Black",Font.BOLD,25));
		contentPane.add(HubMessage);
		
		ShowWeekNumber = new JLabel("Week 0");
		ShowWeekNumber.setBounds(0, 5, 200, 40);
		ShowWeekNumber.setFont(new Font("Arial Black",Font.BOLD,15));
		contentPane.add(ShowWeekNumber);
		
		NextGame= new JButton("Next Game");
		NextGame.setBounds(140, 100, 200, 50);
		NextGame.setFont(new Font("Arial Black",Font.BOLD,15));
		contentPane.add(NextGame);
		NextGame.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						NextGameButtonActionPerformed(e);
					}
				}
				
				
				);
		
		ViewTable = new JButton("View Table");
		ViewTable.setBounds(140, 200, 200, 50);
		ViewTable.setFont(new Font("Arial Black",Font.BOLD,15));
		contentPane.add(ViewTable);
		ViewTable.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						LeagueTable app = new LeagueTable(MainLeague);
						
					}

					
				}
				
				
				
				);
		
		ViewTeam = new JButton("View Your Team");
		ViewTeam.setBounds(140, 300, 200, 50);
		ViewTeam.setFont(new Font("Arial Black",Font.BOLD,15));
		contentPane.add(ViewTeam);
		ViewTeam.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ViewTeam app = new ViewTeam(UserTeam);
					}
				}
				
				);
		
		setSize(550,550);
		setTitle("Game Hub");
		setVisible(true);
		setLayout(null);
	}

	private void NextGameButtonActionPerformed(ActionEvent e)
	{
		
		Schedule[] TempGrandSchedule = new Schedule[10];
		TempGrandSchedule =MainLeague.getGrandSchedule();

		if(WeekNumber<TempGrandSchedule.length)
		{
			Team[][] TempEachWeek =TempGrandSchedule[WeekNumber].getSchedule();
		
			System.out.println(TempEachWeek[0][3].getTeamName()+TempEachWeek[1][3].getTeamName());
				
		
		
		for(int i=0; i<3;i++)
		{
			if(TempEachWeek[0][i].getTeamName()==UserTeam.getTeamName()|| TempEachWeek[1][i].getTeamName()==UserTeam.getTeamName())
			{
				GameSimulation app = new GameSimulation(TempEachWeek[0][i],TempEachWeek[1][i]);
				Team[] tempTeamsPlayed = app.returnTeamsPlayed();
				UpdateTeamsPlayed(tempTeamsPlayed,0);
				i++;
			}
			
			BackgroundGames app = new BackgroundGames(TempEachWeek[0][i],TempEachWeek[1][i]);
			app.runGame();
			Team[] tempTeamsPlayed = app.returnTeamsPlayed();
			UpdateTeamsPlayed(tempTeamsPlayed,0);
			
			
		}//END OUTER LOOP
		WeekNumber++;
		ShowWeekNumber.setText("Week" + WeekNumber );
		}//END IF 
		else
		{
			JOptionPane.showMessageDialog(null, 
					 " THE SEASON IS OVER. CHECK THE TABLE FOR YOUR STANDINGS",
						"SEASON OVER", JOptionPane.INFORMATION_MESSAGE);	
		}
		
		
	}

	private void UpdateTeamsPlayed(Team[] tempTeamsPlayed,int i) 
	{
		ArrayList tempTeams = MainLeague.getTeams();
		
		for(int g=0; g<tempTeams.size();g++)
		{
			Team tempcheckTeam = (Team) tempTeams.get(g);
			if(tempTeamsPlayed[0].getTeamName().equals(tempcheckTeam.getTeamName()))
			{
				tempTeams.set(g,tempTeamsPlayed[0]);
			}
			if(tempTeamsPlayed[1].getTeamName().equals(tempcheckTeam.getTeamName()))
			{
				tempTeams.set(g,tempTeamsPlayed[1]);
			}
		}//INNER LOOP
		
		MainLeague.setTeams(tempTeams);
		
	}
	
	

}
