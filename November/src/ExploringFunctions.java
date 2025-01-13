//Alex Radu
//Date: Nov 13, 2024

public class ExploringFunctions
{

	//Alex Radu
	//Date: Nov 11, 2024


		public static boolean isPrime(int num)
		{
			boolean isPrime = true;
			for (int i = 2; i < num; i++)
				if (num % i == 0)
					isPrime = false;
			
			return isPrime;
			
		}
		public static double slope(double x1, double y1, double x2, double y2) 
		{ 
		 double slope = 0;
		 if (x2 - x1 != 0) 
		     slope = (y2 - y1) / (x2 - x1); 
		 return slope;
		}
		public static double distance(double x1, double y1, double x2, double y2) 
		{ 
		 double distance = 0;
		 if (x2 - x1 != 0 && y2 - y1 != 0) 
			 distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		 return distance;
		}
		
		public static boolean isEven(int num)
		{
			return num % 2 != 1;
		}
		public static String getDayName(int dayNum)
		{
			String getDayName = "non existent";
			if(dayNum == 1)
				return "Sunday";
			if(dayNum == 2)
				return "Monday";
			if(dayNum == 3)
				return "Tuesday";
			if(dayNum == 4)
				return "Wednesday";
			if(dayNum == 5)
				return "Thursday";
			if(dayNum == 6)
				return "Friday";
			if(dayNum == 7)
				return "Saturday";
			return getDayName;
		}
		public static boolean isInRectangle(double x, double y, double w, double h, double xm, double ym)
		{
			return false;
		}
	
}
