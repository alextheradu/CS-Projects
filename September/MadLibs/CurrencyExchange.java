import java.util.Scanner;

//Alex Radu
//Date: Sep 28, 2024

public class CurrencyExchange
{
	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in))
		{
			System.out.print("Value of the Romanian Leu worth as of this moment: ");
			double leu = sc.nextDouble();
			System.out.print("Value of the American Dollar worth as of this moment: ");
			double dollar = sc.nextDouble();
			System.out.print("Value of the European Euro worth as of this moment: ");
			double euro = sc.nextDouble();
			System.out.print("What currency would you like to convert?\n1. US Dollars\n2. Romanian Leu\n3. European Euro\nType one:");
			int currency1 = sc.nextInt();
			System.out.print("How much of that currency would you like to convert: ");
			double quantity1 = sc.nextDouble();
			if(currency1 == 1)
			{
				double value1 = (quantity1 * dollar) / leu;
				double value2 = (quantity1 * dollar) / euro;
				System.out.println(quantity1 + " dollar(s) is worth \n" + value1 + " RON\n" + value2 + " EURO");
			}
			if(currency1 == 2)
			{
				double value1 = (quantity1 * leu) / dollar;
				double value2 = (quantity1 * leu) / euro;
				System.out.println(quantity1 + " RON is worth \n" + value1 + " DOLLAR(s)\n" + value2 + " EURO");
			}
			if(currency1 == 3)
			{
				double value1 = (quantity1 * euro) / leu;
				double value2 = (quantity1 * euro) / dollar;
				System.out.println(quantity1 + " EURO is worth \n" + value1 + " RON\n" + value2 + " DOLLAR(s)");
			}
		}
		
	}
}
