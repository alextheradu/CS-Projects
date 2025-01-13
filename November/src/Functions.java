//Alex Radu
//Date: Nov 13, 2024

public class Functions
{
	//Alex Radu
	//Date: Nov 11, 2024

	public class MathProgram
	{
		public static boolean isPrime(int num)
		{
			boolean isPrime = true;
			for (int i = 2; i < num; i++)
				if (num % i == 0)
					isPrime = false;
			
			return isPrime;
			
		}
		public static float slope(float x1, float y1, float x2, 
	               float y2) 
		{ 
		 if (x2 - x1 != 0) 
		     return (y2 - y1) / (x2 - x1); 
		 return Integer.MAX_VALUE; 
		}
		public static boolean isOdd(int num)
		{
			boolean isOdd = true; if(num % 2 == 0) {isOdd = false;}; return isOdd;
		}
		public static boolean isEven(int num)
		{
			return num % 2 != 1;
		}
		public static String getDayName(int dayNum)
		{
			String getDayName = "Saturday";
			if(dayNum == 1)
				getDayName = "Sunday";
			if(dayNum == 2)
				getDayName = "Monday";
			if(dayNum == 3)
				getDayName = "Tuesday";
			if(dayNum == 4)
				getDayName = "Wednesday";
			if(dayNum == 5)
				getDayName = "Thursday";
			if(dayNum == 6)
				getDayName = "Friday";
			return getDayName;
		}
	}
		


}
