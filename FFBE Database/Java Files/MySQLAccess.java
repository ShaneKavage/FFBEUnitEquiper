import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLAccess
{
  private Connection connect = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  String url = "";
  String username = "root";
  String password = "Root69";
	
  boolean IsConnected = false;
  
  /**
   * Fetches data for a specific ID from a Specified table
   * @param ID
   * @param table
   * @return ResultSet holding desired info if exits
   * @throws Exception
   */
  public ResultSet FetchTableData(String ID, String table) throws Exception
  {
    try {
    	if(!IsConnected)
    	{
    		connect = DriverManager.getConnection(url, username, password);
    		IsConnected = true;
    	}
        preparedStatement = connect.prepareStatement("SELECT * FROM "+ table +" WHERE "+(table + "_ID") +" = ?");
        preparedStatement.setString(1,(ID));
     
        resultSet = preparedStatement.executeQuery();
    } catch (Exception e) {
    	System.out.println("You've encountered an error while fetching Unit data.");
      throw e;
    }
	return resultSet;

  }
  
  /**
   * Fetches All data from a specific table
   * @param ID
   * @param table
   * @return ResultSet holding desired info if exits
   * @throws Exception
   */
  public ResultSet FetchTableData(String table) throws Exception
  {
    try {
    	if(!IsConnected)
    	{
    		connect = DriverManager.getConnection(url, username, password);
    		IsConnected = true;
    	}
    	
        preparedStatement = connect.prepareStatement("SELECT * FROM "+ table + ";");
        resultSet = preparedStatement.executeQuery();
       
    } catch (Exception e) {
        System.out.println("You've encountered an error while fetching Unit data.");
      throw e;
    }
	return resultSet;

  }

  /**
   * Closes the set if it is open or not connected
   * @throws Exception
   */
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
