import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

//Alex Radu
//Date: Oct 26, 2024

public class test
{

	public static void main(String[] args)
	{
		Font font1 = new Font("Minecraft", Font.PLAIN, 30);
		   ImageIcon icon = new ImageIcon(JOptionMania.class.getResource("icon.png"));
		   ImageIcon icon2 = new ImageIcon(JOptionMania.class.getResource("icon2.png"));
//		   ImageIcon icon2 = new ImageIcon(JOptionMania.class.getResource("icegif-962.gif"));
//		   ImageIcon icon3 = new ImageIcon(JOptionMania.class.getResource("congratulations-youre-finished.png"));
		   UIManager.put("OptionPane.messageForeground", Color.black); //Font color
		   UIManager.put("Panel.background", Color.WHITE);             //Main window background color
		   UIManager.put("OptionPane.background", new Color(245, 245, 247));         //Window border color
		   UIManager.put("OptionPane.messageFont", font1);             //Font for window message
		   UIManager.put("TextField.font", font1);                     //Font for inputMessageDialog boxes
		   UIManager.put("Button.foreground", new Color(245, 245, 247));           //Color for the button text
		   UIManager.put("OptionPane.buttonFont", font1);              //Font for the buttons
		   UIManager.put("Button.foreground", Color.GRAY);        	   //Color for the button text
		   UIManager.put("OptionPane.buttonFont", font1);       	   //Font for the buttons
		   Color outerBorderColor = Color.WHITE;
		   Color innerBorderColor = Color.WHITE;
		   Border margin1 = new MatteBorder(2,2,2,2, outerBorderColor);
		   Border lineBorder1 = BorderFactory.createLineBorder(innerBorderColor, 6);
		   CompoundBorder cb = new CompoundBorder(margin1, lineBorder1);
		   UIManager.put("Button.border", cb);                         //Border for the buttons
		   UIManager.put("Button.opaque", true);                       //Buttons setting
		   UIManager.put("Button.background", Color.WHITE);            //Color for the button text
		   JOptionPane.showMessageDialog(null, "Alex Radu", null, 0, icon);
		   String[] buttonTextValues = {"Easy", "Medium", "Hard", "Expert", "Master", "Impossible"};
		      int selection = JOptionPane.showOptionDialog(null,
		                                                   "Select a button...",
		                                                   "Entry Screen",
		                                                   JOptionPane.YES_NO_OPTION,
		                                                   JOptionPane.NO_OPTION,
		                                                   icon,
		                                                   buttonTextValues,
		                                                   buttonTextValues[0]);
		   System.out.println(selection);
	}

}
