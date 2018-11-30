/**
 * The RulesMenu class creates the view for the rule display.
 *
 * @author Michael Donaldson
 * @author Haley Donaldson
 * @version 1.0
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class RulesMenu 
{
		public static final int FRAMEHEIGHT=510;
		public static final int FRAMEWIDTH=500;
		
		private JFrame frame;
		private JPanel winInfo;
		private ImageIcon cardInfo;
		
		/**
		 * The constructor for the rules menu.
		 */
		public RulesMenu()
		{
			frame=new JFrame("Rules Menu");
			winInfo= new JPanel();
			
			frame.setLayout(new BorderLayout());
			
			winInfo.setSize(500,500);
			cardInfo= new ImageIcon("images/rules.png");
			winInfo.add(new JLabel(cardInfo));
			
			frame.add(winInfo);
			frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
			frame.setResizable(false);
			frame.setVisible(true);
		}

}
