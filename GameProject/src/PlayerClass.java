import java.util.*;
import java.io.*;

public class PlayerClass implements Serializable{

	private String name;
	private String characterClass;
	private int lvl;
	private int xpToNextLvl;
	private int maxHealth;
	private int health;
	private int currency;
	private int attack;
	private int defense;
	private int evasion;
	
	private String[] inventory = new String[10];
	
	PlayerClass(String initName, int initLevel, int initCurrency, String initClass)
	{
		name = initName;
		characterClass = initClass ;
		lvl = initLevel;
		currency = initCurrency;
		maxHealth = lvl * 100 / 2;
		health = maxHealth;
		xpToNextLvl = lvl * 500 / 2;
		attack = lvl * 10 / 2;
		defense = lvl * 5 / 2;
		evasion = lvl * 8 / 2;
		
		for(int i = 0; i < inventory.length; i++)
		{
			inventory[i] = "empty";
		}
	}
	
	//Accessors
	public String getName()
	{
		return name;
	}
	public int getLvl()
	{
		return lvl;
	}
	public int getCurrency()
	{
		return currency;
	}
	public int getHealth()
	{
		return health;
	}
	public int getMaxHealth()
	{
		return maxHealth;
	}
	public int getXp()
	{
		return xpToNextLvl;
	}
	public int getAttack()
	{
		return attack;
	}
	public int getDefense()
	{
		return defense;
	}
	public int getEvasion()
	{
		return evasion;
	}
	public String getCharacterClass()
	{
		return characterClass;
	}
	public String[] getInventory()
	{
		return inventory;
	}
	
	//Mutators
	public void setXp(int newXp)
	{
		xpToNextLvl = newXp;
	}
	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
	public void setMaxHealth(int newMaxHealth)
	{
		maxHealth = newMaxHealth;
	}
	public void setCurrency(int newCurrency)
	{
		currency = newCurrency;
	}
	public void setName(String initName)
	{
		name = initName;
	}
	public void setAttack(int initAttack)
	{
		attack += initAttack;
	}
	public void setDefense(int initDefense)
	{
		defense += initDefense;
	}
	public void setEvasion(int initEvasion)
	{
		evasion += initEvasion;
	}
	public void setCharacterClass(int initClass)
	{
		switch(initClass)
		{
		case 1:
			characterClass = "Warrior";
			defense = lvl * 8/2;
			break;
		case 2:
			characterClass = "Mage";
			attack = lvl * 12 / 2;
			break;
		case 3:
			characterClass = "Rogue";
			evasion = lvl * 10 / 2;
			break;
		}
	}
	
	public void displayPlayer()
	{
		System.out.println("************************************************************************************************************");
		System.out.println("Name = " + name);
		System.out.println("Class = " + characterClass);
		System.out.println("Level = " + lvl);
		System.out.println("XP to next lvl = "+ xpToNextLvl);
		System.out.println("Gold = " + currency);
		System.out.println("Health = " + health + "/" + maxHealth);
		System.out.println("Attack = " + attack);
		System.out.println("Defense = " + defense);
		System.out.println("Evasion = " + evasion );
		System.out.println("************************************************************************************************************");
		
	}
	
	public void displayInventory()
	{
		System.out.println("\nInventory:\n ");
		
		for(int i = 0; i < inventory.length; i++)
		{
			System.out.println("\t" + (i + 1) + ". " + inventory[i]);
		}
	}
	
	public void lvlUp()
	{
		lvl +=  1;
		maxHealth = lvl * 100 / 2;
		health = maxHealth;
		xpToNextLvl = lvl * 500 / 2;
		attack = lvl * 10 / 2;
		defense = lvl * 9 / 2;
		evasion = lvl * 8 / 2;
	}
	
	public void addItem(String item)
	{ 
		boolean itemAdded = false;
		
		int i = 0;
		do
		{
			if(inventory[i].equalsIgnoreCase("empty"))
			{
				inventory[i] = item;
				itemAdded = true;
			}
			if(!inventory[9].equalsIgnoreCase("empty"))
				System.out.println("Your Inventory is full!");
			
			i++;
			
		}while(!itemAdded);	
	}
	
	public void deleteItem(int itemNumber)
	{
			inventory[itemNumber - 1] = "empty";
	}
	
	
}
