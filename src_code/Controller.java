import java.util.Random;

/**
 * The Controller class manages MilesBornes.
 *
 * @author Michael Donaldson
 * @author Haley Donaldson
 * @version 1.0
 */
public class Controller
{	
  private Model m;
  private View viewObj;
  private String[] images = new String[18];
  private int[] playerHand = new int[6];
  private int[] aiHand = new int[6];
  private int playerLY = 0;
  private int aiLY = 0;
/**
* This method calls the view and creates the array of cards.
*/
  public void start()
  {
	m = new Model();
    viewObj = new View(this);
    m.setupCards(images);
    m.setupHand(playerHand);
    m.setupHand(aiHand);
    playerHand[5] = 17;
    aiHand[5] = 17;
    viewObj.changeButtons(playerHand, images);
    viewObj.setLY(playerLY, aiLY);
    viewObj.needLiftOff();
    viewObj.setAIButtons(images[17]);
    viewObj.disableNotDraw();
  }
/**
* This method manages which methods call on the player's turn.
*/
  public void playerGo(int num)
  {
    int card = playerHand[num];
    playerPlay(card);
    viewObj.setLY(playerLY, aiLY);
    viewObj.disableNotEnd();
  }
/**
* This manages which methods call on the ai's turn.
*/
  public void aiGo()
  {  
	  	viewObj.disableAllCards();
	  	draw();

	  	//Not Lifted off
	  	if(viewObj.getAILiftOff() == false)
	  	{
	  		aiNotLiftedPlay();
	  	}
	  	//stopped
	  	else if(viewObj.getAIStopped() > 0)
	  	{
	  		aiStoppedPlay();
	  	}
	  	//losing
	  	else if(playerLY >= aiLY)
	  	{
	  		aiLosingPlay();
	  	}
	  	//winning
	  	else if(aiLY > playerLY)
	  	{
	  		aiWinningPlay();
	  	}
	  	
	  	viewObj.setLY(playerLY, aiLY);
	  	viewObj.enableAll();
	  	aiEnd();
  }
  /**
   * This method determines the order in which the AI plays if it has not lifted off yet.
   */
  private void aiNotLiftedPlay()
  {
	  if(viewObj.getAILiftOff() == false)
	  {  
		  int i = 0;
		  boolean found = false;
		  while(i < 5 && found == false)
		  {
			  if(aiHand[i] == 16)
			  {
				  aiPlay(16);
				  aiHand[i] = aiHand[5];
				  found = true;
			  }
			  i++;
		  }
		  if(found == false)
		  {
			  i = 0;
			  while(i < 5 && found == false)
			  {
				  if(aiHand[i] == 8 || aiHand[i] == 9 || aiHand[i] == 10 || aiHand[i] == 11)
				  {
					  aiPlay(aiHand[i]);
					  aiHand[i] = aiHand[5];
					  found = true;
				  }
				  i++;
			  }
		  }
		  if(found == false)
		  {
			  Random rand = new Random();
			  int card = rand.nextInt(5);
			  
			  card = aiHand[card];
			  aiDiscard(card);
			  viewObj.setAIPlayed(17, images);
		  }
	  }
  }
  /**
   * This method determines the order in which the AI plays if it is stopped.
   */
  private void aiStoppedPlay()
  {
	  boolean found = false;
	  int reason = viewObj.getAIStopped();
	  
	  //fix
	  for(int i = 0; i < aiHand.length && found == false; i++)
	  {
		  if(reason == 4)
		  {
			  for(int j = 0; j < aiHand.length && found == false; j++)
			  {
				  if(aiHand[j] == 14)
				  {
					  aiPlay(aiHand[j]);
					  found = true;
				  }
			  }
		  }
		  else if(reason == 5)
		  {
			  for(int j = 0; j < aiHand.length && found == false; j++)
			  {
				  if(aiHand[j] == 12)
				  {
					  aiPlay(aiHand[j]);
					  found = true;
				  }
			  }
		  }
		  else if(reason == 6)
		  {
			  for(int j = 0; j < aiHand.length && found == false; j++)
			  {
				  if(aiHand[j] == 15)
				  {
					  aiPlay(aiHand[j]);
					  found = true;
				  }
			  }
		  }
		  else if(reason == 7)
		  {
			  for(int j = 0; j < aiHand.length && found == false; j++)
			  {
				  if(aiHand[j] == 13)
				  {
					  aiPlay(aiHand[j]);
					  found = true;
				  }
			  }
		  }
	  }
	  //aces
	  for(int i = 0; i < aiHand.length && found == false; i++)
	  {
		  if(aiHand[i] >= 8 && aiHand[i] <= 11)
		  {
			  aiPlay(aiHand[i]);
			  aiHand[i] = aiHand[5];
			  found = true;
		  }
	  }
	  //stop
	  if(viewObj.getPlayerLiftOff() == true)
	  {
		  found = aiStop();
	  }
	  //discard
	  if(found == false)
	  {
		  Random rand = new Random();
		  int card = rand.nextInt(5);
		  
		  card = aiHand[card];
		  aiDiscard(card);  
		  viewObj.setAIPlayed(17, images);
	  }
  }
  /**
   * This method determines the order in which the AI plays if it is winning.
   */
  private void aiWinningPlay()
  {
	  boolean found = false;
	  
	  //aces
	  for(int i = 0; i < aiHand.length && found == false; i++)
	  {
		  if(aiHand[i] >= 8 && aiHand[i] <= 11)
		  {
			  aiPlay(aiHand[i]);
			  aiHand[i] = aiHand[5];
			  found = true;
		  }
	  }
	  //go
	  for(int i = 0; i < aiHand.length && found == false; i++)
	  {
		  if(aiHand[i] >= 0 && aiHand[i] <= 3)
		  {
			  aiPlay(aiHand[i]);
			  aiHand[i] = aiHand[5];
			  found = true;
		  }
	  }
	  //stop
	  if(viewObj.getPlayerLiftOff() == true)
	  {
		  found = aiStop();
	  }
	  //discard
	  if(found == false)
	  {
		  Random rand = new Random();
		  int card = rand.nextInt(5);
		  
		  card = aiHand[card];
		  aiDiscard(card);  
		  viewObj.setAIPlayed(17, images);
	  }
  }
  /**
   * This method determines the order in which the AI plays if it is losing.
   */
  private void aiLosingPlay()
  {
	  boolean found = false;
	  
	  //stop
	  if(viewObj.getPlayerLiftOff() == true)
	  {
		  found = aiStop();
	  }
	  //aces
	  for(int i = 0; i < aiHand.length && found == false; i++)
	  {
		  if(aiHand[i] >= 8 && aiHand[i] <= 11)
		  {
			  aiPlay(aiHand[i]);
			  aiHand[i] = aiHand[5];
			  found = true;
		  }
	  }
	  //go
	  for(int i = 0; i < aiHand.length && found == false; i++)
	  {
		  if(aiHand[i] >= 0 && aiHand[i] <= 3)
		  {
			  aiPlay(aiHand[i]);
			  aiHand[i] = aiHand[5];
			  found = true;
		  }
	  }
	  //discard
	  if(found == false)
	  {
		  Random rand = new Random();
		  int card = rand.nextInt(5);
		  
		  card = aiHand[card];
		  aiDiscard(card);
		  viewObj.setAIPlayed(17, images);
	  }
  }
  /**
   * This method determines which stops the AI can play.
   * @return - If it has found a card to play.
   */
  public boolean aiStop()
  {
	  boolean found = false;
	  boolean[] aces = viewObj.getPlayerAces();
	  
	  for(int i = 0; i < aiHand.length && found == false; i++)
	  {
		  if(aiHand[i] >= 4 && aiHand[i] <= 7)
		  {
			  if(aiHand[i] == 4)
			  {
				  if(aces[0] == false)
				  {
					  aiPlay(aiHand[i]);
					  aiHand[i] = aiHand[5];
				  }
			  }
			  else if(aiHand[i] == 5)
			  {
				  if(aces[1] == false)
				  {
					  aiPlay(aiHand[i]);
					  aiHand[i] = aiHand[5];
				  }
			  }
			  else if(aiHand[i] == 6)
			  {
				  if(aces[2] == false)
				  {
					  aiPlay(aiHand[i]);
					  aiHand[i] = aiHand[5];
				  }
			  }
			  else if(aiHand[i] == 7)
			  {
				  if(aces[3] == false)
				  {
					  aiPlay(aiHand[i]);
					  aiHand[i] = aiHand[5];
				  }
			  }
			  found = true;
		  }
	  }  
	  return found;
  }
  /**
   * This method ends the ai's turn.
   */
  public void aiEnd()
  {
	  	viewObj.disableAllCards();
  }
/**
* This is a private helper method to playerGo.
* @param card - The type of card played.
*/
  private void playerPlay(int card)
  {
    switch(card)
    {
      case 0:
    	  playerLY += 25;
        break;
      case 1:
    	  playerLY += 50;
        break;
      case 2:
    	  playerLY += 75;
        break;
      case 3:
    	  playerLY += 100;
        break;
      case 4:
    	  viewObj.setAIHazard(4);
        break;
      case 5:
    	  viewObj.setAIHazard(5);
        break;
      case 6:
    	  viewObj.setAIHazard(6);
        break;
      case 7:
    	  viewObj.setAIHazard(7);
        break;
      case 8:
    	  viewObj.setPlayerAce(8);
        break;
      case 9:
    	  viewObj.setPlayerAce(9);
        break;
      case 10:
    	  viewObj.setPlayerAce(10);
        break;
      case 11:
    	  viewObj.setPlayerAce(11);
        break;
      case 12:
    	  viewObj.playerFixHazard();
        break;
      case 13:
    	  viewObj.playerFixHazard();
    	break;
      case 14:
    	  viewObj.playerFixHazard();
    	break;
      case 15:
    	  viewObj.playerFixHazard();
    	break;
      case 16:
    	  viewObj.playerLiftOff();
    	break;
    }
  }
  /**
  * This is a private helper method to playerGo.
  * @param card - The type of card played.
  */
  private void aiPlay(int card)
    {
      switch(card)
      {
        case 0:
        	aiLY += 25;
        	viewObj.setAIPlayed(0, images);
          break;
        case 1:
        	aiLY += 50;
        	viewObj.setAIPlayed(1, images);
          break;
        case 2:
        	aiLY += 75;
        	viewObj.setAIPlayed(2, images);
          break;
        case 3:
        	aiLY += 100;
        	viewObj.setAIPlayed(3, images);
          break;
        case 4:
        	viewObj.setPlayerHazard(4);
        	viewObj.setAIPlayed(4, images);
          break;
        case 5:
      	  	viewObj.setPlayerHazard(5);
      	  viewObj.setAIPlayed(5, images);
          break;
        case 6:
      	  	viewObj.setPlayerHazard(6);
      	  viewObj.setAIPlayed(6, images);
          break;
        case 7:
      	  	viewObj.setPlayerHazard(7);
      	  viewObj.setAIPlayed(7, images);
          break;
        case 8:
        	viewObj.setAIAce(8);
        	viewObj.setAIPlayed(8, images);
          break;
        case 9:
      	  	viewObj.setAIAce(9);
      	  viewObj.setAIPlayed(9, images);
          break;
        case 10:
      	  	viewObj.setAIAce(10);
      	  viewObj.setAIPlayed(10, images);
          break;
        case 11:
      	  	viewObj.setAIAce(11);
      	  viewObj.setAIPlayed(11, images);
          break;
        case 12:
      	  	viewObj.aiFixHazard();
      	  viewObj.setAIPlayed(12, images);
          break;
        case 13:
        	viewObj.aiFixHazard();
        	viewObj.setAIPlayed(13, images);
      	break;
        case 14:
        	viewObj.aiFixHazard();
        	viewObj.setAIPlayed(14, images);
      	break;
        case 15:
        	viewObj.aiFixHazard();
        	viewObj.setAIPlayed(15, images);
      	break;
        case 16:
            viewObj.aiLiftOff();
            viewObj.setAIPlayed(16, images);
      	break;
      }
    }
/**
* This manages which methods call to draw a card.
*/
  public void draw()
  {
	  int turn = m.getTurn();
	
	  if(m.getTotal() == 0)
	  {
		  if(playerLY > aiLY)
		  {
			  winningFrame f = new winningFrame(0);
			  viewObj.disableEverything();
		  }
		  else
		  {
			  winningFrame f = new winningFrame(1);
			  viewObj.disableEverything();
		  }
	  }
	  //the player's turn.
	  else if(turn %2 == 0)
	  {
		  if(playerLY >= 750)
		  {
			  winningFrame f = new winningFrame(0);
			  viewObj.disableEverything();
		  }
		  else if(aiLY >= 750)
		  {
			  winningFrame f = new winningFrame(1);
			  viewObj.disableEverything();
		  }
		  else
		  {
			  viewObj.setAIButtons(images[17]);
			  playerHand[5] = m.findCard();
			  viewObj.changeButtons(playerHand, images);
			  viewObj.enable();
			  viewObj.disableDraw();
			  viewObj.enablePlayableCards(playerHand);
			  viewObj.checkAllDisabled();  
		  }  
	  }
	  //The AI's turn.
	  else
	  {
		  if(aiLY >= 750)
		  {
			  winningFrame f = new winningFrame(1);
			  viewObj.disableEverything();
		  }
		  else if(playerLY >= 750)
		  {
			  winningFrame f = new winningFrame(0);
			  viewObj.disableEverything();
		  }
		  else
		  {
			  aiHand[5] = m.findCard();
			  viewObj.setDrawCard(aiHand[5], images);  
		  }
	  }
	  m.addTurn();
  }
/**
* This manages which methods call to discard a card.
*/
  public void playerDiscard(String card)
  {
	  int cardNum = 0;
	  if(card.equals("1"))
	  {
		  playerHand[0] = playerHand[5];
		  cardNum = playerHand[0];
	  }
	  else if(card.equals("2"))
	  {
		  playerHand[1] = playerHand[5];
		  cardNum = playerHand[1];
	  }
	  else if(card.equals("3"))
	  {
		  playerHand[2] = playerHand[5];
		  cardNum = playerHand[2];
	  }
	  else if(card.equals("4"))
	  {
		  playerHand[3] = playerHand[5];
		  cardNum = playerHand[3];
	  }
	  else if(card.equals("5"))
	  {
		  playerHand[4] = playerHand[5];
		  cardNum = playerHand[4];
	  }
	  else if(card.equals("6"))
	  {
		playerHand[5] = 17;
	  }
	  
	  viewObj.updateCards(playerHand, images);
	  viewObj.disableNotEnd();
  }
  /**
   * This discards the card from the ai's hand.
   * @param card
   */
  public void aiDiscard(int card)
  {
	  boolean done = false;
	  for(int i = 0; i < aiHand.length && !done; i++)
	  {
		  if(card == aiHand[i])
		  {
			  aiHand[i] = aiHand[5];
			  done = true;
		  }
	  }
  }
  /**
   * This method replaces the int representing the card with what was drawn for the player.
   * @param num - The int representing the card in the player's hand.
   */
  public void setPlayerCard(int num)
  {
	  playerHand[num] = playerHand[playerHand.length-1];
  }
  /**
   * This method replaces the int representing the card with what was drawn for the ai.
   * @param num - The int representing the card in the ai's hand.
   */
  public void setAICard(int num)
  {
	  aiHand[num] = aiHand[playerHand.length-1];
  }
}
