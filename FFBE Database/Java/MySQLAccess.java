import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLAccess
{
	//Used for creating the JDBC components needed to obtain the data.
  private Connection connect = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  //Connection info to Tyler's GCP 
   	String url = "jdbc:mysql://35.238.101.184:3306/FFBE";
   	String username = "root";
	String password = "Root69";
	
	//Checks the connection status
	boolean IsConnected = false;
  
  public ResultSet FetchTableData(int ID, String table) throws Exception
  {
    try {
      // This will load the MySQL driver, each DB has its own driver
     // Class.forName("com.mysql.jdbc.Driver");
      
      // Setup the connection with the DB
    	if(!IsConnected)
    	{
    		connect = DriverManager.getConnection(url, username, password);
    		IsConnected = true;
    	}
    	
      // Statements allow to issue SQL queries to the database
    	//Modified to choose which table based on meta data from the FFBEDBController.java file (Not currently Made)
      preparedStatement = connect.prepareStatement("SELECT * FROM "+ table +" WHERE "+(table + "_ID") +" = ?");
      preparedStatement.setString(1, Integer.toString(ID));
      // Result set get the result of the SQL query
      resultSet = preparedStatement.executeQuery();
      
    } catch (Exception e) {
      System.out.println("You've encountered an error while fetching Unit data.");
      throw e;
    }
	return resultSet;

  }

  // You need to close the resultSet
  public void close() throws Exception {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (connect != null) {
        connect.close();
        IsConnected = false;
      }
    } catch (Exception e) {
    	System.out.println("You've encountered an error while trying to close the connection or resultset.");
    	throw e;
    }
  }

}
