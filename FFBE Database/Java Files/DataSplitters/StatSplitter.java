import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 * Shane & Tyler Kavage
 * Database - StatSplitter
 * 
 * Takes in the units.json file and splits it. The results are outputted to a UnitStatData.txt file
 */
public class StatSplitter {

	
	public static HashMap<String, String> Ailments = new HashMap<String, String>(),
			Elements= new HashMap<String, String>(),
			Resistances= new HashMap<String, String>();
	
	public static void main(String[] args) throws IOException, ParseException {
	
		/**
		 * Attempts to split object
		 */
		try
		{
			fillMaps();
			JSONParser parser = new JSONParser();
			JSONObject CharacterData = (JSONObject) parser.parse(new FileReader("units.json"));
			Iterable<String>  keys = CharacterData.keySet();
			Formatter output = new Formatter("UnitStatData.txt");
			output.format("Values ");
			output.close();
			for(String key : keys)
			{
				JSONObject CharacterStats = (JSONObject) CharacterData.get(key);
				JSONObject stats = (JSONObject) CharacterStats.get("stats");
				JSONObject maxStats = (JSONObject) stats.get("maxStats");
				Iterable<String> statKeys = maxStats.keySet();
				
				Long statsArray[] = new Long[6];
				int i = 0;
				for(String statKey : statKeys)
				{
					statsArray[i] = (Long) maxStats.get(statKey);
					i++;
				}
				String id = (String) CharacterStats.get("id");
				double hp =  statsArray[0];
				double mp =  statsArray[1];
				double atk =  statsArray[2];
				double def =  statsArray[3];
				double mag =  statsArray[4];
				double spr =  statsArray[5];
				
				WriteUnitData(id, hp, mp, atk, def, mag, spr);
			}
					
			
		}
		catch(SecurityException | FileNotFoundException | FormatterClosedException | org.json.simple.parser.ParseException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Outputs the units data as a formated string to a text file
	 * @param id
	 * @param hp
	 * @param mp
	 * @param atk
	 * @param def
	 * @param mag
	 * @param spr
	 * @throws IOException
	 */
	public static void WriteUnitData(String id, double hp, double mp,
			double atk, double def, double mag, double spr) throws IOException{

		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter("UnitStatData.txt", true));
			String info = String.format("(%s, %s, %s, %s, %s, %s, %s, 0, 0, 0, 0, 0, 0,", id, hp, mp, atk, def, mag, spr);				
			
			for(Entry<String, String> key : Elements.entrySet())
			{
				info += key.getValue() + ", ";
			}
			for(Entry<String, String> key : Elements.entrySet())
			{
				info += key.getValue() + ", ";
			}
			for(Entry<String, String> key : Ailments.entrySet())
			{
				info += key.getValue() + ", ";
			}
			for(Entry<String, String> key : Resistances.entrySet())
			{
				info += key.getValue() + ", ";
			}
			info = info.substring(0, info.length()-2);
			info = String.format("%s),%n",info);
			
			out.write(info);
			out.close();
		}
		catch(SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Currently used to get the correct output format
	 * Will Be used to obtain the proper information Eventually
	 * Once the splitter can obtain the desired data better
	 */
	public static void fillMaps()
	{
		Elements.put("fire", "0");
		Elements.put("ice", "0");
		Elements.put("thunder", "0");
		Elements.put("water", "0");
		Elements.put("wind", "0");
		Elements.put("earth", "0");
		Elements.put("light", "0");
		Elements.put("dark", "0");
		
		Elements.put("fire", "0");
		Elements.put("ice", "0");
		Elements.put("thunder", "0");
		Elements.put("water", "0");
		Elements.put("wind", "0");
		Elements.put("earth", "0");
		Elements.put("light", "0");
		Elements.put("dark", "0");
		
		Ailments.put("fire", "0");
		Ailments.put("ice", "0");
		Ailments.put("thunder", "0");
		Ailments.put("water", "0");
		Ailments.put("wind", "0");
		Ailments.put("earth", "0");
		Ailments.put("light", "0");
		Ailments.put("dark", "0");
		
		Resistances.put("fire", "0");
		Resistances.put("ice", "0");
		Resistances.put("thunder", "0");
		Resistances.put("water", "0");
		Resistances.put("wind", "0");
		Resistances.put("earth", "0");
		Resistances.put("light", "0");
		Resistances.put("dark", "0");
	}
}
