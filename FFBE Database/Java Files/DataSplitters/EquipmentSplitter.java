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
 * Takes in the data.json file and splits it. The results are outputted to a EquipmentSQLData.txt file
 */
public class EquipmentSplitter {

	public static void main(String[] args) throws IOException, ParseException {
	
		try
		{
			JSONParser parser = new JSONParser();
			JSONArray equipment = (JSONArray) parser.parse(new FileReader("data.json"));
			Formatter output = new Formatter("EquipmentSQLData.txt");
			output.format("Values ");
			output.close();
			
			for(int i = 0; i < equipment.size(); i++)
			{
				Action((JSONObject) equipment.get(i));
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
	public static void WriteEsper(String name, String id, String type ) throws IOException
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter("EquipmentSQLData.txt", true));
			String info = String.format("(%s, '%s', '%s'),%n", id, name, type);
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
	public static void Action(JSONObject Equipment) throws IOException
	{
		String name = (String) Equipment.get("name");
		String id = (String) Equipment.get("id");
		String type =  (String) Equipment.get("type");
		
		WriteEsper(name, id, type);
	}
}
