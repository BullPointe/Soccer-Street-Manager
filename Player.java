import java.util.ArrayList;
import java.util.Random;

public class Player 
{
	public String FirstName;
	public String LastName;
	public int Goals=0;
	public int Rating;
	
	private  String[] FirstNames = {"JAMES","JOHN","ROBERT","MICHAEL","WILLIAM","DAVID","RICHARD","CHARLES" ,"JOSEPH","THOMAS","CHRISTOPHER","DANIEL" ,"PAUL","MARK","DONALD","GEORGE","KENNETH","STEVEN","EDWARD","BRIAN","RONALD","ANTHONY","KEVIN","JASON","MATTHEW", "GARY","TIMOTHY" ,"JOSE","LARRY", "JEFFREY" ,"FRANK","SCOTT","ERIC","STEPHEN","ANDREW" ,"RAYMOND","GREGORY","JOSHUA","JERRY","DENNIS","WALTER","PATRICK","PETER" ,"HAROLD","DOUGLAS" ,"HENRY" ,"CARL","ARTHUR","RYAN", "ROGER"};
	private String[] LastNames= {"SMITH","JOHNSON","WILLIAMS","JONES","BROWN","DAVIS","MILLER","WILSON","MOORE","TAYLOR","ANDERSON","THOMAS","JACKSON","WHITE","HARRIS","MARTIN","THOMPSON","GARCIA","MARTINEZ","ROBINSON","GRAY "    ,     " RAMIREZ "  ,    "JAMES "    ,    " WATSON "    ,   "BROOKS "    ,  "KELLY"  ,   "SANDERS "    ,   "PRICE "  ,       "BENNETT "   ,    "WOOD "    ,      "BARNES " ,      "ROSS"    ,      " HENDERSON " ,   " COLEMAN",        "JENKINS ",       
			"PERRY",         " POWELL "   ,    "LONG "    ,      "PATTERSON"   , "HUGHES"    ,    
			"FLORES "   ,     "WASHINGTON"   ,  "BUTLER"     ,   "SIMMONS"   ,     "FOSTER"    ,     "GONZALES"      , "BRYANT" ,        "ALEXANDER" ,     "RUSSELL"     ,   "GRIFFIN",       " DIAZ",          "HAYES"  ,        "MYERS " ,        "FORD"  ,         "HAMILTON"  ,     
			"GRAHAM"   ,      "SULLIVAN"  ,     "WALLACE" ,     " WOODS"     ,     "COLE " ,         
			"WEST"  ,         "JORDAN"    ,     "OWENS"  ,        "REYNOLDS ",      "FISHER",         
			"ELLIS"  ,        "HARRISON "    ,  "GIBSON"      };   

	

	public Player() 
	{	
		
	}
	
	private void setFirstName(String name)
	{
		FirstName = name;
	}
	
	public String getFirstName()
	{
		return FirstName;
	}
	
	private void setLastName(String name)
	{
		FirstName= name;
	}
	
	public String getLastName()
	{
		return LastName;
	}
	
	public void setGoals(int scored)
	{
		Goals += scored;
	}
	
	public int getGoals()
	{
		return Goals;
	}
	
	private void setRating(int rating)
	{
		Rating = rating; 
	}
	
	public int getRating()
	{
		return Rating;
	}
	
	
	public void createPlayer(int rating)
	{
		
		Random gen = new Random();
		
		FirstName = FirstNames[gen.nextInt(FirstNames.length)];
		LastName= LastNames[gen.nextInt(LastNames.length)];
		
		setRating(rating + gen.nextInt(7));
		setGoals(0);
		
	}
	
	
	
	


}
