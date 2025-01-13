import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.color.*;

//Alex Radu
//Date: Sep 16, 2024

public class ExploringJOptionPane
{

   public static void main(String[] args)
   {
	   for(String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
	            System.out.println(s);
	   
	   Font font1 = new Font("Minecraft", Font.PLAIN, 30);
	   ImageIcon icon = new ImageIcon(ExploringJOptionPane.class.getResource("madlibs_icon.png"));
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
	   Color backgroundColor =  new Color(245, 245, 247);
	   Border margin1 = new MatteBorder(2,2,2,2, outerBorderColor);
	   Border lineBorder1 = BorderFactory.createLineBorder(innerBorderColor, 6);
	   CompoundBorder cb = new CompoundBorder(margin1, lineBorder1);
	   UIManager.put("Button.border", cb);                         //Border for the buttons
	   UIManager.put("Button.opaque", true);                       //Buttons setting
	   UIManager.put("Button.background", Color.WHITE);            //Color for the button text
	   String noun1 = (String) JOptionPane.showInputDialog(null,
		                  "Enter your name:",
		                  "What do I do?",
		                   JOptionPane.ERROR_MESSAGE,
		                   icon,
		                   null,
		                   "Type answer here.");
	   System.out.println(noun1);

   }

}
