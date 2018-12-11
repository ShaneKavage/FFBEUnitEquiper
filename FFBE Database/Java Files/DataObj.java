/*
 * Shane & Tyler Kavage
 * Database - DataObj
 * 
 * Acts as an object that holds an id and name.
 * Used to populate comboboxes so they can display the name for selection and associate the ID for query calls
 */
public class DataObj {

	private String id;
	private String name;
	
	/**
	 * Constructor to set the object's values on creation
	 * @param id
	 * @param name
	 */
	public DataObj(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return id;
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * @return names
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return string
	 */
	@Override
	public String toString()
	{
		return this.getName();
	}
	
}
