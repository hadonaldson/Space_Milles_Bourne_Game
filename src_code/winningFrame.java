/**
 * The winningFrame class creates the view for the player who won.
 *
 * @author Michael Donaldson
 * @author Haley Donaldson
 * @version 1.0
 */
import java.awt.event.*;
import javax.swing.*;
public class winningFrame extends JPanel
{
	/**
	 * The constructor to create the winning frame.
	 * @param winner
	 */
	public winningFrame(int winner)
	{
		  JFrame winFrame = new JFrame("");
		  winFrame.setResizable(false);
		  winFrame.setContentPane(this);
		  winFrame.setSize(200, 100);
		  winFrame.setLayout(null);		  
		  winFrame.setLocation(500,500);
		  
		  JLabel winLabel = new JLabel("");
		  winLabel.setSize(100,25);
		  winLabel.setLocation(75,10);
		  winFrame.add(winLabel);
		  
		  JButton endGameButton = new JButton("End Game");
		  endGameButton.setSize(100, 25);
		  endGameButton.setLocation(50, 40);
		  winFrame.add(endGameButton);
		    
		  if(winner == 0)
		  {
			  winLabel.setText("You win!");
		  }
		  if(winner != 0)
		  {
			  winLabel.setText("You lost.");
		  }
		  
		  endGameButton.addActionListener(new ActionListener()
				  {
			  public void actionPerformed(ActionEvent e)
			  {
				  winFrame.dispose();
			  }
		  });
		    winFrame.setVisible(true);
	}
}
