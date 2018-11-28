
import java.sql.Connection;
import java.sql.DriverManager;
/*
 * Shane Kavage
 * FFBE Controller java
 */
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//Will be remade into the controller class once functioning
public class Interact
{
	
	//Main for testing - will not be in final controller class
	public static void main(String[] args) throws Exception
	{
		//Going to turn this into a 
		int ID = 18;
		
		ResultSet rs = null;
		//Obj that takes care of access
		MySQLAccess DBFetcher = new MySQLAccess();
		
		/* I dont think these will be able to be tested by you on your computer - IP isn't whitelisted
		 * 8171 - Viktor Marchenko
		 * 331 - Randi (Secret of Mana)
		 * 2234321 - Random gibberish not in database
		 */
		rs = DBFetcher.FetchTableData(ID, "Stats");
		ResultSetMetaData meta = rs.getMetaData();
		
		//Goes through each column and row and prints the data associated with the RS
		while(rs.next())
		{
			for(int i = 1; i <= meta.getColumnCount(); i++)
			{
				//Will need to find a way to do this with multiple value types (Bool vs double vs string mainly)
				//if(rs.getDouble(i) > 0)
				//{
					System.out.print("  ");
				    String columnValue = rs.getString(i);
				    System.out.print(meta.getColumnName(i) + ": " + columnValue);
				//}
			}
			System.out.println("");
		}
	}
}