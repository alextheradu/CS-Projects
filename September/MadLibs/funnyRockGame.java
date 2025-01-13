import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

//Alex Radu
//Date: Sep 19, 2024

public class funnyRockGame
{

	   public static void main(String[] args)
	   { 
		for(String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
            System.out.println(s);
		   Font font1 = new Font("Minecraft", Font.PLAIN, 30);
		   ImageIcon icon = new ImageIcon(funnyRockGame.class.getResource("rockpaperscissors.png"));
		   ImageIcon icon2 = new ImageIcon(funnyRockGame.class.getResource("icegif-962.gif"));
		   ImageIcon icon3 = new ImageIcon(funnyRockGame.class.getResource("congratulations-youre-finished.png"));
		   ImageIcon icon4 = new ImageIcon(funnyRockGame.class.getResource("well-this-brain-is-not-working-squidward.gif"));
		   JOptionPane jOptionPane = new JOptionPane();
		jOptionPane.setIcon(icon3);
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
		   Color innerBorderColor = Color.WHITE;		   Border margin1 = new MatteBorder(2,2,2,2, outerBorderColor);
		   Border lineBorder1 = BorderFactory.createLineBorder(innerBorderColor, 6);
		   CompoundBorder cb = new CompoundBorder(margin1, lineBorder1);
		   UIManager.put("Button.border", cb);                         //Border for the buttons
		   UIManager.put("Button.opaque", true);                       //Buttons setting
		   UIManager.put("Button.background", Color.WHITE);  
		   String playagain = "y";
		   String tie = "You tied with the computer!";
		   String lose = "You've lost to the computer! (That's unacceptable >:(";
		   String win = "You've somehow beaten the computer!";
		   String[] yen = {"Yes", "No"};
		   String compChoice = "nothing yet";
		   String playerChoice = "nothing yet";
		   while(playagain.equalsIgnoreCase("y"))
		   {
			   System.out.println();
			   Random rand = new Random();
			   int rand_int1 = rand.nextInt(3);
			//    int rand_int1 = 0;
			   System.out.println(rand_int1);
			   if(rand_int1 == 0)
			   {
				compChoice = "rock".toUpperCase();
			   }
			   if(rand_int1 == 1)
			   {
				compChoice = "paper".toUpperCase();
			   }
			   if(rand_int1 == 2)
			   {
				compChoice = "scissors".toUpperCase();
			   }
			   String[] buttonTextValues = {"Rock", "Paper", "Scissors"};
			      int selection = JOptionPane.showOptionDialog(null,
			                                                   "Choose your figher!",
			                                                   "Entry Screen",
			                                                   JOptionPane.YES_NO_OPTION,
			                                                   JOptionPane.NO_OPTION,
			                                                   icon,
			                                                   buttonTextValues,
			                                                   buttonTextValues[0]);
				if(selection == 0)
				{
					playerChoice = "Rock".toUpperCase();
				}
				if(selection == 1)
				{
					playerChoice = "Paper".toUpperCase();
				}
				if(selection == 2)
				{
					playerChoice = "Scissors".toUpperCase();
				}
//			      Random rand = new Random();
//				   int rand_int1 = rand.nextInt(selection.length);
			     
				if(selection == 0 && rand_int1 == 0)
			     {
			     	JOptionPane.showMessageDialog(null, 
							   tie + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
							   tie, 
							   selection, 
							   icon2);
			     	
				      int reboot = JOptionPane.showOptionDialog(null,
				                                                   "Do you want to play again?",
				                                                   "Play again?",
				                                                   JOptionPane.YES_NO_OPTION,
				                                                   JOptionPane.NO_OPTION,
				                                                   icon3,
				                                                   yen,
				                                                   yen[0]);
				      if (reboot == 1) 
				     	{
				     		playagain = "n";
			     		}
			     		else 
			     		{
			     			System.out.println(2);	
		     			}
			     }
				if(selection == 0 && rand_int1 == 1)
				{
					JOptionPane.showMessageDialog(null, 
							lose + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
							lose, 
							selection, 
							icon4);
					
					int reboot = JOptionPane.showOptionDialog(null,
							"Do you want to play again?",
							"Play again?",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.NO_OPTION,
							icon3,
							yen,
							yen[0]);
					if (reboot == 1) 
					{
						playagain = "n";
					}
					else 
					{
						System.out.println();	
					}
				}
				if(selection == 0  && rand_int1 == 2)
				{
					JOptionPane.showMessageDialog(null, 
							win + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
							win, 
							selection, 
							icon2);
					
					int reboot = JOptionPane.showOptionDialog(null,
							"Do you want to play again?",
							"Play again?",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.NO_OPTION,
							icon3,
							yen,
							yen[0]);
					if (reboot == 1) 
					{
						playagain = "n";
					}
					else 
					{
						System.out.println();	
					}
				}
				 if(selection == 1 && rand_int1 == 0)
			     {
			     	JOptionPane.showMessageDialog(null, 
							   win + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
							   win, 
							   selection, 
							   icon);
			     	
				      int reboot = JOptionPane.showOptionDialog(null,
				                                                   "Do you want to play again?",
				                                                   "Play again?",
				                                                   JOptionPane.YES_NO_OPTION,
				                                                   JOptionPane.NO_OPTION,
				                                                   icon3,
				                                                   yen,
				                                                   yen[0]);
				      if (reboot == 1) 
				     	{
				     		playagain = "n";
			     		}
			     		else 
			     		{
			     			System.out.println();	
		     			}
			     }
				 if(selection == 1 && rand_int1 == 1)
			     {
			     	JOptionPane.showMessageDialog(null, 
							   tie + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
							   tie, 
							   selection, 
							   icon2);
			     	
				      int reboot = JOptionPane.showOptionDialog(null,
				                                                   "Do you want to play again?",
				                                                   "Play again?",
				                                                   JOptionPane.YES_NO_OPTION,
				                                                   JOptionPane.NO_OPTION,
				                                                   icon3,
				                                                   yen,
				                                                   yen[0]);
				      if (reboot == 1) 
				     	{
				     		playagain = "n";
			     		}
			     		else 
			     		{
			     			System.out.println();	
		     			}
			     }
				 if(selection == 1 && rand_int1 == 2)
				     {
				     	JOptionPane.showMessageDialog(null, 
								   lose + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
								   lose, 
								   selection, 
								   icon4);
				     	
					      int reboot = JOptionPane.showOptionDialog(null,
					                                                   "Do you want to play again?",
					                                                   "Play again?",
					                                                   JOptionPane.YES_NO_OPTION,
					                                                   JOptionPane.NO_OPTION,
					                                                   icon3,
					                                                   yen,
					                                                   yen[0]);
					      if (reboot == 1) 
					     	{
					     		playagain = "n";
				     		}
				     		else 
				     		{
				     			System.out.println();	
			     			}
				     }
				 if(selection == 2 && rand_int1 == 0)
				     {
				     	JOptionPane.showMessageDialog(null, 
								   lose + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
								   lose, 
								   selection, 
								   icon4);
				     	
					      int reboot = JOptionPane.showOptionDialog(null,
					                                                   "Do you want to play again?",
					                                                   "Play again?",
					                                                   JOptionPane.YES_NO_OPTION,
					                                                   JOptionPane.NO_OPTION,
					                                                   icon3,
					                                                   yen,
					                                                   yen[0]);
					      if (reboot == 1) 
					     	{
					     		playagain = "n";
				     		}
				     		else 
				     		{
				     			System.out.println();	
			     			}
				     }
				 if(selection == 2 && rand_int1 == 1)
				     {
				     	JOptionPane.showMessageDialog(null, 
								   win + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
								   win, 
								   selection, 
								   icon2);
				     	
					      int reboot = JOptionPane.showOptionDialog(null,
					                                                   "Do you want to play again?",
					                                                   "Play again?",
					                                                   JOptionPane.YES_NO_OPTION,
					                                                   JOptionPane.NO_OPTION,
					                                                   icon3,
					                                                   yen,
					                                                   yen[0]);
					      if (reboot == 1) 
					     	{
					     		playagain = "n";
				     		}
				     		else 
				     		{
				     			System.out.println();	
			     			}
				     }
				 if(selection == 2 && rand_int1 == 2)
				     {
				     	JOptionPane.showMessageDialog(null, 
								   tie + "\n You chose " + playerChoice + " and computer chose " + compChoice, 
								   tie, 
								   selection, 
								   icon2);
				     	
					      int reboot = JOptionPane.showOptionDialog(null,
					                                                   "Do you want to play again?",
					                                                   "Play again?",
					                                                   JOptionPane.YES_NO_OPTION,
					                                                   JOptionPane.NO_OPTION,
					                                                   icon3,
					                                                   yen,
					                                                   yen[0]);
					      if (reboot == 1) 
					     	{
					     		playagain = "n";
				     		}
				     		else 
				     		{
				     			System.out.println();	
			     			}
				     }
				 
		   }
		   
		   
	   }
}