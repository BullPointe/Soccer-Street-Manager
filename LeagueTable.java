import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LeagueTable extends JFrame
{
	
	private League  MainLeague = new League();
	ArrayList Teams = new ArrayList();
	ArrayList LeagueTable = new ArrayList();
	
	public LeagueTable(League RecieveLeague) 
	{
		MainLeague = RecieveLeague;
		//MainLeague.setLeagueTable();
		Teams= MainLeague.getTeams();
		createUserInterFace();
	}

	private void createUserInterFace() 
	{
		Container contentPane = getContentPane();
		
		
		String[] columnNames = {"Team","Points"};
		
		Object[][] data = new Object[Teams.size()][2];
		
		MainLeague.setLeagueTable();
		LeagueTable = MainLeague.getLeagueTable();
		System.out.println(LeagueTable);
		
		for(int i=0;i<8;i++)
		{
			Team TempTeam = new Team();
			TempTeam = (Team) LeagueTable.get(i);
			data[i][0] = TempTeam.getTeamName();
			data[i][1] = TempTeam.getPoints();
		}
		
		JTable table = new JTable(data, columnNames);
		table.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		table.setPreferredScrollableViewportSize(new Dimension(300,40));
		
		//SCROLL PANE
		JScrollPane scrollpane = new JScrollPane(table);
		contentPane.add(scrollpane,BorderLayout.CENTER);
		
		
		
		
		setTitle("League Table");
		setSize(650,500);
		setVisible(true);
		
	}

}
