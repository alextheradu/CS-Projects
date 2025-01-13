import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args){
		System.out.println("Welcome to Alex's MadLibs!\n\n");
		Scanner sc = new Scanner(System.in);
		String fnreboot = "Y";
		while(fnreboot.equalsIgnoreCase("y"))
		{
			String madlib1 = "y";
			while(madlib1.equalsIgnoreCase("y"))
			{
				System.out.print("Enter a noun: ");
				String noun1 = sc.nextLine();
				System.out.print("Enter an adjective: ");
				String adjective = sc.nextLine();
				System.out.print("Enter an animal: ");
				String animal = sc.nextLine();
				System.out.print("Enter another noun: ");
				String noun2 = sc.nextLine();
				System.out.print("Enter another adjective: ");
				String adjective2 = sc.nextLine();
				System.out.println("Old Mother Hubbard went to the " + noun1.toUpperCase() + " to get her " + adjective.toUpperCase() + " " + animal.toUpperCase() + " a " + noun2.toUpperCase() + ". \nWhen she got there, the " + noun1.toUpperCase() + " was " + adjective2.toUpperCase() + ", and so her poor " + animal.toUpperCase() + " had none.\n\n");
				System.out.print("Do you want to play THIS MadLib again? [Y/N]: ");
				madlib1 = sc.nextLine();
			}
			
			String madlib2 = "y";
			while(madlib2.equalsIgnoreCase("Y"))
			{
				System.out.print("Enter a noun: ");
				String jnjnoun1 = sc.nextLine();
				System.out.print("Enter a type of container (Ex: A bucket): ");
				String containerjnj = sc.nextLine();
				System.out.print("Enter a type of liquid (Ex: Water): ");
				String liquidjnj = sc.nextLine();
				System.out.print("Enter another noun: ");
				String noun2jnj = sc.nextLine();
				System.out.print("Enter the name of a famous person: ");
				String famousperson = sc.nextLine();
				System.out.println("Jack and Jill went up the " + jnjnoun1.toUpperCase() + " to fetch a(n) " + containerjnj.toUpperCase() + " of " + liquidjnj.toUpperCase() + ". \nJack fell down and broke his " + noun2jnj.toUpperCase() + ", and \n" + famousperson.toUpperCase() + " came tumbling down after.");
				System.out.print("Do you want to play THIS MadLib again? [Y/N]: ");
				madlib2 = sc.nextLine();
			}
			System.out.println("\nDo you want to play from beginning? [Y/N]");
			fnreboot = sc.nextLine();
		}
		System.out.println("Thanks for playing my game!");
//		Jack and Jill went up the ____________________ to fetch a(n) ___________________ of
//		
//		____________________. Jack fell down and broke his ____________________, and
//		
//		____________________ came tumbling after.
//		


	}

}
