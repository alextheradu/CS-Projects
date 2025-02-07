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
	public static int slope(int x1, int y1, int x2, 
               int y2) 
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

	public static void main(String[] args) {
	    int x1 = 1, y1 = 2, x2 = 3, y2 = 4;
	    int result = slope(x1, y1, x2, y2);
	    System.out.println("The slope of the line is: " + result);
	}
}


