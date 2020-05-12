
import java.util.*;

public class EnemyClass {
	
	private String name;
	private String enemyType;
	private int lvl;
	private int health;
	private int loot;
	private int attack;
	private int defense;
	private int evasion;
	
	EnemyClass(String initName, int initLevel, String initClass)
	{
		name = initName;
		enemyType = initClass ;
		lvl = initLevel;
		loot = 0;
		health = lvl * 100 / 2;
		attack = lvl * 10 / 2;
		defense = lvl * 5 / 2;
		evasion = lvl * 8 / 2;
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
			return loot;
		}
		public int getHealth()
		{
			return health;
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
			return enemyType;
		}
		
		//Mutators
		public void setHealth(int newHealth)
		{
			health = newHealth;
		}
		public void setCurrency(int newCurrency)
		{
			loot = newCurrency;
		}
		public void setName(String initName)
		{
			name = initName;
		}
		public void setCharacterClass(int initClass)
		{
			switch(initClass)
			{
			case 1:
				enemyType = "Bruiser";
				defense = lvl * 8/2;
				break;
			case 2:
				enemyType = "Necromancer";
				attack = lvl * 12 / 2;
				break;
			case 3:
				enemyType = "Thief";
				evasion = lvl * 10 / 2;
				break;
			}
		}
		
		public void displayEnemy()
		{
			System.out.println("\tName = " + name);
			System.out.println("\tClass = " + enemyType);
			System.out.println("\tLevel = " + lvl);
			System.out.println("\tHealth = " + health);
			System.out.println("\tAttack = " + attack);
			System.out.println("\tDefense = " + defense);
			System.out.println("\tEvasion = " + evasion );
		}

}
