import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

//Alex Radu
//Date: Sep 19, 2024

public class MadlibsJOptionPane
{

	   public static void main(String[] args)
	   { 
		   for(String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
			   System.out.println(s);
		   Font font1 = new Font("Minecraft", Font.PLAIN, 30);
		   ImageIcon icon = new ImageIcon(("./September/MadLibs/madlibs_icon.png"));
		   ImageIcon icon2 = new ImageIcon(("./September/MadLibs/icegif-962.gif"));
		   ImageIcon icon3 = new ImageIcon(("./September/MadLibs/congratulations-youre-finished.png"));
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
		   JOptionPane.showMessageDialog(null, "Alex Radu", null, 0, icon);
		   String name1 = (String) JOptionPane.showInputDialog(null,
	                  "Enter a name:",
	                  "Madlibs",
	                   JOptionPane.ERROR_MESSAGE,
	                   icon,
	                   null,
	                   "Type answer here.");
		   String noun1 = (String) JOptionPane.showInputDialog(null,
	                  "Enter a noun:",
	                  "Madlibs",
	                   JOptionPane.ERROR_MESSAGE,
	                   icon,
	                   null,
	                   "Type answer here.");
		   String animal1 = (String) JOptionPane.showInputDialog(null,
	                  "Enter a animal:",
	                  "Madlibs",
	                   JOptionPane.ERROR_MESSAGE,
	                   icon,
	                   null,
	                   "Type answer here.");
		   String animal2 = (String) JOptionPane.showInputDialog(null,
	                  "Enter another animal:",
	                  "Madlibs",
	                   JOptionPane.ERROR_MESSAGE,
	                   icon,
	                   null,
	                   "Type answer here.");
		   String address = (String) JOptionPane.showInputDialog(null,
	                  "Enter your address:",
	                  "Madlibs",
	                   JOptionPane.ERROR_MESSAGE,
	                   icon2,
	                   null,
	                   "Type answer here.");
		   JOptionPane.showMessageDialog(null, name1.toUpperCase() + " walked up the " + noun1.toUpperCase() + " while petting his " + animal1.toUpperCase() + ".\nAlso, a " + animal2.toUpperCase() + " was close-by and almost pounced.\nFinally, he got to the top of the " + noun1.toUpperCase() + " \nand realized that he had no reason for climbing it, \nhe went back to " + address.toUpperCase() , "Madlibs", JOptionPane.DEFAULT_OPTION, icon3);
		   //Elijah walked up the HILL while petting his ANIMAL and his ANIMAL2 walked behind him. 
		  // Finally, he got to the top of the hill and realized that he had no reason for doing that. 
		 //  So he walked back to WHERE YOU LIVE.

		   System.out.println(name1);
		   System.out.println(noun1);
		   System.out.println(animal1);
		   System.out.println(animal2);
		   System.out.println(address);
	   }
}
