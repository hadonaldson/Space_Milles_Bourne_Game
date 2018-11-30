/**
 * The View class handles the user interface for MilesBornes.
 *
 * @author Michael Donaldson
 * @author Haley Donaldson
 * @version 1.0
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class View extends JPanel
{
  public static final int FRAMEHEIGHT = 1000;
  public static final int FRAMEWIDTH = 1000;
  private JFrame frame;
  private JPanel aiPanel;
  private JPanel playerPanel;
  private JPanel aiTextField;
  private JPanel playerTextField;
  private JPanel centerArea;
  private JLabel aiPlayLabel;
  
  private JButton aiButton1;
  private JButton aiButton2;
  private JButton aiButton3;
  private JButton aiButton4;
  private JButton aiButton5;
  private JButton playerButton1;
  private JButton playerButton2;
  private JButton playerButton3;
  private JButton playerButton4;
  private JButton playerButton5;
  private JButton cardButton;
  private JButton drawButton;
  private JButton discardButton;
  private JButton endButton;
  private JButton rulesButton;
  private JButton aiPlayedButton;
  
  private JTextArea playerSafteyTextArea;
  private JTextArea playerHazzardTextArea;
  private JTextArea playerMilesTextArea;
  private JTextArea aiSafteyTextArea;
  private JTextArea aiHazzardTextArea;
  private JTextArea aiMilesTextArea;
  private JTextArea discardTextArea;
  
  private Controller c;
  
  private boolean playerLiftOff = false;
  private boolean aiLiftOff = false;
  
  private int playerStopped = 0;
  private int aiStopped = 0;
  
  private boolean playerFuel = false;
  private boolean playerShield = false;
  private boolean playerAI = false;
  private boolean playerTP = false;
  
  private boolean aiFuel = false;
  private boolean aiShield = false;
  private boolean aiAI = false;
  private boolean aiTP = false;
  
/**
 * This is the constructor of the View.
 * @param c - the instance of the controller.
 */
  public View(Controller c)
  {
    this.c = c;
    frame = new JFrame("Miles Bornes IN SPACE!!!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setContentPane(this);
    frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
    frame.setLayout(new BorderLayout());

    aiButton1 = new JButton("");
    aiButton2 = new JButton("");
    aiButton3 = new JButton("");
    aiButton4 = new JButton("");
    aiButton5 = new JButton("");
    playerButton1 = new JButton("");
    playerButton1.setBackground(Color.black);
    playerButton2 = new JButton("");
    playerButton2.setBackground(Color.black);
    playerButton3 = new JButton("");
    playerButton3.setBackground(Color.black);
    playerButton4 = new JButton("");
    playerButton4.setBackground(Color.black);
    playerButton5 = new JButton("");
    playerButton5.setBackground(Color.black);
    
    rulesButton = new JButton("Rules");
    cardButton = new JButton("");
    cardButton.setBackground(Color.black);
    drawButton = new JButton("Draw");
    discardButton = new JButton("Discard");
    endButton = new JButton("End Turn");

    
    aiPlayedButton = new JButton("");
    aiPlayedButton.setBackground(Color.black);
    aiPlayLabel = new JLabel("Ai played");

    setActionListeners();
    makePanels();
    makeTextFields();
    setCenterArea();
    add();

    frame.setVisible(true);
  }
/***
 * This is a private helper class that adds everything to the GUI.
 */
  private void add()
  {
    aiPanel.add(aiButton1);
    aiPanel.add(aiButton2);
    aiPanel.add(aiButton3);
    aiPanel.add(aiButton4);
    aiPanel.add(aiButton5);

    playerPanel.add(playerButton1);
    playerPanel.add(playerButton2);
    playerPanel.add(playerButton3);
    playerPanel.add(playerButton4);
    playerPanel.add(playerButton5);

    playerTextField.add(playerSafteyTextArea);
    playerTextField.add(playerHazzardTextArea);
    playerTextField.add(playerMilesTextArea);

    aiTextField.add(aiSafteyTextArea);
    aiTextField.add(aiHazzardTextArea);
    aiTextField.add(aiMilesTextArea);

    frame.add(aiPanel, BorderLayout.NORTH);
    frame.add(playerPanel, BorderLayout.SOUTH);
    frame.add(playerTextField, BorderLayout.WEST);
    frame.add(aiTextField, BorderLayout.EAST);
    frame.add(centerArea, BorderLayout.CENTER);

    centerArea.add(cardButton);
    centerArea.add(drawButton);
    centerArea.add(discardButton);
    centerArea.add(endButton);
    centerArea.add(discardTextArea);
    centerArea.add(rulesButton);
    centerArea.add(aiPlayedButton);
    centerArea.add(aiPlayLabel);
  }
/***
 * This is a private helper class that creates all the panels.
 */
  private void makePanels()
  {
    aiPanel = new JPanel();
    aiPanel.setLayout(new GridLayout(1,5,5,1));
    aiPanel.setPreferredSize(new Dimension(175,175));

    playerPanel = new JPanel();
    playerPanel.setLayout(new GridLayout(1,5,5,1));
    playerPanel.setPreferredSize(new Dimension(175,175));

    centerArea = new JPanel();
    centerArea.setLayout(null);
  }
/***
 * This is a private helper class that creates all the textFields.
 */
  private void makeTextFields()
  {
    playerTextField = new JPanel();
    playerTextField.setLayout(new GridLayout(3,1,5,5));
    playerTextField.setPreferredSize(new Dimension(100,100));

    playerSafteyTextArea = new JTextArea("Safeties:");
    playerSafteyTextArea.setEditable(false);
    playerSafteyTextArea.setLineWrap(true);
    playerHazzardTextArea = new JTextArea("Hazards:");
    playerHazzardTextArea.setEditable(false);
    playerHazzardTextArea.setLineWrap(true);
    playerMilesTextArea = new JTextArea("Light Years:");
    playerMilesTextArea.setEditable(false);
    playerMilesTextArea.setLineWrap(true);

    aiTextField = new JPanel();
    aiTextField.setLayout(new GridLayout(3,1,5,5));
    aiTextField.setPreferredSize(new Dimension(100,100));

    aiSafteyTextArea = new JTextArea("Safeties:");
    aiSafteyTextArea.setEditable(false);
    aiSafteyTextArea.setLineWrap(true);
    aiHazzardTextArea = new JTextArea("Hazards:");
    aiHazzardTextArea.setEditable(false);
    aiHazzardTextArea.setLineWrap(true);
    aiMilesTextArea = new JTextArea("Light Years:");
    aiMilesTextArea.setEditable(false);
    aiMilesTextArea.setLineWrap(true);

    discardTextArea = new JTextArea("");
    discardTextArea.setEditable(true);
  }
/***
 * This is a private helper class that constructs the center panel.
 */
  private void setCenterArea()
  {
    cardButton.setSize(175,205);
    cardButton.setLocation(300,215);
    aiPlayedButton.setSize(175, 205);
    aiPlayedButton.setLocation(65, 215);
    aiPlayedButton.setEnabled(false);
    
    drawButton.setSize(100,25);
    drawButton.setLocation(530,235);
    discardButton.setSize(100,25);
    discardButton.setLocation(530,285);
    discardTextArea.setSize(100,25);
    discardTextArea.setLocation(647,285);
    endButton.setSize(100,25);
    endButton.setLocation(530,335);
    rulesButton.setSize(100, 25);
    rulesButton.setLocation(530, 385);
    
    aiPlayLabel.setSize(1000, 25);
    aiPlayLabel.setLocation(125, 185);
  }
/***
 * This is a private helper class that creates ActionListeners
 * for all relevant buttons.
 */
  private void setActionListeners()
  {
    playerButton1.addActionListener(new ButtonClickHandler());
    playerButton2.addActionListener(new ButtonClickHandler());
    playerButton3.addActionListener(new ButtonClickHandler());
    playerButton4.addActionListener(new ButtonClickHandler());
    playerButton5.addActionListener(new ButtonClickHandler());
    cardButton.addActionListener(new ButtonClickHandler());
    drawButton.addActionListener(new ButtonClickHandler());
    discardButton.addActionListener(new ButtonClickHandler());
    endButton.addActionListener(new ButtonClickHandler());
    rulesButton.addActionListener(new ButtonClickHandler());
  }
/**
 * This detects when the user presses the go button.
 * @param e - The button click.
 */
  private class ButtonClickHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == playerButton1)
			{
				c.playerGo(0);
				playerButton1.setIcon(cardButton.getIcon());
				resetCard(aiButton1.getIcon().toString());
				c.setPlayerCard(0);
			}
			else if(e.getSource() == playerButton2)
			{
				c.playerGo(1);
				playerButton2.setIcon(cardButton.getIcon());
				resetCard(aiButton1.getIcon().toString());
				c.setPlayerCard(1);
			}
			else if(e.getSource() == playerButton3)
			{
				c.playerGo(2);
				playerButton3.setIcon(cardButton.getIcon());
				resetCard(aiButton1.getIcon().toString());
				c.setPlayerCard(2);
			}
			else if(e.getSource() == playerButton4)
			{
				c.playerGo(3);
				playerButton4.setIcon(cardButton.getIcon());
				resetCard(aiButton1.getIcon().toString());
				c.setPlayerCard(3);
			}
			else if(e.getSource() == playerButton5)
			{
				c.playerGo(4);
				playerButton5.setIcon(cardButton.getIcon());
				resetCard(aiButton1.getIcon().toString());
				c.setPlayerCard(4);
			}
			else if(e.getSource() == cardButton)
			{
				c.playerGo(5);
				resetCard(aiButton1.getIcon().toString());
			}
			else if(e.getSource() == drawButton)
			{
				c.draw();
			}
			else if(e.getSource() == discardButton)
			{
				c.playerDiscard(discardTextArea.getText());
				
			}
			else if(e.getSource() == endButton)
			{
				c.aiGo();
			}
			else if(e.getSource() == rulesButton)
			{
				RulesMenu rm = new RulesMenu();
			}
		}
	}
/**
 * This method sets up the distance traveled and updates the GUI.
 * @param p1LY - Distance traveled by the player.
 * @param aiLY - Distance traveled by the AI.
 */
  public void setLY(int p1LY, int aiLY)
  {
    playerMilesTextArea.setText("You have gone:     " + p1LY + " Light Years.");
    aiMilesTextArea.setText("The AI has gone:  " + aiLY + " Light Years.");
  }
/**
 * This method updates the picture of all the buttons.
 * @param handArray - The 5 card hand.
 * @param images - The list of cards as images.
 */
  public void changeButtons(int[] handArray, String[] images)
  {
    for(int i = 0; i < handArray.length; i++)
    {
      if(handArray[i] == 0)/*----------*/{chooseButton(i, images[0]);}
      else if(handArray[i] == 1)/*-----*/{chooseButton(i, images[1]);}
      else if(handArray[i] == 2)/*-----*/{chooseButton(i, images[2]);}
      else if(handArray[i] == 3)/*-----*/{chooseButton(i, images[3]);}
      else if(handArray[i] == 4)/*-----*/{chooseButton(i, images[4]);}
      else if(handArray[i] == 5)/*-----*/{chooseButton(i, images[5]);}
      else if(handArray[i] == 6)/*-----*/{chooseButton(i, images[6]);}
      else if(handArray[i] == 7)/*-----*/{chooseButton(i, images[7]);}
      else if(handArray[i] == 8)/*-----*/{chooseButton(i, images[8]);}
      else if(handArray[i] == 9)/*-----*/{chooseButton(i, images[9]);}
      else if(handArray[i] == 10)/*----*/{chooseButton(i, images[10]);}
      else if(handArray[i] == 11)/*----*/{chooseButton(i, images[11]);}
      else if(handArray[i] == 12)/*----*/{chooseButton(i, images[12]);}
      else if(handArray[i] == 13)/*----*/{chooseButton(i, images[13]);}
      else if(handArray[i] == 14)/*----*/{chooseButton(i, images[14]);}
      else if(handArray[i] == 15)/*----*/{chooseButton(i, images[15]);}
      else if(handArray[i] == 16)/*----*/{chooseButton(i, images[16]);}
      else if(handArray[i] == 17)/*----*/{chooseButton(i, images[17]);}
    }
  }
/**
 * This is a private helper method that selects the correct button to
 * change its picture.
 * @param button - This determines which button is to be changed.
 * @param card - This determines which card is to be placed in the button.
 */
  private void chooseButton(int button, String card)
  {
    if(button == 0)
    {
      setButton1(card);
    }
    else if(button == 1)
    {
      setButton2(card);
    }
    else if(button == 2)
    {
      setButton3(card);
    }
    else if(button == 3)
    {
      setButton4(card);
    }
    else if(button == 4)
    {
      setButton5(card);
    }
    else if(button == 5)
    {
      setCardButton(card);
    }
  }
/**
 * This is a private helper method to change the icon of the first button.
 * @param card - This is the card the buttonIcon is changing to.
 */
  private void setButton1(String card)
  {
	ImageIcon image = new ImageIcon(card);
    playerButton1.setIcon(image);
  }
/**
 * This is a private helper method to change the icon of the second button.
 * @param card - This is the card the buttonIcon is changing to.
 */
  private void setButton2(String card)
  {
    ImageIcon image = new ImageIcon(card);
    playerButton2.setIcon(image);
  }
/**
 * This is a private helper method to change the icon of the third button.
 * @param card - This is the card the buttonIcon is changing to.
 */
  private void setButton3(String card)
  {
	ImageIcon image = new ImageIcon(card);
    playerButton3.setIcon(image);
  }
/**
 * This is a private helper method to change the icon of the fourth button.
 * @param card - This is the card the buttonIcon is changing to.
 */
  private void setButton4(String card)
  {
    ImageIcon image = new ImageIcon(card);
    playerButton4.setIcon(image);
  }
/**
 * This is a private helper method to change the icon of the fifth button.
 * @param card - This is the card the buttonIcon is changing to.
 */
  private void setButton5(String card)
  {
	ImageIcon image = new ImageIcon(card);
    playerButton5.setIcon(image);
  }
/**
 * This is a private helper method to change the icon of the drawButton.
 * @param card - This is the card the buttonIcon is changing to.
 */
  private void setCardButton(String card)
  {
	ImageIcon image = new ImageIcon(card);
    cardButton.setIcon(image);
  }
/**
 * This method re-enables all the buttons.
 */
  public void enable()
  {
		playerButton1.setEnabled(true);
		playerButton2.setEnabled(true);
		playerButton3.setEnabled(true);
		playerButton4.setEnabled(true);
		playerButton5.setEnabled(true);
		cardButton.setEnabled(true);
		discardButton.setEnabled(true);
		endButton.setEnabled(true);
  }
/**
 * This method sets the textArea of the player to show the player what they are stuck on.
 * @param num - The particular hazard.
 */
  public void setPlayerHazard(int num)
  {
	  if(num == 4)
	  {
		  playerHazzardTextArea.setText("Hazard: \n" + "No Fuel");
		  playerStopped = 4;
	  }
	  if(num == 5)
	  {
		  playerHazzardTextArea.setText("Hazard: \n" + "Thrusters" + "\n" + "Damaged");
		  playerStopped = 5;
	  }
	  if(num == 6)
	  {
		  playerHazzardTextArea.setText("Hazard: \n" + "Bumpy Road" + "\n" +"Ahead");
		  playerStopped = 6;
	  }
	  if(num == 7)
	  {
		  playerHazzardTextArea.setText("Hazard: \n" + "JAMMED!!!");
		  playerStopped = 7;
	  }
  }
/**
 * This method resets the player's hazard TextArea.
 */
  public void playerFixHazard()
  {
	  playerHazzardTextArea.setText("Hazard: ");
	  playerStopped = 0;
  }
/**
 * This method sets the player's safeties.
 * @param num - The specific safety.
 */
  public void setPlayerAce(int num)
  {
	  if(num == 8)
	  {
		  playerFuel = true;
	  }
	  if(num == 9)
	  {
		  playerShield = true;
	  }
	  if(num == 10)
	  {
		  playerAI = true;
	  }
	  if(num == 11)
	  {
		  playerTP = true;
	  }
	  
	  boolean[] aces = getPlayerAces();
	  String result = "Safties: \n";
	  
		  if(aces[0] == true)
		  {
			  result += "Quantum Fuel \n";
		  }
		  if(aces[1] == true)
		  {
			  result += "Protective Bubble \n";
		  }
		  if(aces[2] == true)
		  {
			  result += "Robot Buddy \n";
		  }
		  if(aces[3] == true)
		  {
			  result += "Cleaning Staff \n";
		  }
	  
	  playerSafteyTextArea.setText(result);
	  
  }
/**
 * This method tell the user that you both need to lift off in the beginning.
 */
  public void needLiftOff()
  {
	  aiHazzardTextArea.setText("Hazard: \n" + "NEED LIFTOFF");
	  playerHazzardTextArea.setText("Hazard: \n" + "NEED LIFTOFF");
  }
/**
 * This method "Lift offs" the player's space ship.
 */
  public void playerLiftOff()
  {
	  playerLiftOff=true;
	  playerHazzardTextArea.setText("Hazard:");
  }
/**
 * This method returns if the player has been lifted off.
 * @return - If the player has been lifted off.
 */
  public boolean getPlayerLiftOff()
  {
	  return playerLiftOff;
  }
/**
 * This returns an array of booleans representing the forever fixes for the player. 
 * @return - Boolean array.
 */
  public boolean[] getPlayerAces()
  {
	 boolean[] result = new boolean[4];
	 
	  result[0] = playerFuel;
	  result[1] = playerShield;
	  result[2] = playerAI;
	  result[3] = playerTP;
	 
	 return result;
  }
/**
 * This returns an array of booleans representing the forever fixes for the AI. 
 * @return - Boolean array.
 */
  public boolean[] getAIAces()
  {
	 boolean[] result = new boolean[4];
	 
	  result[0] = aiFuel;
	  result[1] = aiShield;
	  result[2] = aiAI;
	  result[3] = aiTP;
	 
	 return result;
  }
/**
 * This method sets the image of the card back to the logo.
 * @param num - The card.
 * @param logo - the logo.
 */
  public void resetCard(String logo)
  {
	  ImageIcon image = new ImageIcon(logo);
	  cardButton.setIcon(image);
	  cardButton.setEnabled(true);
  }
/**
 * This method disables the draw Button.
 */
  public void disableDraw()
  {
	  drawButton.setEnabled(false);
  }
/**
 * Disables everything except for the draw button.
 */
  public void disableNotDraw()
  {
		playerButton1.setEnabled(false);
		playerButton2.setEnabled(false);
		playerButton3.setEnabled(false);
		playerButton4.setEnabled(false);
		playerButton5.setEnabled(false);
		cardButton.setEnabled(false);
		discardButton.setEnabled(false);
		endButton.setEnabled(false);
		
		drawButton.setEnabled(true);
  }
/**
 * Disables everything except for the discard Button.
 */
  public void disableNotDiscard()
  {
	  playerButton1.setEnabled(false);
	  playerButton2.setEnabled(false);
	  playerButton3.setEnabled(false);
	  playerButton4.setEnabled(false);
	  playerButton5.setEnabled(false);
	  cardButton.setEnabled(false);
	  endButton.setEnabled(false);
	  
	  discardButton.setEnabled(true);
  }
/**
 * Disables everything except for the end button.
 */
  public void disableNotEnd()
  {
	  playerButton1.setEnabled(false);
	  playerButton2.setEnabled(false);
	  playerButton3.setEnabled(false);
	  playerButton4.setEnabled(false);
	  playerButton5.setEnabled(false);
	  cardButton.setEnabled(false);
	  discardButton.setEnabled(false);
	  
	  endButton.setEnabled(true);
	  discardTextArea.setText("");
  }
/**
 * This method disables any cards that cannot be played.
 * @param hand - The player's hand
 */
  public void enablePlayableCards(int[] hand)
  {  
	  //if the player is stopped.
	  if(playerStopped > 0 || playerLiftOff == false)
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  //if the card is a move card. 
			  if(hand[i] <= 3)
			  {
				  disable(i);
			  }
			  //if its a fix card
			  else if(hand[i] >= 12 && hand[i] <= 15)
			  {
				  if(hand[i] == 12)
				  {
					  if(playerStopped != 5)
					  {
						  disable(i);
					  }
				  }
				  else if(hand[i] == 13)
				  {
					  if(playerStopped != 7)
					  {
						  disable(i);
					  }
				  }
				  else if(hand[i] == 14)
				  {
					  if(playerStopped != 4)
					  {
						  disable(i);
					  }
				  }
				  else if(hand[i] == 15)
				  {
					  if(playerStopped != 6)
					  {
						  disable(i);
					  }
				  }
			  }
		  }
	  }
	  else
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  if(hand[i] >= 12 && hand[i] <= 15)
			  {
				  disable(i);
			  }
		  }
	  }
	  //if you have lifted off
	  if(playerLiftOff == true)
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  if(hand[i] == 16)
			  {
				  disable(i);
			  }
		  }
	  }
	  //if the ai has not lifted off.
	  if(aiLiftOff == false)
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  if(hand[i] >= 4 && hand[i] <= 7)
			  {
				  disable(i);
			  }
		  }
	  }
	  //if the AI has aces
	  boolean[] aces = getAIAces();
	  if(aces[0] == true)
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  if(hand[i] == 4)
			  {
				  disable(i);
			  }
		  }
	  }
	  if(aces[1] == true)
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  if(hand[i] == 5)
			  {
				  disable(i);
			  }
		  }
	  }
	  if(aces[2] == true)
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  if(hand[i] == 6)
			  {
				  disable(i);
			  }
		  }
	  }
	  if(aces[3] == true)
	  {
		  for(int i = 0; i < hand.length; i++)
		  {
			  if(hand[i] == 7)
			  {
				  disable(i);
			  }
		  }
	  }
  }
/**
 * This method disables any card that was determines to be un-playable.
 * @param card - The card.
 */
  public void disable(int card)
  {
	  if(card == 0)
	  {
		  playerButton1.setEnabled(false);
	  }
	  if(card == 1)
	  {
		  playerButton2.setEnabled(false);
	  }
	  if(card == 2)
	  {
		  playerButton3.setEnabled(false);
	  }
	  if(card == 3)
	  {
		  playerButton4.setEnabled(false);
	  }
	  if(card == 4)
	  {
		  playerButton5.setEnabled(false);
	  }
	  if(card == 5)
	  {
		  cardButton.setEnabled(false);
	  }
  }
/**
 * This checks if there are any plays able to be made.
 */
  public void checkAllDisabled()
  {
	  if(playerButton1.isEnabled() == false &&
	     playerButton2.isEnabled() == false &&
	     playerButton3.isEnabled() == false &&
	     playerButton4.isEnabled() == false &&
	     playerButton5.isEnabled() == false &&
	     cardButton.isEnabled() == false)
	  {
		  disableNotDiscard();
	  }
	  else
	  {
		  endButton.setEnabled(false);
	  }
  }
/**
 * This method resets all the images on the cards.
 * @param hand - The player's hand.
 * @param images - the list of images.
 */
  public void updateCards(int[] hand, String[] images)
  {
	  for(int i = 0; i < hand.length; i++)
	  {
		  ImageIcon image = new ImageIcon(images[hand[i]]);
		  
		  if(i == 0)
		  {
			  playerButton1.setIcon(image);
		  }
		  else if (i == 1)
		  {
			  playerButton2.setIcon(image);  
		  }
		  else if(i == 2)
		  {
			  playerButton3.setIcon(image);
		  }
		  else if(i == 3)
		  {
			  playerButton4.setIcon(image);
		  }
		  else if(i == 4)
		  {
			  playerButton5.setIcon(image);
		  }
	  }
	  cardButton.setIcon(new ImageIcon(images[17]));
  }
/**
 * This method disables all the player's buttons.
 */
  public void disableAllCards()
  {
	  playerButton1.setEnabled(false);
	  playerButton2.setEnabled(false);
	  playerButton3.setEnabled(false);
	  playerButton4.setEnabled(false);
	  playerButton5.setEnabled(false);
	  endButton.setEnabled(false);
  }
/**
 * This disables all the card buttons and the draw button.
 */
  public void disableEverything()
  {
	  disableAllCards();
	  disableDraw();
  }
/**
 * This method disables all the ai's buttons.
 */
  public void enableAll()
  {
	  playerButton1.setEnabled(true);
	  playerButton2.setEnabled(true);
	  playerButton3.setEnabled(true);
	  playerButton4.setEnabled(true);
	  playerButton5.setEnabled(true);
	  drawButton.setEnabled(true);
  }
/**
 * This method returns if the ai has lifted off yet.
 * @return - Boolean.
 */
  public boolean getAILiftOff()
  {
	  return aiLiftOff;
  }
/**
 * This method "Lift offs" the ai's space ship.
 */
  public void aiLiftOff()
  {
	  aiLiftOff=true;
	  aiHazzardTextArea.setText("Hazard:");
  }
/**
 * This method sets the ai's safeties.
 * @param num - The specific safety.
 */
  public void setAIAce(int num)
  {
	  if(num == 8)
	  {
		  aiFuel = true;
	  }
	  if(num == 9)
	  {
		  aiShield = true;
	  }
	  if(num == 10)
	  {
		  aiAI = true;
	  }
	  if(num == 11)
	  {
		  aiTP = true;
	  }
	  
	  boolean[] aces = getAIAces();
	  String result = "Safties: \n";
	  
		  if(aces[0] == true)
		  {
			  result += "Quantum Fuel \n";
		  }
		  if(aces[1] == true)
		  {
			  result += "Protective Bubble \n";
		  }
		  if(aces[2] == true)
		  {
			  result += "Robot Buddy \n";
		  }
		  if(aces[3] == true)
		  {
			  result += "Cleaning Staff \n";
		  }
	  
	  aiSafteyTextArea.setText(result);
  }
/**
 * This method sets the textArea of the ai to show the player what they are stuck on.
 * @param num - The hazard that the ai is stopped on.
 */
  public void setAIHazard(int num)
  {
	  if(num == 4)
	  {
		  aiHazzardTextArea.setText("Hazard: \n" + "No Fuel");
		  aiStopped = 4;
	  }
	  if(num == 5)
	  {
		  aiHazzardTextArea.setText("Hazard: \n" + "Thrusters" + "\n" + "Damaged");
		  aiStopped = 5;
	  }
	  if(num == 6)
	  {
		  aiHazzardTextArea.setText("Hazard: \n" + "Bumpy Road" + "\n" +"Ahead");
		  aiStopped = 6;
	  }
	  if(num == 7)
	  {
		  aiHazzardTextArea.setText("Hazard: \n" + "JAMMED!!!");
		  aiStopped = 7;
	  }
  }
/**
 * This method resets the ai's TextArea.
 */
  public void aiFixHazard()
  {
	  aiHazzardTextArea.setText("Hazard: ");
	  aiStopped = 0;
  }
/**
 * This method makes all the ai's buttons the logo.
 * @param hand - the AI's hand
 * @param logo - The logo.
 */
  public void setAIButtons(String logo)
  {
	  ImageIcon image = new ImageIcon(logo);
	  aiButton1.setIcon(image);
	  aiButton2.setIcon(image);
	  aiButton3.setIcon(image);
	  aiButton4.setIcon(image);
	  aiButton5.setIcon(image);
	  aiPlayedButton.setIcon(image);
	  
	  aiButton1.setBackground(Color.black);
	  aiButton2.setBackground(Color.black);
	  aiButton3.setBackground(Color.black);
	  aiButton4.setBackground(Color.black);
	  aiButton5.setBackground(Color.black);
  }
/**
 * This method sets the Draw card to the cardButton.
 * @param cardNum - The card
 * @param imageList - The list of cards.
 */
  public void setDrawCard(int cardNum, String[] imageList)
  {
	  ImageIcon image = new ImageIcon(imageList[cardNum]);
	  cardButton.setEnabled(false);
	  cardButton.setIcon(image);
  }
/**
 * This method returns if the ai has been stopped.
 * @return - boolean representing if the ai is stopped.
 */
  public int getAIStopped()
  {
	  return aiStopped;
  }
/**
 * This method sets the image of what the AI played.
 * @param cardNum - The int representing the card that has been played.
 * @param images - The list of images.
 */
  public void setAIPlayed(int cardNum, String[] images)
  {
	  ImageIcon image = new ImageIcon(images[cardNum]);
	  aiPlayedButton.setIcon(image);
  }
}
