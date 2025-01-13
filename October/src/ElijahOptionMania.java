import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//Elijah Mathew
//Date: Oct 17, 2024

public class ElijahOptionMania
{

   public static void main(String[] args) {
   
   ImageIcon icon = new ImageIcon(ElijahOptionMania.class.getResource("icon.png"));
   String playAgain = "0";

         
   do
   {
	   Scanner sc = new Scanner(System.in);
	   double startTime1 = 0;
	   double totalTime1 = 0;
	   String[] array1difficulty = {"Easy", "Medium", "Hard", "Impossible"};
	   String[] numberArrays = {"Choose a streak value", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
int difficulty = 0;
   int attempts = 0;
   int correct = 0;
   int streak = 0;
   int upper = 0;
   int lower = 0;
   
   difficulty = JOptionPane.showOptionDialog(null,
                                                      "What difficulty do you want to play?",
                                                      "MultiplyMania",
                                                      JOptionPane.YES_NO_OPTION,
                                                      JOptionPane.NO_OPTION,
                                                      icon,
                                                      array1difficulty,
                                                      array1difficulty[0]);
   System.out.println(difficulty);
   if(difficulty == 0)
   {
      upper = 1;
      lower = 5;
   }
   if(difficulty == 1)
   {
      upper = 3;
      lower = 10;
   }
   if(difficulty == 2)
   {
      upper = 5;
      lower = 20;
   }
   if(difficulty == 3)
   {
      upper = 50;
      lower = 10000;
   }
   
   long startTime = System.currentTimeMillis();
   String streakLimit1 = (String) JOptionPane.showInputDialog(null,
		   											"Enter the streak to achieve", 
		   											"Streak", 
		   											JOptionPane.PLAIN_MESSAGE, 
		   											icon, 
		   											numberArrays, 
		   											numberArrays[0]);
   int streakLimit = Integer.parseInt(streakLimit1);
   System.out.println();
   
   
   
   
   long actualStartTime = System.currentTimeMillis();
   while(streak < streakLimit && attempts < 3 * streakLimit)
      {
	   startTime1 = System.currentTimeMillis();
         int n1 = (int)(Math.random() * lower - upper + 1) + lower;
         int n2 = (int)(Math.random() * lower - upper + 1) + lower;
         String guess1 = (String) JOptionPane.showInputDialog(null,
     		    		n1 + " x " + n2,
	                  "JOptionMania",
	                   JOptionPane.ERROR_MESSAGE,
	                   icon,
	                   null,
	                   "Type answer here.");
         int guess = Integer.parseInt(guess1);
         
         double stopTime1 = System.currentTimeMillis();
         totalTime1 = ((double)(stopTime1 - startTime1)/1000);         
         // Basically what I did here is that I made a new variable (long, because an int is too short for this number);
         // and i made it equal to the current time (System.currentTimeMillis();)
         
//         Here I made the time AFTER you answer the question a separate integer so you can subtract them later.
         
//         Here ^^ I made it so that it calculates the time between the two longs in seconds bc i divided by 1000
         // hope this helped you understand better, if you still dont, ask me questions at lunch (pull up to room 222)
         attempts++;
         //Check answer
         if(guess == n1 * n2)
         {    
            correct++;
            streak++;
            JOptionPane.showMessageDialog(null, "Correct! It took you " + totalTime1 + " seconds to answer this question.\n"
					, "MultiplyMania", JOptionPane.DEFAULT_OPTION, icon);
            System.out.println("Correct. It took you " + totalTime1 + " seconds tp answer this. ");
         }
         else
         {
     	    JOptionPane.showMessageDialog(null, "Incorrect! It took you " + totalTime1 + " seconds to answer this question.\n"
					, "MultiplyMania", JOptionPane.DEFAULT_OPTION, icon);
            streak = 0;
         }
         //end the while loop
      }
   long actualEndTime = System.currentTimeMillis();
     double actualTotalTime = ((double)(actualEndTime - actualStartTime)/1000);
     String[] buttonTextValues2 = {"Yes", "No"};
      if(streak == streakLimit)
      {
     	 JOptionPane.showMessageDialog(null, "Good job! It took you " + actualTotalTime + " seconds to answer to finish this round!\n"
					, "MultiplyMania", JOptionPane.DEFAULT_OPTION, icon);
     	 int ans = JOptionPane.showOptionDialog(null,
                     "Do you want to play again?",
                     "MultiplyMania",
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.NO_OPTION,
                     icon,
                     buttonTextValues2,
                     buttonTextValues2[0]); 
     	 if(ans == 0)
			{
				attempts = 1;
				correct = 0;
				streak = 0;
				difficulty = 0;
				startTime = 0;
				actualStartTime = 0;
				actualEndTime = 0;
				playAgain = "0";
			}
//      System.out.println("Good work! You got " + correct + " out of " + attempts + " attempts. It took you " + totalTime1 + " Seconds to finish.");
      }
      else
     	 JOptionPane.showMessageDialog(null, "Maybe next time!"
					, "MultiplyMania", JOptionPane.DEFAULT_OPTION, icon);
         System.out.println("Maybe next time.");

    }while(playAgain.toUpperCase().startsWith("Y"));
   
   System.out.println("Thanks for playing!");
       }
   
   }
