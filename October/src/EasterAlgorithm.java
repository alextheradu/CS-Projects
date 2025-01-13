//Alex Radu
//Date: Oct 2, 2024

public class EasterAlgorithm
{

	public static void main(String[] args)
	{
//		String whileloop = "open";
		for(int i = 1; i <= 150; i++)
//		while(whileloop.equalsIgnoreCase("open"))
		{
		int y = 2024 + i;
		int a = y % 19;
		int b = y / 100;
		int c = y % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (9 * a + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int n = (h - m + r + 90) / 25;
		int p = (h - m + r + n + 19) % 32;
		String month = "n/a";
		if(n == 3)
			
		{
			month = "March";
		}
		if(n == 4)
		{
			month = "April";
		}
//		System.out.println("In the year " + y + ", Easter will be on " + month + " " + p + ".");
		if(n == 4 && n == 3)
		{
//			whileloop = "end";
			System.out.println("In the year " + y + ", Easter will be on " + month + " " + p + ".");
			
		}
//		}
		if(p == 7 && n == 4)
		{
			System.out.println("In the year " + y + ", Easter will be on " + month + " " + p + ".");
		}
		}
	}
}
				
//Divide a + 11 * h by 319 to get a quotient m. Ignore the remainder.
	



