import java.util.Scanner;

//Alex Radu
//Date: Oct 9, 2024

public class ExploringForLoops
{

	public static void main(String[] args)
	{
//		for(int i = 0; i <= 100; i++)
//		{
//			if(i % 2 == 0)
//			{
//				System.out.print(i + ", ");
//			}
//		}
//		System.out.println("\n\n\n");
//		for(int i = 100; i >= 0; i -= 1)
//		{
//			System.out.print(i + ", ");
//		}
//		System.out.println("\n\n");
//		for(int i = 1; i <= 20; i++) 
//		{
//			
//			System.out.println("√" + i + " = " + Math.sqrt(i));
//		}
//		char ch;
//		for(ch = 'A'; ch <= 'Z'; ++ch)
//		      System.out.print(ch + " ");
//		char cha;
//		System.out.println("");
//		for(cha = 'a'; cha <= 'z'; ++cha)
//		      System.out.print(cha + " ");
//		
//		System.out.println("\n" + Math.PI);
		Scanner sc = new Scanner(System.in);
		int wip = 1;
		for(int i = 1; i <= 5; i++)
		{
		System.out.print("Please enter a positive integer: ");
		int int1 = sc.nextInt();
		if(int1 == Math.abs(int1))
		{
			System.out.println("You entered " + int1);
			i = 5;
			wip = 0;
		}
		
		}
		if(wip == 1)
		{
			System.out.println("You somehow have not enter a positive integer after 5 tries.\nYOU FAILED THE TASK!");
		}

	}

}
