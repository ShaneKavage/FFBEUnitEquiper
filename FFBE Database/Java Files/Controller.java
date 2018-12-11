import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
/*
 * Shane & Tyler Kavage
 * Databases - Controller
 * 
 * This Acts as the controller for the program. It is the interface that allows the user to interact with data from the database
 * and displays the desired information on screen.
 */
public class Controller
{
	ResultSet Weapon1 = null, Weapon2 = null, Helmet = null, Chest = null, Acc1 = null, Acc2 = null, Materia1 = null,
			Materia2 = null, Materia3 = null, Materia4 = null, Unit = null, Esper = null;
	MySQLAccess DBFetcher = new MySQLAccess();

	/**
	 * Fills the combo boxes, sets their listeners and sets all of the textview fields to 0.
	 * @throws Exception
	 */
	public void initialize() throws Exception
	{
		FillComboBoxes();
		setEventOnSelectListeners();
		setFields();
	}
	
	@FXML private ComboBox<DataObj> UnitSpinner;
	@FXML private ComboBox<DataObj> EsperSpinner;
	@FXML private ComboBox<DataObj> WeaponSpinner;
	@FXML private ComboBox<DataObj> WeaponSpinner2;
	@FXML private ComboBox<DataObj> HelmetSpinner;
	@FXML private ComboBox<DataObj> ChestSpinner;
	@FXML private ComboBox<DataObj> AccSpinner1;
	@FXML private ComboBox<DataObj> AccSpinner2;
	@FXML private ComboBox<DataObj> MateriaSpinner1;
	@FXML private ComboBox<DataObj> MateriaSpinner2;
	@FXML private ComboBox<DataObj> MateriaSpinner3;
	@FXML private ComboBox<DataObj> MateriaSpinner4;
	@FXML private TextArea baseHP;
	@FXML private TextArea baseMP;
	@FXML private TextArea baseATK;
	@FXML private TextArea baseDEF;
	@FXML private TextArea baseMAG;
	@FXML private TextArea baseSPR;
	@FXML private TextArea baseHPPercent;
	@FXML private TextArea baseMPPercent;
	@FXML private TextArea baseATKPercent;
	@FXML private TextArea baseDEFPercent;
	@FXML private TextArea baseMAGPercent;
	@FXML private TextArea baseSPRPercent;
	@FXML private TextArea esperHP;
	@FXML private TextArea esperMP;
	@FXML private TextArea esperATK;
	@FXML private TextArea esperDEF;
	@FXML private TextArea esperMAG;
	@FXML private TextArea esperSPR;
	@FXML private TextArea equipHP;
	@FXML private TextArea equipMP;
	@FXML private TextArea equipATK;
	@FXML private TextArea equipDEF;
	@FXML private TextArea equipMAG;
	@FXML private TextArea equipSPR;
	@FXML private TextArea equipHPPercent;
	@FXML private TextArea equipMPPercent;
	@FXML private TextArea equipATKPercent;
	@FXML private TextArea equipDEFPercent;
	@FXML private TextArea equipMAGPercent;
	@FXML private TextArea equipSPRPercent;
	@FXML private TextArea finalHP;
	@FXML private TextArea finalMP;
	@FXML private TextArea finalATK;
	@FXML private TextArea finalDEF;
	@FXML private TextArea finalMAG;
	@FXML private TextArea finalSPR;
	@FXML private TextArea finalHPPercent;
	@FXML private TextArea finalMPPercent;
	@FXML private TextArea finalATKPercent;
	@FXML private TextArea finalDEFPercent;
	@FXML private TextArea finalMAGPercent;
	@FXML private TextArea finalSPRPercent;
	@FXML private TextArea poisonATK;
	@FXML private TextArea paralysisATK;
	@FXML private TextArea sleepATK;
	@FXML private TextArea blindATK;
	@FXML private TextArea confuseATK;
	@FXML private TextArea silenceATK;
	@FXML private TextArea diseaseATK;
	@FXML private TextArea petrifyATK;
	@FXML private TextArea poisonRES;
	@FXML private TextArea paralysisRES;
	@FXML private TextArea sleepRES;
	@FXML private TextArea blindRES;
	@FXML private TextArea confuseRES;
	@FXML private TextArea silenceRES;
	@FXML private TextArea diseaseRES;
	@FXML private TextArea petrifyRES;
	@FXML private TextArea fireATK;
	@FXML private TextArea iceATK;
	@FXML private TextArea thunderATK;
	@FXML private TextArea waterATK;
	@FXML private TextArea windATK;
	@FXML private TextArea earthATK;
	@FXML private TextArea lightATK;
	@FXML private TextArea darkATK;
	@FXML private TextArea fireRES;
	@FXML private TextArea iceRES;
	@FXML private TextArea thunderRES;
	@FXML private TextArea waterRES;
	@FXML private TextArea windRES;
	@FXML private TextArea earthRES;
	@FXML private TextArea lightRES;
	@FXML private TextArea darkRES;
	
	/**
	 * Runs all of the Populate spinner methods to fill the comboBoxes
	 * @throws Exception
	 */
	public void FillComboBoxes() throws Exception
	{	
		populateWeaponSpinners();
		populateUnitSpinner();
		populateEsperSpinner();
		populateChestSpinner();
		populateHelmetSpinner();
		populateMateriaSpinners();
		populateAccSpinners();
	}
	
	/**
	 * Fills the Unit comboBox by creating DataObj objects from the result sets of all units to the combobox
	 * @throws Exception
	 */
	public void populateUnitSpinner() throws Exception
	{
		Unit = DBFetcher.FetchTableData("Unit");
		ObservableList<DataObj> buttons = FXCollections.observableArrayList();
		while(Unit.next())
		{
			buttons.add(new DataObj((String) Unit.getString("Unit_ID").toString(),
					(String) Unit.getString("Unit_Name")));
		}
		UnitSpinner.setItems(buttons);
		Unit = null;
	}
	
	/**
	 * Fills the Weapon comboBoxs by creating DataObj objects from the result sets of all equipment to the combobox
	 * @throws Exception
	 */
	public void populateWeaponSpinners() throws Exception
	{
		Weapon1 = DBFetcher.FetchTableData("Equipment");
		ObservableList<DataObj> buttons = FXCollections.observableArrayList();
		while(Weapon1.next())
		{
			buttons.add(new DataObj((String) Weapon1.getString("Equipment_ID").toString(),
					(String) Weapon1.getString("Equip_Name")));
		}
		WeaponSpinner.setItems(buttons);
		WeaponSpinner2.setItems(buttons);
		Weapon1 = null;
	}
	
	/**
	 * Fills the Esper comboBox by creating DataObj objects from the result sets of all Espers to the combobox
	 * @throws Exception
	 */
	public void populateEsperSpinner() throws Exception
	{
		Esper = DBFetcher.FetchTableData("Esper");
		ObservableList<DataObj> buttons = FXCollections.observableArrayList();
		while(Esper.next())
		{
			buttons.add(new DataObj((String) Esper.getString("Esper_ID").toString(),
					(String) Esper.getString("Esper_Name").toString()));
		}
		EsperSpinner.setItems(buttons);
		Esper = null;
	}
	
	/**
	 * Fills the Chest comboBox by creating DataObj objects from the result sets of all Chests to the combobox
	 * @throws Exception
	 */
	public void populateChestSpinner() throws Exception
	{
		Chest = DBFetcher.FetchTableData("Equipment");
		ObservableList<DataObj> buttons = FXCollections.observableArrayList();
		while(Chest.next())
		{
			if(Chest.getString("Equip_Type").equals("lightArmor") ||
				Chest.getString("Equip_Type").equals("heavyArmor") ||
				Chest.getString("Equip_Type").equals("clothes") )
			{
				buttons.add(new DataObj((String) Chest.getString("Equipment_ID").toString(),
						(String) Chest.getString("Equip_Name")));
			}
		}
		ChestSpinner.setItems(buttons);
		Chest = null;
	}
	
	/**
	 * Fills the Helmet comboBox by creating DataObj objects from the result sets of all Helmets to the combobox
	 * @throws Exception
	 */
	public void populateHelmetSpinner() throws Exception
	{
		Helmet = DBFetcher.FetchTableData("Equipment");
		ObservableList<DataObj> buttons = FXCollections.observableArrayList();
		while(Helmet.next())
		{
			if(Helmet.getString("Equip_Type").equals("helmet") ||
			   Helmet.getString("Equip_Type").equals("hat") )
			{
				buttons.add(new DataObj((String) Helmet.getString("Equipment_ID").toString(),
						(String) Helmet.getString("Equip_Name").toString()));
			}
		}
		HelmetSpinner.setItems(buttons);
		Helmet = null;
	}
	
	/**
	 * Fills the Accessory comboBoxs by creating DataObj objects from the result sets of all Accessories to the comboboxs
	 * @throws Exception
	 */
	public void populateAccSpinners() throws Exception
	{
		Acc1 = DBFetcher.FetchTableData("Equipment");
		ObservableList<DataObj> buttons = FXCollections.observableArrayList();
		while(Acc1.next())
		{
			if(Acc1.getString("Equip_Type").equals("accessory"))
			{
				buttons.add(new DataObj((String) Acc1.getString("Equipment_ID").toString(),
						(String) Acc1.getString("Equip_Name").toString()));
			}
		}
		AccSpinner1.setItems(buttons);
		AccSpinner2.setItems(buttons);
		Acc1 = null;
	}
	
	/**
	 * Fills the Materia comboBoxs by creating DataObj objects from the result sets of all Materia to the comboboxs
	 * @throws Exception
	 */
	public void populateMateriaSpinners() throws Exception
	{
		Materia1 = DBFetcher.FetchTableData("Equipment");
		ObservableList<DataObj> buttons = FXCollections.observableArrayList();
		while(Materia1.next())
		{
			if(Materia1.getString("Equip_Type").equals("materia") )
			{
				buttons.add(new DataObj((String) Materia1.getString("Equipment_Id").toString(),
						(String) Materia1.getString("Equip_Name").toString()));
			}
		}
		MateriaSpinner1.setItems(buttons);
		MateriaSpinner2.setItems(buttons);
		MateriaSpinner3.setItems(buttons);
		MateriaSpinner4.setItems(buttons);
		Materia1 = null;
	}
	
	/**
	 * Sets each Combobox on Select Listener method to perform a specific function
	 * Each Combobox Listener:
	 * 1. Grabs associated query set
	 * 2. Sets the data
	 * 3. calculate stats at the end of its listener
	 */
	private void setEventOnSelectListeners()
	{
		WeaponSpinner.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());
				try {
					Weapon1 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		WeaponSpinner2.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());
				try {
					Weapon2 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		HelmetSpinner.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());	
				try {
					Helmet = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		ChestSpinner.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());		
				try {
					Chest = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		AccSpinner1.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());	
				try {
					Acc1 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		AccSpinner2.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());	
				try {
					Acc2 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		MateriaSpinner1.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());	
				try {
					Materia1 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		MateriaSpinner2.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());	
				try {
					Materia2 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		MateriaSpinner3.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());	
				try {
					Materia3 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		MateriaSpinner4.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());
				try {
					Materia4 = QuearyStats(newValue.getId());
					setEquipData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		EsperSpinner.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());
				try {
					Esper = QuearyStats(newValue.getId());
					setEsperData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
		UnitSpinner.valueProperty().addListener(new ChangeListener<DataObj>() {
			@Override
			public void changed(ObservableValue<? extends DataObj> observable, DataObj oldValue, DataObj newValue) {
				System.out.println(newValue.getId());	
				try {
					Unit = QuearyStats(newValue.getId());
					setUnitData();
					CalculateFinalStats();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
	    });
	}
	
	/**
	 * Grabs the data from an associated ID from the stats table
	 * @param id - Id of the table row looking to obtain
	 * @return - ResultSet of the row's data, if it exists
	 * @throws Exception
	 */
	private ResultSet QuearyStats(String id) throws Exception
	{
		return DBFetcher.FetchTableData(id,"Stats");
	}
	
	/**
	 * Adds up all of the equipments data and displays it to the appropriate textview
	 * Checks if each ResultSet it is pulling from is empty first
	 * @throws SQLException
	 */
	private void setEquipData() throws SQLException
	{
		double hp = 0, hpP = 0, mp = 0, mpP = 0, atk = 0, atkP = 0,
		def = 0, defP = 0, mag = 0, magP = 0, spr = 0, sprP = 0;
		
		if(Weapon1 != null)
		{
			Weapon1.first();
			hp += Weapon1.getDouble("F_HP");
			mp += Weapon1.getDouble("F_MP");
			atk += Weapon1.getDouble("F_atk");
			def += Weapon1.getDouble("F_def");
			mag += Weapon1.getDouble("F_mag");
			spr += Weapon1.getDouble("F_spr");
			hpP += Weapon1.getDouble("P_HP");
			mpP += Weapon1.getDouble("P_MP");
			atkP += Weapon1.getDouble("P_atk");
			magP += Weapon1.getDouble("P_mag");
			defP += Weapon1.getDouble("P_def");
			sprP += Weapon1.getDouble("P_spr");
		}
		if(Weapon2 != null)
		{
			Weapon2.first();
			hp += Weapon2.getDouble("F_HP");
			mp += Weapon2.getDouble("F_MP");
			atk += Weapon2.getDouble("F_atk");
			def += Weapon2.getDouble("F_def");
			mag += Weapon2.getDouble("F_mag");
			spr += Weapon2.getDouble("F_spr");
			hpP += Weapon2.getDouble("P_HP");
			mpP += Weapon2.getDouble("P_MP");
			atkP += Weapon2.getDouble("P_atk");
			magP += Weapon2.getDouble("P_mag");
			defP += Weapon2.getDouble("P_def");
			sprP += Weapon2.getDouble("P_spr");
		}
		if(Helmet != null)
		{
			Helmet.first();
			hp += Helmet.getDouble("F_HP");
			mp += Helmet.getDouble("F_MP");
			atk += Helmet.getDouble("F_atk");
			def += Helmet.getDouble("F_def");
			mag += Helmet.getDouble("F_mag");
			spr += Helmet.getDouble("F_spr");
			hpP += Helmet.getDouble("P_HP");
			mpP += Helmet.getDouble("P_MP");
			atkP += Helmet.getDouble("P_atk");
			magP += Helmet.getDouble("P_mag");
			defP += Helmet.getDouble("P_def");
			sprP += Helmet.getDouble("P_spr");
		}
		if(Chest != null)
		{
			Chest.first();
			hp += Chest.getDouble("F_HP");
			mp += Chest.getDouble("F_MP");
			atk += Chest.getDouble("F_atk");
			def += Chest.getDouble("F_def");
			mag += Chest.getDouble("F_mag");
			spr += Chest.getDouble("F_spr");
			hpP += Chest.getDouble("P_HP");
			mpP += Chest.getDouble("P_MP");
			atkP += Chest.getDouble("P_atk");
			magP += Chest.getDouble("P_mag");
			defP += Chest.getDouble("P_def");
			sprP += Chest.getDouble("P_spr");
		}
		if(Acc1 != null)
		{
			Acc1.first();
			hp += Acc1.getDouble("F_HP");
			mp += Acc1.getDouble("F_MP");
			atk += Acc1.getDouble("F_atk");
			def += Acc1.getDouble("F_def");
			mag += Acc1.getDouble("F_mag");
			spr += Acc1.getDouble("F_spr");
			hpP += Acc1.getDouble("P_HP");
			mpP += Acc1.getDouble("P_MP");
			atkP += Acc1.getDouble("P_atk");
			magP += Acc1.getDouble("P_mag");
			defP += Acc1.getDouble("P_def");
			sprP += Acc1.getDouble("P_spr");
		}
		if(Acc2 != null)
		{
			Acc2.first();
			hp += Acc2.getDouble("F_HP");
			mp += Acc2.getDouble("F_MP");
			atk += Acc2.getDouble("F_atk");
			def += Acc2.getDouble("F_def");
			mag += Acc2.getDouble("F_mag");
			spr += Acc2.getDouble("F_spr");
			hpP += Acc2.getDouble("P_HP");
			mpP += Acc2.getDouble("P_MP");
			atkP += Acc2.getDouble("P_atk");
			magP += Acc2.getDouble("P_mag");
			defP += Acc2.getDouble("P_def");
			sprP += Acc2.getDouble("P_spr");
		}
		if(Materia1 != null)
		{
			Materia1.first();
			hp += Materia1.getDouble("F_HP");
			mp += Materia1.getDouble("F_MP");
			atk += Materia1.getDouble("F_atk");
			def += Materia1.getDouble("F_def");
			mag += Materia1.getDouble("F_mag");
			spr += Materia1.getDouble("F_spr");
			hpP += Materia1.getDouble("P_HP");
			mpP += Materia1.getDouble("P_MP");
			atkP += Materia1.getDouble("P_atk");
			magP += Materia1.getDouble("P_mag");
			defP += Materia1.getDouble("P_def");
			sprP += Materia1.getDouble("P_spr");
		}
		if(Materia2 != null)
		{
			Materia2.first();
			hp += Materia2.getDouble("F_HP");
			mp += Materia2.getDouble("F_MP");
			atk += Materia2.getDouble("F_atk");
			def += Materia2.getDouble("F_def");
			mag += Materia2.getDouble("F_mag");
			spr += Materia2.getDouble("F_spr");
			hpP += Materia2.getDouble("P_HP");
			mpP += Materia2.getDouble("P_MP");
			atkP += Materia2.getDouble("P_atk");
			magP += Materia2.getDouble("P_mag");
			defP += Materia2.getDouble("P_def");
			sprP += Materia2.getDouble("P_spr");
		}
		if(Materia3 != null)
		{
			Materia3.first();
			hp += Materia3.getDouble("F_HP");
			mp += Materia3.getDouble("F_MP");
			atk += Materia3.getDouble("F_atk");
			def += Materia3.getDouble("F_def");
			mag += Materia3.getDouble("F_mag");
			spr += Materia3.getDouble("F_spr");
			hpP += Materia3.getDouble("P_HP");
			mpP += Materia3.getDouble("P_MP");
			atkP += Materia3.getDouble("P_atk");
			magP += Materia3.getDouble("P_mag");
			defP += Materia3.getDouble("P_def");
			sprP += Materia3.getDouble("P_spr");
		}
		if(Materia4 != null)
		{
			Materia4.first();
			hp += Materia4.getDouble("F_HP");
			mp += Materia4.getDouble("F_MP");
			atk += Materia4.getDouble("F_atk");
			def += Materia4.getDouble("F_def");
			mag += Materia4.getDouble("F_mag");
			spr += Materia4.getDouble("F_spr");
			hpP += Materia4.getDouble("P_HP");
			mpP += Materia4.getDouble("P_MP");
			atkP += Materia4.getDouble("P_atk");
			magP += Materia4.getDouble("P_mag");
			defP += Materia4.getDouble("P_def");
			sprP += Materia4.getDouble("P_spr");
		}
		equipHP.setText(Double.toString(hp));
		equipMP.setText(Double.toString(mp));
		equipATK.setText(Double.toString(atk));
		equipDEF.setText(Double.toString(def));
		equipMAG.setText(Double.toString(mag));
		equipSPR.setText(Double.toString(spr));
		equipHPPercent.setText(Double.toString(hpP));
		equipMPPercent.setText(Double.toString(mpP));
		equipATKPercent.setText(Double.toString(atkP));
		equipDEFPercent.setText(Double.toString(defP));
		equipMAGPercent.setText(Double.toString(magP));
		equipSPRPercent.setText(Double.toString(sprP));
	}

	/**
	 * Adds up all of the esper data and displays it to the appropriate textview
	 * Checks if each ResultSet it is pulling from is empty first
	 * @throws SQLException
	 */
	private void setEsperData() throws SQLException
	{
		double hp = 0, mp = 0,atk = 0, def = 0, mag = 0,spr = 0;
		
		if(Esper != null)
		{
			Esper.first();
			hp += Esper.getDouble("F_HP");
			mp += Esper.getDouble("F_MP");
			atk += Esper.getDouble("F_atk");
			def += Esper.getDouble("F_def");
			mag += Esper.getDouble("F_mag");
			spr += Esper.getDouble("F_spr");
		}
		esperHP.setText(Double.toString(hp));
		esperMP.setText(Double.toString(mp));
		esperATK.setText(Double.toString(atk));
		esperDEF.setText(Double.toString(def));
		esperMAG.setText(Double.toString(mag));
		esperSPR.setText(Double.toString(spr));
	}
	
	/**
	 * Adds up all of the Unit's data and displays it to the appropriate textview
	 * Checks if each ResultSet it is pulling from is empty first
	 * @throws SQLException
	 */
	private void setUnitData() throws SQLException
	{
		double hp = 0, hpP = 0, mp = 0, mpP = 0, atk = 0, atkP = 0,
				def = 0, defP = 0, mag = 0, magP = 0, spr = 0, sprP = 0;
		
		if(Unit != null)
		{
			Unit.first();
			hp += Unit.getDouble("F_HP");
			mp += Unit.getDouble("F_MP");
			atk += Unit.getDouble("F_atk");
			def += Unit.getDouble("F_def");
			mag += Unit.getDouble("F_mag");
			spr += Unit.getDouble("F_spr");
			hpP += Unit.getDouble("P_HP");
			mpP += Unit.getDouble("P_MP");
			atkP += Unit.getDouble("P_atk");
			magP += Unit.getDouble("P_mag");
			defP += Unit.getDouble("P_def");
			sprP += Unit.getDouble("P_spr");
		}
		baseHP.setText(Double.toString(hp));
		baseMP.setText(Double.toString(mp));
		baseATK.setText(Double.toString(atk));
		baseDEF.setText(Double.toString(def));
		baseMAG.setText(Double.toString(mag));
		baseSPR.setText(Double.toString(spr));
		baseHPPercent.setText(Double.toString(hpP));
		baseMPPercent.setText(Double.toString(mpP));
		baseATKPercent.setText(Double.toString(atkP));
		baseDEFPercent.setText(Double.toString(defP));
		baseMAGPercent.setText(Double.toString(magP));
		baseSPRPercent.setText(Double.toString(sprP));
	}
	
	/**
	 * Adds all of the textview stats from baseStats, EquipStats, and EsperStats into one.
	 * Performs math operations with the % values.
	 * Displays final Values in their associated textView.
	 */
	private void CalculateFinalStats()
	{
		double FinalHPPercent = (Double.parseDouble(baseHPPercent.getText()) +
				Double.parseDouble(equipHPPercent.getText()));
		double FinalHP = Double.parseDouble(baseHP.getText()) +
				Double.parseDouble(baseHP.getText()) * (FinalHPPercent/100) +
				Double.parseDouble(equipHP.getText()) +
				(Double.parseDouble(esperHP.getText())/100);
		
		double FinalAtkPercent = (Double.parseDouble(baseATKPercent.getText()) +
				Double.parseDouble(equipATKPercent.getText()));
		double FinalAtk = Double.parseDouble(baseATK.getText()) +
				Double.parseDouble(baseATK.getText()) * (FinalAtkPercent/100) +
				Double.parseDouble(equipATK.getText()) +
				(Double.parseDouble(esperATK.getText())/100);
		
		double FinalDefPercent = (Double.parseDouble(baseDEFPercent.getText()) +
				Double.parseDouble(equipDEFPercent.getText()));
		double FinalDef = Double.parseDouble(baseDEF.getText()) +
				Double.parseDouble(baseDEF.getText()) * (FinalDefPercent/100) +
				Double.parseDouble(equipDEF.getText()) +
				(Double.parseDouble(esperDEF.getText())/100);
		
		double FinalMagPercent = (Double.parseDouble(baseMAGPercent.getText()) +
				Double.parseDouble(equipMAGPercent.getText()));
		double FinalMag = Double.parseDouble(baseMAG.getText()) +
				Double.parseDouble(baseMAG.getText()) * (FinalMagPercent/100) +
				Double.parseDouble(equipMAG.getText()) +
				(Double.parseDouble(esperMAG.getText())/100);
		
		double FinalSPRPercent = (Double.parseDouble(baseSPRPercent.getText()) +
				Double.parseDouble(equipSPRPercent.getText()));
		double FinalSpr = Double.parseDouble(baseSPR.getText()) +
				Double.parseDouble(baseSPR.getText()) * (FinalSPRPercent/100) +
				Double.parseDouble(equipSPR.getText()) +
				(Double.parseDouble(esperSPR.getText())/100);
		
		double FinalMPPercent = (Double.parseDouble(baseMPPercent.getText()) +
				Double.parseDouble(equipMPPercent.getText()));
		double FinalMP = Double.parseDouble(baseMP.getText()) +
				Double.parseDouble(baseMP.getText()) * (FinalMPPercent/100) +
				Double.parseDouble(equipMP.getText()) +
				(Double.parseDouble(esperMP.getText())/100);
		
		
		finalHP.setText(Double.toString(FinalHP));
		finalMP.setText(Double.toString(FinalMP));
		finalATK.setText(Double.toString(FinalAtk));
		finalDEF.setText(Double.toString(FinalDef));
		finalSPR.setText(Double.toString(FinalSpr));
		finalMAG.setText(Double.toString(FinalMag));
		finalHPPercent.setText(Double.toString(FinalHPPercent));
		finalMPPercent.setText(Double.toString(FinalMPPercent));
		finalATKPercent.setText(Double.toString(FinalAtkPercent));
		finalDEFPercent.setText(Double.toString(FinalDefPercent));
		finalSPRPercent.setText(Double.toString(FinalSPRPercent));
		finalMAGPercent.setText(Double.toString(FinalMagPercent));
	}
	
	/**
	 * Sets the textView fields to display 0
	 * used to grab 0  for double calculations instead of empty or null
	 */
	private void setFields()
	{
		finalHP.setText("0");
		finalMP.setText("0");
		finalATK.setText("0");
		finalDEF.setText("0");
		finalMAG.setText("0");
		finalSPR.setText("0");
		finalHPPercent.setText("0");
		finalMPPercent.setText("0");
		finalATKPercent.setText("0");
		finalDEFPercent.setText("0");
		finalMAGPercent.setText("0");
		finalSPRPercent.setText("0");
		
		baseHP.setText("0");
		baseMP.setText("0");
		baseATK.setText("0");
		baseDEF.setText("0");
		baseMAG.setText("0");
		baseSPR.setText("0");
		baseHPPercent.setText("0");
		baseMPPercent.setText("0");
		baseATKPercent.setText("0");
		baseDEFPercent.setText("0");
		baseMAGPercent.setText("0");
		baseSPRPercent.setText("0");
		
		equipHP.setText("0");
		equipMP.setText("0");
		equipATK.setText("0");
		equipDEF.setText("0");
		equipMAG.setText("0");
		equipSPR.setText("0");
		equipHPPercent.setText("0");
		equipMPPercent.setText("0");
		equipATKPercent.setText("0");
		equipDEFPercent.setText("0");
		equipMAGPercent.setText("0");
		equipSPRPercent.setText("0");
		
		esperHP.setText("0");
		esperMP.setText("0");
		esperATK.setText("0");
		esperDEF.setText("0");
		esperMAG.setText("0");
		esperSPR.setText("0");
		
	}
}
