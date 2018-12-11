import java.io.FileReader;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.FormatterClosedException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * Shane & Tyler Kavage
 * Database - EquipmentSplitter
 * 
 * Takes in the esper.json file and splits it. The results are outputted to a EsperSQLData.txt file
 */
public class EsperSplitter {

	public static void main(String[] args) throws IOException, ParseException {
	
		/**
		 * Attempts to split object
		 */
		try
		{
			JSONParser parser = new JSONParser();
			JSONArray esper = (JSONArray) parser.parse(new FileReader("espers.json"));
			Formatter output = new Formatter("EsperSQLData.txt");
			output.format("Values ");
			output.close();
			
			for(int i = 0; i < esper.size(); i++)
			{
				Action((JSONObject) esper.get(i));
			}
				
		}
		catch(SecurityException | FileNotFoundException | FormatterClosedException | org.json.simple.parser.ParseException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Writes out the information in a formated string
	 * @param name
	 * @param id
	 * @param type
	 * @throws IOException
	 */
	public static void WriteEsper(String name, String id, Long rank ) throws IOException
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter("EsperSQLData.txt", true));
			String info = String.format("('%s', '%s', %d),%n", id, name, rank);
			out.write(info);
			out.close();
		}
		catch(SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the desired values for each selection and writes it out
	 * @param Equipment
	 * @throws IOException
	 */
	public static void Action(JSONObject Esper) throws IOException
	{
		String name = (String) Esper.get("name");
		String id = (String) Esper.get("id");
		Long rank =  (Long) Esper.get("maxLevel");
		
		WriteEsper(name, id, rank);
	}
}
