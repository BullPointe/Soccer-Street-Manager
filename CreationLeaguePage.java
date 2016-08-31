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

public class CreationLeaguePage extends JFrame
{
	private Team UserTeam;
	private JButton EnterButton;
	private JLabel WelcomeMessage,YourPlayersMessage;
	private JTextArea Players;

	public CreationLeaguePage(Team User) 
	{
		UserTeam = User;
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
		Players.setBounds(20, 100, 550, 180);
		Players.setFont(new Font("Arial Black", Font.BOLD,18));
		Players.setEditable(false);
		contentPane.add(Players);
		ArrayList getPlayers = UserTeam.getPlayers();
		for(int i=0;i<4;i++)
		{
			Player TempPlayer = (Player) getPlayers.get(i);
			Players.append(String.valueOf(i+1)+". "+TempPlayer.getFirstName()+" "+TempPlayer.getLastName()+"\n");
		}	
		
		EnterButton = new JButton("NEXT");
		EnterButton.setBounds(185, 340, 100, 40);
		EnterButton.setForeground(Color.RED);
		EnterButton.setFont(new Font("Arial Black",Font.BOLD,10));
		EnterButton.setVisible(true);
		contentPane.add(EnterButton);
		EnterButton.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						EnterJButtonActionPerformed(e);
					}
				}
				);
		
		
		setSize(550,550);
		setVisible(true);
		setLayout(null);
		setTitle(" Your Team ");
		
		
	}

	private void EnterJButtonActionPerformed(ActionEvent e)
	{
		
		League newLeague = new League();
		newLeague.addTeams(UserTeam);
		System.out.println(newLeague.getTeams());
		newLeague.CreateGrandSchedule();
		Hub app = new Hub(newLeague,UserTeam);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		this.dispose();
		
	}

}
