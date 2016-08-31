import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ViewTeam extends JFrame
{

	private JLabel WelcomeMessage;
	private JLabel YourPlayersMessage,TopScorer;
	private JTextArea Players, Results;
	private Team UserTeam;
	private JButton pastGames;

	public ViewTeam(Team User) 
	{
		UserTeam=User;
		createUserInterface();
	}

	private void createUserInterface() 
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		WelcomeMessage = new JLabel("Welcome Mr.Manager to your team.");
		WelcomeMessage.setBounds(20, 20, 550, 40);
		WelcomeMessage.setFont(new Font("Arial Black", Font.BOLD,18));
		contentPane.add(WelcomeMessage);
		
		YourPlayersMessage = new JLabel("Here are your players:");
		YourPlayersMessage.setBounds(20, 40, 550, 40);
		YourPlayersMessage.setFont(new Font("Arial Black", Font.BOLD,18));
		contentPane.add(YourPlayersMessage);
		
		Players = new JTextArea();
		Players.setBounds(20, 80, 440, 160);
		Players.setFont(new Font("Arial Black", Font.BOLD,18));
		Players.setEditable(false);
		contentPane.add(Players);
		ArrayList getPlayers = UserTeam.getPlayers();
		for(int i=0;i<4;i++)
		{
			Player TempPlayer = (Player) getPlayers.get(i);
			Players.append(String.valueOf(i+1)+". "+TempPlayer.getFirstName()+" "+TempPlayer.getLastName()+"\n");
		}	
		
		TopScorer = new JLabel();
		TopScorer.setBounds(20, 240, 550, 80);
		TopScorer.setText("Top Goal Scorer: "+UserTeam.getTopScorerName());
		TopScorer.setFont(new Font("Arial Black", Font.BOLD,17));
		contentPane.add(TopScorer);
		
		/*
		Results = new JTextArea();
		Results.setBounds(10, 300, 500, 350);
		Results.setFont(new Font("Arial Black", Font.BOLD,17));
		Results.append(UserTeam.getGamesPlayed());
		contentPane.add(Results);
		*/
		
		
		
		setSize(550,800);
		setVisible(true);
		setLayout(null);
		setTitle(" Your Team ");
		
	}
	
	
}
