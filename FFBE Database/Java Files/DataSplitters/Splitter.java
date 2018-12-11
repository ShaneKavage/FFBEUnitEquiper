import java.io.FileReader;
import java.util.Formatter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.javafx.scene.paint.GradientUtils.Parser;
/*
 * Shane & Tyler Kavage
 * Database - Splitter
 * 
 * Takes in the units.json file and splits it. The results are outputted to a UnitsSQLData.txt file
 */
public class Splitter {

	public static void main(String[] args) throws IOException, ParseException {
		
		/**
		 * Attempts to split object
		 */
		try
		{
			JSONParser parser = new JSONParser();
			JSONObject units = (JSONObject) parser.parse(new FileReader("units.json"));
			Iterable<String> unitList = units.keySet();
			Formatter output = new Formatter("UnitsSQLData.txt");
			output.format("Values ");
			output.close();
			
			for (String unitID : unitList)
			{
				JSONObject Unit = (JSONObject) units.get(unitID);
				String name = (String) Unit.get("name");
				int id = Integer.parseInt((String) Unit.get("id"));
				String sex = (String) Unit.get("sex");
				int MinRarity = Integer.parseInt((String) Unit.get("min_rarity"));
				int MaxRarity = Integer.parseInt((String) Unit.get("max_rarity"));
				Long BreakPattern =  (Long) Unit.get("stats_pattern");
				
				WriteUnit(name, id, sex, MinRarity, MaxRarity, BreakPattern);
				
				
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
	public static void WriteUnit(String name, int id, String sex, int MinRarity, int MaxRarity, Long pattern) throws IOException
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter("UnitsSQLData.txt", true));
			String info = String.format("(%d, '%s', '%s', %d, %d, %d),%n", id, name, sex, MinRarity, MaxRarity, pattern);
			out.write(info);
			out.close();
		}
		catch(SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
		}
	}

}
