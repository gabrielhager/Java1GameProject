
public class GearClass {
	
	private String itemName;
	private String itemType;
	private int bonusHealth;
	private int bonusAttack;
	private int bonusDefense;
	private int bonusEvasion;
	
	GearClass(String initName, String initType)
	{
		itemName = initName;
		itemType = initType ;
		bonusHealth = 0;
		bonusAttack = 0;
		bonusDefense = 0;
		bonusEvasion = 0;
	}
	//Accessors
		public String getName()
		{
			return itemName;
		}
		public String getType()
		{
			return itemType;
		}
		public int getBonusHealth()
		{
			return bonusHealth;
		}	
		public int getBonusAttack()
		{
			return bonusAttack;
		}
		public int getBonusDefense()
		{
			return bonusDefense;
		}
		public int getBonusEvasion()
		{
			return bonusEvasion;
		}
	
		
		//Mutators
		public void setBonusHealth(int newBonus)
		{
			bonusHealth = newBonus;
		}
		public void setBonusDefense(int newBonus)
		{
			bonusDefense = newBonus;
		}
		public void setBonusAttack(int newBonus)
		{
			bonusAttack = newBonus;
		}
		public void setBonusEvasion(int newBonus)
		{
			bonusEvasion = newBonus;	
		}
		
		public void displayGear()
		{
			System.out.println(itemName);
			System.out.println("Item Type : " + itemType);
			System.out.println("Health : +" + bonusHealth);
			System.out.println("Attack = +" + bonusAttack);
			System.out.println("Defense = +" + bonusDefense);
			System.out.println("Evasion = +" + bonusEvasion );
		}


}
