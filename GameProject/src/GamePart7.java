import java.util.*;
import java.io.*;

public class GamePart7 {

	public static void main(String[] args)
	{
		//*******************************
		//Members
		//*******************************
		int menuOption, playerOption, shopOption, buyOption;
		boolean gameRunning;
		boolean itemsEquipped = false;
		String playerName = "Link";
		Scanner keyboard = new Scanner(System.in);
		PlayerClass playerObject = new PlayerClass("Link", 1, 100, "Warrior");
						
		gameRunning = true;
		
		displayGameTitle();
		
		//*******************************
		//Game Cycle
		//*******************************
		do
			{
				System.out.println("************************************************************************************************************"
						+ "\n\t\t\t\t\t ___________________________"
						+ "\n\t\t\t\t\t|\t1. Start Game\t    |" 
						+ "\n\t\t\t\t\t|\t2. Load Game\t    |" 
						+ "\n\t\t\t\t\t|\t3. Quit Game\t    |"
						+ "\n\t\t\t\t\t|___________________________|");
				menuOption = keyboard.nextInt();
			
				switch(menuOption)
				{
				case 1:
					System.out.println("\n************************************************************************************************************\n" 
						+ "\tThe game has started.\n"
						+ "************************************************************************************************************\n"
						+ "\t\t\t\t\t1. Create New Character\n"
						+ "\t\t\t\t\t0. Return To Menu");
						playerOption = keyboard.nextInt();
						
						while(playerOption !=0)
						{
							if (playerOption == 1)
							{
								System.out.println("************************************************************************************************************\n"
										+ "\tEnter your character's name:\n"
										+ "************************************************************************************************************");
								playerName = keyboard.next();
								System.out.println("\n");
								
								playerObject.setName(playerName);
								
								System.out.println("************************************************************************************************************\n"
										+ playerName + " pick a class:"
										+ "\n************************************************************************************************************"
										+ "\n\t\t\t\t\t _______________________"
										+ "\n\t\t\t\t\t|\t1. Warrior\t|"
										+ "\n\t\t\t\t\t|\t2. Mage  \t|"
										+ "\n\t\t\t\t\t|\t3. Rouge\t|"
										+ "\n\t\t\t\t\t|_______________________|");
								
								int classChoice = keyboard.nextInt();
								playerObject.setCharacterClass(classChoice);
							}	
								
								System.out.println("************************************************************************************************************"
										+ "\n************************************************************************************************************"
										+ "\n\tWelcome " + playerName + ", Adventure Awaits!"
												+ "\n************************************************************************************************************"
												+ "\n************************************************************************************************************");
								runGame(playerObject.getName(), playerObject.getLvl(), playerObject.getCurrency(), playerObject.getCharacterClass());
						}
					break;
				case 2:
					
					PlayerClass playerFileObject = null;
					ObjectInputStream objectIn = null;
					
					try
					{
						objectIn = new ObjectInputStream(new FileInputStream("game.save"));
						
						playerFileObject = (PlayerClass)objectIn.readObject();
						
						objectIn.close();
						
						playerFileObject.displayPlayer();
						
						System.out.println("\n\tWelcome back " + playerFileObject.getName() + "!");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
					runGame(playerFileObject.getName(), playerFileObject.getLvl(), playerFileObject.getCurrency(), playerFileObject.getCharacterClass());
					break;
				case 3:
					System.out.println("************************************************************************************************************"
							+ "\n************************************************************************************************************\n"
						+ "\t\t\t\t\tThanks for playing!\n"
						+ "************************************************************************************************************"
						+ "\n************************************************************************************************************\n");
					gameRunning = false;
					break;
					default:
					System.out.println("************************************************************************************************************\n"
							+ "You must choose 1, 2, or 3.");
				}
				
			}
			while (menuOption != 3);
		
  
		System.exit(0);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////RUN GAME //////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
	
private static void runGame(String name, int lvl, int currency, String characterClass)
{
int menuOption, playerOption, shopOption, buyOption;
boolean gameRunning;
boolean itemsEquipped = false;
String playerName = "Default";
Scanner keyboard = new Scanner(System.in);
PlayerClass playerObject = new PlayerClass(name, lvl, currency, characterClass);

gameRunning = true;
// game menu
do						
{
System.out.println("\n\t\t\t\t\t1. Safe Haven"
+ "\n\t\t\t\t\t2. Novice Zone"
+ "\n\t\t\t\t\t3. Intermediate Zone"
+ "\n\t\t\t\t\t4. Advanced Zone"
+ "\n\t\t\t\t\t5. Player Menu"
+ "\n\t\t\t\t\t6. Exit Game");

playerOption = keyboard.nextInt();

switch (playerOption)
{
case 1:
System.out.println("************************************************************************************************************\n"
	+ "\tWelcome to Safe Haven"
	+ "\n************************************************************************************************************");

do
{
System.out.println("\n\t\t\t\t\t1. Buy"
		+ "\n\t\t\t\t\t2. Sell"
		+ "\n\t\t\t\t\t0. Exit");

shopOption = keyboard.nextInt();

switch(shopOption)
{
	case 1:
		//if (itemsEquipped == false)
		{
				System.out.println("\n\t\t\t\t\t1. Weapon [50 GP]"
						+ "\n\t\t\t\t\t2. Armor [50 GP]"
						+ "\n\t\t\t\t\t3. Off Hand [70 GP]"
						+ "\n\t\t\t\t\t4. Trinket [70 GP]"
						+ "\n\t\t\t\t\t5. Potion [20 GP]"
						+ "\n\t\t\t\t\t0. Exit");
				buyOption = keyboard.nextInt();
				
				switch(buyOption)
				{
					case 1:
						if(playerObject.getCurrency() >= 50)
						{
						GearClass weaponObject = new GearClass("Sword", "Weapon");
						int weaponBonus = 1;
						weaponObject.setBonusAttack(weaponBonus);
						playerObject.setAttack(weaponBonus);
						playerObject.addItem(weaponObject.getName());
						weaponObject.displayGear();	
		
						itemsEquipped = true;
						
						System.out.println("That cost you 50 gold.");
						playerObject.setCurrency(playerObject.getCurrency() - 50);
						}
						else
							System.out.println("You cannot afford a weapon at this time.");
						break;
					case 2:
						if(playerObject.getCurrency() >= 50)
						{
						GearClass armorObject = new GearClass("Mail", "Armor");
						int armorBonus = 1;
						armorObject.setBonusDefense(armorBonus);
						playerObject.setDefense(armorBonus);
						playerObject.addItem(armorObject.getName());
						armorObject.displayGear();	
		
						itemsEquipped = true;
						
						System.out.println("That cost you 50 gold.");
						playerObject.setCurrency(playerObject.getCurrency() - 50);
						}
						else System.out.println("You cannot afford a weapon at this time.");
						break;
					case 3:
						if(playerObject.getCurrency() >= 70)
						{
						GearClass offHandObject = new GearClass("Focus", "Off Hand");
						int offHandBonus = 1;
						offHandObject.setBonusEvasion(offHandBonus);
						playerObject.setEvasion(offHandBonus);
						playerObject.addItem(offHandObject.getName());
						offHandObject.displayGear();	
		
						itemsEquipped = true;
						
						System.out.println("That cost you 70 gold.");
						playerObject.setCurrency(playerObject.getCurrency() - 70);
						}
						else System.out.println("You cannot afford a weapon at this time.");
						break;
					case 4:
						if(playerObject.getCurrency() >= 70)
						{
						GearClass trinketObject = new GearClass("Amulet", "Trinket");
						int healthBonus = 10;
						trinketObject.setBonusHealth(healthBonus);
						playerObject.setMaxHealth(playerObject.getMaxHealth() + healthBonus);
						playerObject.setHealth(playerObject.getMaxHealth());
						playerObject.addItem(trinketObject.getName());
						trinketObject.displayGear();	
		
						itemsEquipped = true;
						
						System.out.println("That cost you 70 gold.");
						playerObject.setCurrency(playerObject.getCurrency() - 70);
						}
						else System.out.println("You cannot afford a weapon at this time.");
						break;
					case 5:
						if(playerObject.getCurrency() >= 20)
						{
						playerObject.addItem("Potion");
							
		
						itemsEquipped = true;
						
						System.out.println("That cost you 20 gold.");
						playerObject.setCurrency(playerObject.getCurrency() - 20);
						}
						else System.out.println("You cannot afford a weapon at this time.");
				}
			
		}
		break;
	case 2:
		System.out.println("You have nothing to sell.");
		break;
}
}while(shopOption != 0);


break;
case 2:
System.out.println("************************************************************************************************************"
	+ "\n\tWelcome to Novice Zone"
	+ "\n************************************************************************************************************");

Random enemyGen = new Random();
int enemyNum = enemyGen.nextInt(3) + 1;

// Temp Variables for Enemy
String enemyName = "";
int enemyLvl = 0;
String enemyClass = "";

// RNG to decide which enemy to face
switch(enemyNum)
{
case 1:
	enemyName = "Wild Squirrel";
	enemyLvl = 1;
	enemyClass = "Thief";
	System.out.println("An enemy " + enemyName + " is in this area!\n");
			
	break;
case 2:
	enemyName = "Ravenous Cayote";
	enemyLvl = 2;
	enemyClass = "Necromancer";
	System.out.println("An enemy " + enemyName + " is in this area!\n");
	break;
case 3:
	enemyName = "Goblin";
	enemyLvl = 3;
	enemyClass = "Bruiser";
	System.out.println("An enemy " + enemyName + " is in this area!\n");
			
	break;
	default: System.out.println("Something is wrong");
}

EnemyClass enemyObject1 = new EnemyClass(enemyName, enemyLvl, enemyClass);
enemyObject1.displayEnemy();

battle(playerObject, enemyObject1);

break;
case 3:
System.out.println("************************************************************************************************************"
	+ "\n\tWelcome to Intermediate Zone"
	+ "\n************************************************************************************************************");
// Same as the Novice Zone above ^^^
enemyName = "";
enemyLvl = 0;
enemyClass = "";

Random enemyGen2 = new Random();
enemyNum = enemyGen2.nextInt(3) + 1;

switch(enemyNum)
{
case 1:
	enemyName = "Kobold";
	enemyLvl = 4;
	enemyClass = "Thief";
	System.out.println("An enemy " + enemyName + " is in this area!\n");
			
	break;
case 2:
	enemyName = "Orc";
	enemyLvl = 5;
	enemyClass = "Necromancer";
	System.out.println("An enemy " + enemyName + " is in this area!\n");
	break;
case 3:
	enemyName = "Hobgoblin";
	enemyLvl = 6;
	enemyClass = "Bruiser";
	System.out.println("An enemy " + enemyName + " is in this area!\n");
			
	break;
	default: System.out.println("Something is wrong");
}

EnemyClass enemyObject2 = new EnemyClass(enemyName, enemyLvl, enemyClass);
enemyObject2.displayEnemy();

battle(playerObject, enemyObject2);
break;
case 4:
System.out.println("************************************************************************************************************"
	+ "\n\tWelcome to Advanced Zone"
	+ "\n************************************************************************************************************");
System.out.println("Do you wish to face the Dragon? (Final Boss)"
	+ "\n\t\t\t\t\t1. Yes"
	+ "\n\t\t\t\t\t2. No");
int bossOption = keyboard.nextInt();
switch(bossOption)
{
case 1:

	enemyName = "Dragon";
	enemyLvl = 10;
	enemyClass = "Bruiser";
	System.out.println("You have entered the Dragon's Lair, prepare to die!");

	EnemyClass bossObject = new EnemyClass(enemyName, enemyLvl, enemyClass);
	bossObject.displayEnemy();

	battle(playerObject, bossObject);
	
	if(bossObject.getHealth() <= 0)
		System.out.println("************************************************************************************************************"
				+ "\n\tCONGRATULATIONS YOU HAVE DEFEATED THE DRAGON!!!"
				+ "\n************************************************************************************************************");

	break;
case 2:


	// Same as the Novice Zone above ^^^
	enemyName = "";
	enemyLvl = 0;
	enemyClass = "";

	Random enemyGen3 = new Random();
	enemyNum = enemyGen3.nextInt(3) + 1;

	switch(enemyNum)
	{
		case 1:
			enemyName = "Assasin";
			enemyLvl = 7;
			enemyClass = "Thief";
			System.out.println("An enemy " + enemyName + " is in this area!\n");
			
			break;
		case 2:
			enemyName = "Warlock";
			enemyLvl = 8;
			enemyClass = "Necromancer";
			System.out.println("An enemy " + enemyName + " is in this area!\n");
			break;
		case 3:
			enemyName = "Dragon Guard";
			enemyLvl = 9;
			enemyClass = "Bruiser";
			System.out.println("An enemy " + enemyName + " is in this area!\n");
			
			break;
		default: System.out.println("Something is wrong");
	}
	EnemyClass enemyObject3 = new EnemyClass(enemyName, enemyLvl, enemyClass);
	enemyObject3.displayEnemy();
	
	battle(playerObject, enemyObject3);
	break;
}



break;
case 5:
playerObject.displayPlayer();
playerObject.displayInventory();
int deleteItemOption;
do
{
System.out.println("\n\t\t\t\t\t1. Delete Item"
		+ "\n\t\t\t\t\t0. Return to Main Menu");

deleteItemOption = keyboard.nextInt();

switch (deleteItemOption)
{

case 1:
	int itemDeleted;
	System.out.println("Please type the item number you wish to be deleted");
	itemDeleted = keyboard.nextInt();
	playerObject.deleteItem(itemDeleted);
	System.out.println("Item deleted.");
	playerObject.displayInventory();
	break;
}
}while(deleteItemOption != 0);

break;
case 6:

PlayerClass saveGame = new PlayerClass(playerObject.getName(), playerObject.getLvl(), playerObject.getCurrency(), playerObject.getCharacterClass());
ObjectOutputStream objectOut = null;

try
{
objectOut = new ObjectOutputStream(new FileOutputStream("game.save"));

objectOut.writeObject(saveGame);
objectOut.close();

System.out.println("\n\tYour game has saved successfully.\n");
}
catch(Exception e)
{
System.out.println(e);
}




System.out.println("************************************************************************************************************"
	+ "\n************************************************************************************************************\n"
	+ "\t\t\t\t\tThanks for playing!\n"
	+ "************************************************************************************************************"
	+ "\n************************************************************************************************************\n");
gameRunning = false;
menuOption = 3;
System.exit(0);
break;
default:
	System.out.println("Invalid entry, please try again.");
	playerOption = keyboard.nextInt();

}
}while (gameRunning);
}
	
	///////////////////////////////////////////////////////////////////
	// BATTLE
	///////////////////////////////////////////////////////////////////
	
	private static void battle(PlayerClass player, EnemyClass enemy)
	{
		int combatChoice = 0;
		boolean runAway = false;
		
		Scanner keyboard = new Scanner(System.in);
		Random rng = new Random();
		
		
		
		System.out.println("************************************************************************************************************"
				+ "\n\tThe battle begins!\n"
				+ "************************************************************************************************************\n");
		
		// Battle Menu
		while(player.getHealth() > 0 && enemy.getHealth() > 0 && runAway == false)
		{
			int damage = player.getAttack() - enemy.getDefense() +( rng.nextInt(player.getAttack()) + 1) ;
			int enemyEvade = 0;
			int playerEvade = 0;
			System.out.println("\n\t\t\t\t\t _______________________");
			System.out.println("\t\t\t\t\t|\t1. Attack\t|");
			System.out.println("\t\t\t\t\t|\t2. Heal\t\t|");
			System.out.println("\t\t\t\t\t|\t3. Escape\t|"
					+ "\n\t\t\t\t\t|_______________________|");
			combatChoice = keyboard.nextInt();
			
			switch(combatChoice)
			{
				case 1:
					enemyEvade = rng.nextInt(100) + 1;
					if(enemyEvade <= enemy.getEvasion())
						System.out.println("The " + enemy.getName() + " evaded your attack!");
					else{
							if(damage > 0)
								enemy.setHealth(enemy.getHealth() -  damage);
							else
								damage = 0;
							System.out.println( player.getName() + "'s DMG: " + damage);
						}
				break;
				case 2:
					if(player.getHealth() <= player.getMaxHealth())
					{
						player.setHealth(player.getHealth() + player.getMaxHealth() / 5);
						if (player.getHealth() > player.getMaxHealth())
							player.setHealth(player.getMaxHealth());
						System.out.println("You heal for " + (player.getMaxHealth() / 5) );
					}
					else
						System.out.println("You are at max health.");
				break;
				case 3:
					
					int escapeChance = rng.nextInt(2) + 1;
					if(escapeChance % 2 == 0)
					{	
						System.out.println("You escaped!!");
						runAway = true;
					}
					else
						System.out.println("You did not escape!");
				break;
			}
			// Enemy Attack
		    damage = enemy.getAttack() - player.getDefense() +( rng.nextInt(enemy.getAttack()) + 1) ;
		    
			playerEvade = rng.nextInt(100) + 1;
			if(playerEvade <= enemy.getEvasion())
				System.out.println("You evaded the " + enemy.getName() + "'s attack!");
			else{
					if(damage > 0)
						player.setHealth(player.getHealth() -  damage);
					else
						damage = 0;
					System.out.println(enemy.getName() + "'s DMG: " + damage);
				}
			
			System.out.println(player.getName()+ "'s HP: " + player.getHealth() + "/" + player.getMaxHealth());
			System.out.println(enemy.getName() + "'s HP: " + enemy.getHealth());
		}
		//Defeat
		if(player.getHealth() <= 0)
		{
			System.out.println("************************************************************************************************************\n"
					+ "DEFEAT.\n"
					+ "************************************************************************************************************\n");
			int lostXp = player.getLvl() * 50;
			player.setXp(player.getXp() + lostXp);
		}
		
		// Victory / Lvl up
		if (enemy.getHealth() <= 0)
		{
			System.out.println("************************************************************************************************************\n"
					+ "VICTORY!\n"
					+ "************************************************************************************************************\n");
			int loot = rng.nextInt(80) + 21;
			player.setCurrency(player.getCurrency() + loot);
			
			int xp = enemy.getLvl() * 100;
			player.setXp(player.getXp() - xp);
			if(player.getXp() <= 0)
			{
				player.lvlUp();
				System.out.println("LEVEL UP!!!!");
				player.displayPlayer();
			}
		}
		//Restore player to full health
		player.setHealth(player.getMaxHealth());
	}
	
	private static void displayGameTitle()
	{
		System.out.println( "************************************************************************************************************\n"
				+ "************************************************************************************************************\n"
				+"************************************************************************************************************");
		System.out.println("   _____       .___                    __                            _____                 .__  __          ");
		System.out.println("  /  _  \\    __| _/__  __ ____   _____/  |_ __ _________   ____     /  _  \\__  _  _______  |__|/  |_  ______");
		System.out.println(" /  /_\\  \\  / __ |\\  \\/ // __ \\ /    \\   __\\  |  \\_  __ \\_/ __ \\   /  /_\\  \\ \\/ \\/ /\\__  \\ |  \\   __\\/  ___/");
		System.out.println("/    |    \\/ /_/ | \\   /\\  ___/|   |  \\  | |  |  /|  | \\/\\  ___/  /    |    \\     /  / __ \\|  ||  |  \\___ \\ ");
		System.out.println("\\____|__  /\\____ |  \\_/  \\___  >___|  /__| |____/ |__|    \\___  > \\____|__  /\\/\\_/  (____  /__||__| /____  >");
		System.out.println("        \\/      \\/           \\/     \\/                        \\/          \\/             \\/              \\/ ");
		System.out.println("************************************************************************************************************\n"
				+"************************************************************************************************************");
	}
	
	
	
	
	
	
}