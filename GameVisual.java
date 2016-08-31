import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameVisual extends JFrame
{
	
	private JLabel GameName;
	private JLabel CreaterName;
	private JButton CreateNewTeam,EnterButton;
	private JTextField TeamName;
	
	
	
	public GameVisual()
	{
		createUserInterFace();
	}
	
	public void createUserInterFace()
	{
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		GameName = new JLabel("Soccer Street Manager");
		GameName.setBounds(50, 50, 500, 70);
		GameName.setForeground(Color.RED);
		GameName.setFont(new Font("Arial Black",Font.BOLD,30));
		contentPane.add(GameName);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       //
		
		TeamName = new JTextField("Enter Team Name");
		TeamName.setBounds(140, 270, 200, 50);
		TeamName.setFont(new Font("Arial Black",Font.BOLD,15));
		TeamName.setHorizontalAlignment(JTextField.CENTER);
		TeamName.setVisible(false);
		contentPane.add(TeamName);
		
		EnterButton = new JButton("NEXT");
		EnterButton.setBounds(185, 340, 100, 40);
		EnterButton.setForeground(Color.RED);
		EnterButton.setFont(new Font("Arial Black",Font.BOLD,10));
		EnterButton.setVisible(false);
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
		
		
		CreaterName = new JLabel("BY:SAHIL JAGANMOHAN");
		CreaterName.setBounds(142, 100, 500, 70);
		CreaterName.setForeground(Color.RED);
		CreaterName.setFont(new Font("Arial Black",Font.BOLD,15));
		contentPane.add(CreaterName);
		
		CreateNewTeam = new JButton("Create New Team");
		CreateNewTeam.setBounds(140, 200, 200, 50);
		CreateNewTeam.setFont(new Font("Arial Black",Font.BOLD,15));
		contentPane.add(CreateNewTeam);
		CreateNewTeam.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						EnterButton.setVisible(true);
						TeamName.setVisible(true);
					}
				}
				);
		
		
		
		setTitle("Soccer Street Manager");
		setSize(550,550);
		setVisible(true);
		setLayout(null);
	}

	
	private void EnterJButtonActionPerformed(ActionEvent e) 
	{
		Team tempTeam = new Team();
		tempTeam.createTeam();
		tempTeam.setTeamName(TeamName.getText());
		
		CreationLeaguePage page = new CreationLeaguePage(tempTeam);
		this.dispose();
		
	}

}
