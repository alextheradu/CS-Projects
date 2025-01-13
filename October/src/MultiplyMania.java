import java.text.DecimalFormat;
import java.util.Scanner;
//Alex Radu
//Date: Oct 17, 2024

public class MultiplyMania
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to " + "\033[3mMultiplyMania\033[0m\n");
		System.out.print("Press enter to start: ");
		sc.nextLine();
		int x = 1;
		int y = 12;
		int at = 0;
		double rt = 0;
		double total = 0;
		DecimalFormat format = new DecimalFormat("#.00");
		int playagain1 = 1;
		int tryagain2 = 0;
		int streak = 0;
		int difficulty = 0;
		int questions = 0;
		double startTime = 0;
		String mode = "n/a";
			while(playagain1 == 1)
				{
				double actualStartTime = System.currentTimeMillis();
				System.out.print("\nWhat difficulty do you want to play?\n1. Easy 2. Medium 3. Hard 4. Expert 5. Master 6. Impossible: ");
				difficulty = sc.nextInt();
					if(difficulty == 1)
						{
						y = 10;
						mode = "easy";
						}
					if(difficulty == 2)
						{
						x = 3;
						y = 17;
						mode = "medium";
						}
					if(difficulty == 3)
						{
						y = 25;
						mode = "hard";
						}
					if(difficulty == 4)
						{
						y = 50;
						mode = "expert";
						}
					if(difficulty == 5)
						{
						y = 100;
						mode = "master";
						}
					if(difficulty == 6)
						{
						y = 1000;
						mode = "impossible";
						}
				while(tryagain2 == 0)
					{
						System.out.print("\nEnter how many questions you want to answer: ");
						questions = sc.nextInt();
						System.out.print("\nEnter how many you want to get correct in a row: ");
						streak = sc.nextInt();
						if(streak > questions)
						{
							System.out.println("\nTry again (You can't have more answers than questions.)");
						}
						else
						tryagain2 = 1;
					}
					System.out.println();
				while(at != streak && total != questions)
					{
						int num1 = (int)(Math.random() *(y - x + 1)) + x;
						int num2 = (int)(Math.random() *(y - x + 1)) + x;
						startTime = System.currentTimeMillis();
						System.out.print(num1 + " x " + num2 + " = ");
						int hum_ans = sc.nextInt();
						double endTime = System.currentTimeMillis();
						double totalTime = (endTime - startTime)/1000;
						int answer = num1 * num2;
						total = total + 1;
						if(answer == hum_ans)
							{
								System.out.println("Correct! It took you " + format.format(totalTime) + " seconds to answer this question.\n"
										+ "	 In a row: " + (at+1) + "    Questions remaining until streak end: " + ((streak - at) - 1) + "\n");
								at++;
								rt++;
								
							}
						else
							{
								at = 0;
								System.out.println("Incorrect! It took you " + format.format(totalTime) + " seconds to answer this question.\nQuestions remaining until streak end: " + ((streak - at) - 1) + "\n");
							}
						
						
						}
							double actualEndTime = System.currentTimeMillis();
							System.out.println("\nYou got " 
							+ (int) rt + " out of " +  (int) total + " questions correct (" 
							+ (format.format(100 * rt/ total)) + "%) on " + mode.toUpperCase() + " mode in " 
							+ format.format((double)((actualEndTime - actualStartTime) / 1000) + " seconds."));
							sc.nextLine();
							System.out.print("Do you want to play again? (y/n): ");
							String ans = sc.nextLine();
							if(ans.toLowerCase().startsWith("y"))
							{
								playagain1 = 1;
								tryagain2 = 0;
								streak = 0;
								difficulty = 0;
								questions = 0;
								rt = 0;
								at = 0;
								total = 0;
								playagain1 = 1;
							}
							else
							{
								playagain1 = 0;
								System.out.println("Thanks for playing my game!");
							}
						}
				
			}
}		