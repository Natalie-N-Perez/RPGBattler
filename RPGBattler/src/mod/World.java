package mod;

import java.util.Random;

import cont.JOP;

public class World {

	//Declaring and initializing variables needed to properly execute the code
	private int i = 0;
	private int a = 0;
    int cmax = 3;
    int cmin = 1;
    int h = 0;
    int damage = 1;
    int randomInt = (int) (Math.random() * (cmax - cmin + 1) + cmin);
    int phealth;
    int chealth;
    int health;
    int critmax = 5;
    int critmin = 0;
    int crit = (int) (Math.random() * (critmax - critmin + 1) + critmin);
    boolean running = true;
    int sa = 0;
    
    
    Random rand = new Random();

	public World() {
		//Displays the intro message and initializes player health, computer health, and max health
		JOP.msg("Type in exit if you ever want to leave.");
		health = 2;
		chealth = health;
		phealth = health;
	
		//Sets up the infinite loop to play the game 
	while(running = true) {
		String response = JOP.in("Rock, paper, or scissors?\nTo use the special attack when charged type SA\n\nPlayer Health: " + phealth +"/" + health +"             CPU Health: " + chealth +"/" + health + "\n\nSpecial attack charged at " + sa + "/4");
		getPlayerMove(response);
		getComputerMove();
		win();
		check();
	}
	}
		
	//check method checks if either the computer of player has run out of health
	//Resets the player health, computer health, max health, and special move charge up accordingly
	private boolean check() {
		if(phealth <= 0) {
			JOP.msg("Level Lost.\nTry Again.");
			phealth = health;
			chealth = health;
			sa = 0;
			return true;
		}
		if(chealth <= 0) {
			JOP.msg("Level Won.\nGoing on to the next Level.");
			health = health * 2;
			phealth = health;
			chealth = health;
			sa = 0;
			return true;
		}
		return false;
	}
	
	//win method checks if either the computer or player has won a turn
	//Also checks whether or not a critical hit landed or if a special attack was used
	//Checks if the player lost that turn and charges up the special attack meter if they were
	//Correctly calculates the player and computer health after each turn
    private boolean win() {

    if(a == 4)
    {
    	chealth = chealth - (damage * 3);
    	sa = 0;
    	a = 0;
    	JOP.msg("You used your special attack\n\nKamehameha.");
    	return true;
    }
    	
    if(a == 3 && i == 3)
    {
    	JOP.msg("There was a tie");
    	a = 0;
    	return true;
    }
    else if (a == 3 && i == 1)
    {
    	if(getCrit() == 3 )
    	{
    		chealth = chealth - (damage * 2);
    		JOP.msg("You landed a crit");
    	}
    	else
    	{
    	chealth = chealth - damage;
    	}
    	a = 0;
           return true;
    }
    else if (a == 3 && i == 2)
    {
    	if(getCrit() == 3 )
    	{
    		phealth = phealth - (damage * 2);
    		JOP.msg("You got hit with a crit");
    	}
    	else
    	{
    	phealth = phealth - damage;
    	}
    	if(sa<4)
    	{
    	sa++;
    	}
    	a = 0;
        return true;
    }
            if(a == 2 && i == 2)
            {
            	JOP.msg("There was a tie");
            	a = 0;
            	return true;
            }
            else if (a == 2 && i == 3)
            {
            	if(getCrit() == 3 )
            	{
            		chealth = chealth - (damage * 2);
            		JOP.msg("You landed a crit");
            	}
            	else
            	{
            	chealth = chealth - damage;
            	}
            	a = 0;
                   return true;
            }
            else if (a == 2 && i == 1)
            {
            	if(getCrit() == 3 )
            	{
            		phealth = phealth - (damage * 2);
            		JOP.msg("You got hit with a crit");
            	}
            	else
            	{
            	phealth = phealth - damage;
            	}
            	if(sa<4)
            	{
            	sa++;
            	}
            	a = 0;
                return true;
            }
                    if(a == 1 && i == 1)
                    {
                    	JOP.msg("There was a tie");
                    	a = 0;
                    	return true;
                    }
                    else if (a == 1 && i == 2)
                    {
                    	if(getCrit() == 3 )
                    	{
                    		chealth = chealth - (damage * 2);
                    		JOP.msg("You landed a crit");
                    	}
                    	else
                    	{
                    	chealth = chealth - damage;
                    	}
                    	a = 0;
                       return true;
                    }
                    else if (a == 1 && i == 3)
                    {
                    	if(getCrit() == 3 )
                    	{
                    		phealth = phealth - (damage * 2);
                    		JOP.msg("You got hit with a crit");
                    	}
                    	else
                    	{
                    	phealth = phealth - damage;
                    	}
                    	if(sa<4)
                    	{
                    	sa++;
                    	}
                    	a = 0;
                    	return true;
                  }
					return false;
                }
    
    

    //Calculates the computer's move for that turn and resets the random integers value after each turn
    private void getComputerMove(){
		if(randomInt == 1)
		{
			i = 1;
		}
		if(randomInt == 2)
		{
			i = 2;
		}
		if(randomInt == 3)
		{
			i = 3;
		}
		randomInt = (int) (Math.random() * (cmax - cmin + 1) + cmin);
       }

    
    //Gets a critical hit's value so that the win method can check if the value equals/lands a critical hit
    private int getCrit(){
    	crit = (int) (Math.random() * (critmax - critmin + 1) + critmin);
    	return crit;
       }
    
    
    
    //Gets the player's move for that turn, setting the variable a to an integer 1 through 4 so that the win method can calculate the round's winner
   private boolean getPlayerMove(String s) {

	 if(s.equalsIgnoreCase("sa")&& sa == 4) {
		 a = 4;
		 return true;
		 } 
 		
     if (s.equalsIgnoreCase("scissors")){
      	a = 1;
     	return true;
     }
     if (s.equalsIgnoreCase("paper")) {
      	a = 2;
        return true;
     }
     if (s.equalsIgnoreCase("rock")) {
        a = 3;
        return true;
     }
     if (s.equalsIgnoreCase("exit")) {
    	System.exit(0);
        return true;
        }
	return false; 		
    }
}