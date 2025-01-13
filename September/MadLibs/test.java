import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Alex's Anventure!\n\n");
		System.out.print("Type Y and click enter to start: ");
		String easy1 = sc.nextLine();
		if(easy1.equalsIgnoreCase("y"))
		{
			System.out.println("\nWelcome ");
			System.out.print("You are currently in a secluded jungle somewhere in South America.\nYou were knocked out and don't remember how or when you got to where you are now.");
			System.out.print("\nDo you want to either:\n1. Try to use the satelite feature on your iPhone 15 to call emergency services.\n2. Stay perfectly still to try and see if there are any animals around that might pounce on you.\nType what you want to do [1 or 2]: ");
			String easy2 = sc.nextLine();
			if(easy2.equalsIgnoreCase("1"))
				{
				System.out.println("You spin around aimlessly, but can't connect to the satelite. Your phone says that if you try again you might succeed.");
				System.out.print("Do you want to try again? [Y/N]");
				String phone1 = sc.nextLine();
				if(phone1.equalsIgnoreCase("Y"))
					{
					System.out.println("You try again but just as you lifted your phone in the air, a group of tigers spotted you and pounced. Game over. \nRe-run project to start over.");	
					}
				else
					{
					 //Ask Mr. Uhl how to go to line 33 from like 28
					 System.out.println("You attempt to stand still, and you were just in time. A group of tigers runs by you as they chase their prey. \nIf you had moved, you would have been in mortal danger.");
					 System.out.println("Do you want to either: \n1. Climb a tree to scope out the surroundings. \n2. Go the opposite the direction from the tigers.\nPlease type 1 or 2: ");
						String tigers1 = sc.nextLine();
						if(tigers1.equalsIgnoreCase("1"))
							{
								System.out.println("You see that there is a cell tower about 2 miles away, but you also noticed a river in the way.\nDo you want to attempt to: \n1. Cross the river.\n2. Avoid the river and walk an additional 5 miles around it?\nPlease type 1 or 2: ");
								String celltower1 = sc.nextLine();
								if(celltower1.equalsIgnoreCase("1"))
									{
										System.out.println("You get to the river and notice a log that has fallen and you might be able to walk across it to get to the other side.");
									}
								else
									{
										System.out.println(2);
									}
							}
						else
							{
								System.out.println(2);
							}
					}
				}
			
			else
				{
					System.out.println("You attempt to stand still, and you were just in time. A group of tigers runs by you as they chase their prey. \nIf you had moved, you would have been in mortal danger.");
					System.out.println("Do you want to either: \n1. Climb a tree to scope out the surroundings. \n2. Go the opposite the direction from the tigers.\nPlease type 1 or 2: ");
					String tigers1 = sc.nextLine();
					if(tigers1.equalsIgnoreCase("1"))
						{
							System.out.println("You see that there is a cell tower about 2 miles away, but you also noticed a river in the way.\nDo you want to attempt to: \n1. Cross the river.\n2. Avoid the river and walk an additional 5 miles around it?\nPlease type 1 or 2: ");
							String celltower1 = sc.nextLine();
							if(celltower1.equalsIgnoreCase("1"))
								{
									System.out.println(1);
								}
							else
								{
									System.out.println(2);
								}
						}
					else
						{
							System.out.println(2);
						}
				}
		}
		else
		{
			System.out.println("How did you mess up the first instruction? Unacceptable :(");
		}
	}

}
