import java.util.Scanner;

//Alex Radu
//Date: Oct 23, 2024

public class ExploringTime
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
//		System.out.println(System.currentTimeMillis());
		double startTime = System.currentTimeMillis();
		System.out.print("Press enter to test: ");;
		sc.nextLine();
		double endTime = System.currentTimeMillis();
		System.out.println(((endTime - startTime)/1000) + " seconds passed since the program began.");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Float.MAX_VALUE);
	}

}
