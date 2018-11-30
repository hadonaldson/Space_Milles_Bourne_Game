/**
 * The Model class handles all the logic for MilesBornes.
 *
 * @author Michael Donaldson
 * @author Haley Donaldson
 * @version 1.0
 */
 import java.util.Random;
public class Model 
{
	  private int LY25 = 45;
	  private int LY50 = 25;
	  private int LY75 = 15;
	  private int LY100 = 5;
	  private int noFuel = 20;
	  private int brokeThrusters = 20;
	  private int asteroidBelt = 20;
	  private int jammed = 20;
	  private int fuelSupply = 1;
	  private int energyShield = 1;
	  private int aiGunner = 1;
	  private int paperTowels = 1;
	  private int wrench = 20;
	  private int onePlyPaperTowel = 20;
	  private int gasStation = 20;
	  private int laser = 20;
	  private int liftoff = 20;
	  private int turn = 0;
	  private int total = 274;
/**
 * This sets up the array of cards.
 * @param array - This is the card array.
 */
  public void setupCards(String[] images)
  {
	  images[0] = "Images/25LY.png";
	  images[1] = "Images/50LY.png";
	  images[2] = "Images/75LY.png";
	  images[3] = "Images/100LY.png";
	  images[4] = "Images/NoGas.png";
	  images[5] = "Images/BrokenThruster.png";
	  images[6] = "Images/asteroids.png";
	  images[7] = "Images/Jam.png";
	  images[8] = "Images/QuantumFuel.png";
	  images[9] = "Images/Shield.png";
	  images[10] = "Images/AI.png";
	  images[11] = "Images/PaperTowel.png";
	  images[12] = "Images/Wrench.png";
	  images[13] = "Images/OnePlyPaperTowel.png";
	  images[14] = "Images/gasStation.png";
	  images[15] = "Images/laser.png";
	  images[16] = "Images/LiftOff.png";
	  images[17] = "Images/Logo.png";
   }
/**
 * This sets up the array of cards in the player's hand.
 * @param array - This is the hand array.
 */
  public void setupHand(int[] array)
  {
    int num = 0;
    for(int i = 0; i < 5; i++)
    {
      num = findCard();
      array[i] = num;
    }
  }
/**
 * This draws a card.
 * @param int - This is the card number.
 */
  public int findCard()
  {
    Random rand = new Random();
    int result = -1;
    int num = -1;
    while(result == -1)
    {
      num = rand.nextInt(274)+1;
      
      if(num >= 0 && num <= 44)/*--------*/{if(LY25 > 0)/*------------*/{result = 0; LY25--;}}
      else if(num >= 45 && num <= 69)/*--*/{if(LY50 > 0)/*------------*/{result = 1; LY50--;}}
      else if(num >= 70 && num <= 84)/*--*/{if(LY75 > 0)/*------------*/{result = 2; LY75--;}}
      else if(num >= 85 && num <= 89)/*--*/{if(LY100 > 0)/*-----------*/{result = 3; LY100--;}}
      else if(num >= 90 && num <= 109)/*-*/{if(noFuel > 0)/*----------*/{result = 4; noFuel--;}}
      else if(num >= 110 && num <= 129)/**/{if(brokeThrusters > 0)/*--*/{result = 5; brokeThrusters--;}}
      else if(num >= 130 && num <= 149)/**/{if(asteroidBelt > 0)/*----*/{result = 6; asteroidBelt--;}}
      else if(num >= 150 && num <= 169)/**/{if(jammed > 0)/*----------*/{result = 7; jammed--;}}
      else if(num == 170)/*--------------*/{if(fuelSupply > 0)/*------*/{result = 8; fuelSupply--;}}
      else if(num == 171)/*--------------*/{if(energyShield > 0)/*----*/{result = 9; energyShield--;}}
      else if(num == 172)/*--------------*/{if(aiGunner > 0)/*--------*/{result = 10; aiGunner--;}}
      else if(num == 173)/*--------------*/{if(paperTowels > 0)/*-----*/{result = 11; paperTowels--;}}
      else if(num >= 174 && num <= 193)/**/{if(wrench > 0)/*----------*/{result = 12; wrench--;}}
      else if(num >= 194 && num <= 213)/**/{if(onePlyPaperTowel > 0)/**/{result = 13; onePlyPaperTowel--;}}
      else if(num >= 214 && num <= 233)/**/{if(gasStation > 0)/*------*/{result = 14; gasStation--;}}
      else if(num >= 234 && num <= 253)/**/{if(laser > 0)/*-----------*/{result = 15; laser--;}}
      else if(num >= 254 && num <= 273)/**/{if(liftoff > 0)/*---------*/{result = 16; liftoff--;}}
    }
    total--;
    return result;
  }
/**
 * This method returns the turn int.
 * @return - int turn.
 */
  public int getTurn()
  {
	  return turn;
  }
/**
 * This method increments turn by 1.
 */
  public void addTurn()
  {
	  turn++;
  }
/**
 * This method returns the toal number of cards.
 * @return - The total number of cards.
 */
  public int getTotal()
  {
	  return total;
  }
}