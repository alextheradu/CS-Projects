import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

//Alex Radu
//Date: Oct 17, 2024

public class JOptionMania
{

//	JOptionPane + MultiplyMania = JOptionMania
	public static void main(String[] args)
	{
		Font font1 = new Font("Minecraft", Font.PLAIN, 30);
		ImageIcon icon = new ImageIcon(JOptionMania.class.getResource("icon.png"));
		ImageIcon icon2 = new ImageIcon(JOptionMania.class.getResource("icon2.png"));
		UIManager.put("OptionPane.messageForeground", Color.black); // Font color
		UIManager.put("Panel.background", Color.WHITE); // Main window background color
		UIManager.put("OptionPane.background", new Color(245, 245, 247)); // Window border color
		UIManager.put("OptionPane.messageFont", font1); // Font for window message
		UIManager.put("TextField.font", font1); // Font for inputMessageDialog boxes
		UIManager.put("Button.foreground", new Color(245, 245, 247)); // Color for the button text
		UIManager.put("OptionPane.buttonFont", font1); // Font for the buttons
		UIManager.put("Button.foreground", Color.GRAY); // Color for the button text
		UIManager.put("OptionPane.buttonFont", font1); // Font for the buttons
		Color outerBorderColor = Color.WHITE;
		Color innerBorderColor = Color.WHITE;
		Border margin1 = new MatteBorder(2, 2, 2, 2, outerBorderColor);
		Border lineBorder1 = BorderFactory.createLineBorder(innerBorderColor, 6);
		CompoundBorder cb = new CompoundBorder(margin1, lineBorder1);
		UIManager.put("Button.border", cb); // Border for the buttons
		UIManager.put("Button.opaque", true); // Buttons setting
		UIManager.put("Button.background", Color.WHITE); // Color for the button text
		JOptionPane.showMessageDialog(null, "Alex Radu", null, 0, icon);
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
		int tryagain3 = 0;
		int tryagain4 = 0;
		double startTime = 0;
		double actualStartTime = 0;
		String mode = "n/a";
		double timeLimit = 0;
		String[] dropDownOptions1 =
		{ "Choose a Value", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Other" };
		String[] dropDownOptions2 =
		{ "Choose a Value", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Other", "Infinite" };
		String[] buttonTextValues =
		{ "Easy", "Medium", "Hard", "Expert", "Master", "Impossible" };
		while (playagain1 == 1)
		{

			difficulty = JOptionPane.showOptionDialog(null, "What difficulty do you want to play?", "MultiplyMania",
					JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION, icon, buttonTextValues, buttonTextValues[0]);
			if (difficulty == 0)
			{
				y = 10;
				mode = "easy";
				timeLimit = 5;
			}
			if (difficulty == 1)
			{
				x = 3;
				y = 17;
				mode = "medium";
				timeLimit = 10;
			}
			if (difficulty == 2)
			{
				y = 25;
				mode = "hard";
				timeLimit = 25;
			}
			if (difficulty == 3)
			{
				y = 50;
				mode = "expert";
				timeLimit = 30;
			}
			if (difficulty == 4)
			{
				y = 100;
				mode = "master";
				timeLimit = 40;
			}
			if (difficulty == 5)
			{
				y = 1000;
				mode = "impossible";
				timeLimit = 60;
			}
			while (tryagain2 == 0)
			{
				while (tryagain3 == 0)
				{
					String dropSelection = (String) JOptionPane.showInputDialog(null,
							"How many questions do you want to answer?", "MultiplyMania",
							JOptionPane.PLAIN_MESSAGE, icon, dropDownOptions2, dropDownOptions2[0]);
					if (dropSelection.equalsIgnoreCase("infinite"))
					{
						questions = 2147483639;
						tryagain3 = 1;
					}
					if (dropSelection.equalsIgnoreCase("other"))
					{
						String questions1 = (String) JOptionPane.showInputDialog(null,
								"Enter how many questions you want to answer", "Madlibs",
								JOptionPane.ERROR_MESSAGE, icon2, null, "Type answer here.");
						questions = Integer.parseInt(questions1);
						tryagain3 = 1;
					}
					if (dropSelection.equalsIgnoreCase("1") || dropSelection.equalsIgnoreCase("2")
							|| dropSelection.equalsIgnoreCase("3") || dropSelection.equalsIgnoreCase("4")
							|| dropSelection.equalsIgnoreCase("5") || dropSelection.equalsIgnoreCase("6")
							|| dropSelection.equalsIgnoreCase("7") || dropSelection.equalsIgnoreCase("8")
							|| dropSelection.equalsIgnoreCase("9") || dropSelection.equals("10"))
					{
						questions = Integer.parseInt(dropSelection);
						tryagain3 = 1;
						System.out.println();
					}

				}
				System.out.println("You selected: " + questions);

				while (tryagain4 == 0)
				{
					String dropSelection = (String) JOptionPane.showInputDialog(null,
							"What streak do you want to get to?", "MultiplyMania", JOptionPane.PLAIN_MESSAGE,
							icon, dropDownOptions1, dropDownOptions1[0]);
					if (dropSelection.equalsIgnoreCase("other"))
					{
						String questions1 = (String) JOptionPane.showInputDialog(null,
								"Enter how many questions you want to answer", "MultiplyMania",
								JOptionPane.ERROR_MESSAGE, icon2, null, "Type answer here.");
						streak = Integer.parseInt(questions1);
						tryagain4 = 1;
					}
					if (dropSelection.equalsIgnoreCase("1") || dropSelection.equalsIgnoreCase("2")
							|| dropSelection.equalsIgnoreCase("3") || dropSelection.equalsIgnoreCase("4")
							|| dropSelection.equalsIgnoreCase("5") || dropSelection.equalsIgnoreCase("6")
							|| dropSelection.equalsIgnoreCase("7") || dropSelection.equalsIgnoreCase("8")
							|| dropSelection.equalsIgnoreCase("9") || dropSelection.equals("10"))
					{
						streak = Integer.parseInt(dropSelection);
						tryagain4 = 1;
						System.out.println();
					}
					if (streak > questions)
					{
						JOptionPane.showMessageDialog(null,
								"Try again (You can't have more answers than questions.)", "MultiplyMania",
								JOptionPane.DEFAULT_OPTION, icon);
						tryagain3 = 0;
						tryagain4 = 0;

						System.out.println("\nTry again (You can't have more answers than questions.)");
					} else
						tryagain2 = 1;

					System.out.println();
					actualStartTime = System.currentTimeMillis();
					while (at != streak && total != questions)
					{
						int num1 = (int) (Math.random() * (y - x + 1)) + x;
						int num2 = (int) (Math.random() * (y - x + 1)) + x;
						startTime = System.currentTimeMillis();

						int answer = num1 * num2;
						System.out.println("The answer is: " + answer);
						String hum_ans1 = (String) JOptionPane.showInputDialog(null, num1 + " x " + num2,
								"MultiplyMania", JOptionPane.ERROR_MESSAGE, icon2, null, "Type answer here.");
						int hum_ans = Integer.parseInt(hum_ans1);
						double endTime = System.currentTimeMillis();
						double totalTime = (endTime - startTime) / 1000;
						total = total + 1;

						if (answer == hum_ans)
						{
							JOptionPane.showMessageDialog(null,
									"Correct! It took you " + format.format(totalTime)
											+ " seconds to answer this question.\n" + "	 In a row: "
											+ (at + 1) + "    Questions remaining until streak end: "
											+ ((streak - at) - 1) + "\n",
									"MultiplyMania", JOptionPane.DEFAULT_OPTION, icon2);
							at++;
							rt++;
						}

						else
						{
							at = 0;
							JOptionPane.showMessageDialog(null, "Incorrect! It took you "
									+ format.format(totalTime)
									+ " seconds to answer this question.\nQuestions remaining until streak end: "
									+ ((streak - at) - 1) + "\n", "MultiplyMania", JOptionPane.DEFAULT_OPTION,
									icon2);
						}

					}
					double actualEndTime = System.currentTimeMillis();
					JOptionPane.showMessageDialog(null, "\nYou got " + (int) rt + " out of " + (int) total
							+ " questions correct (" + (format.format(100 * rt / total)) + "%) on "
							+ mode.toUpperCase() + " mode in "
							+ (format.format((double) ((actualEndTime - actualStartTime) / 1000))) + " seconds.",
							"MultiplyMania", JOptionPane.DEFAULT_OPTION, icon2);

					String[] buttonTextValues2 =
					{ "Yes", "No" };
					int ans = JOptionPane.showOptionDialog(null, "Do you want to play again?", "MultiplyMania",
							JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION, icon, buttonTextValues2,
							buttonTextValues2[0]);
					if (ans == 0)
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
						startTime = 0;
						actualStartTime = 0;
						actualEndTime = 0;
					}

					else
					{
						playagain1 = 0;
						JOptionPane.showMessageDialog(null, "Thanks for playing my game!", "MultiplyMania",
								JOptionPane.DEFAULT_OPTION, icon);
					}
				}
			}
		}
	}
}