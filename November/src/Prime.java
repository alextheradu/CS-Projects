//Alex Radu
//Date: Nov 11, 2024

public class Prime
{

	public static boolean isPrime(int num)
	{
		boolean isPrime = true;
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				isPrime = false;
		
		return isPrime;
	}

}
