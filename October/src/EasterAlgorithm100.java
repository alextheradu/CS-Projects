//Alex Radu
//Date: Oct 7, 2024

public class EasterAlgorithm100
{

	public static void main(String[] args)
	{
//		while(y<2125) 
		for(int i = 0; i <= 10; i++)
		{
			int y = 2024 + i;
			int a = y % 19;
			int b = y / 100;
			int c = y % 100;
			int d = b / 4;
			int e = b % 4;
			int g = (8 * b + 13) / 25;
			int h = (19 * a + b - d - g + 15) % 30;
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
			System.out.println("In the year " + y + ", Easter will be on " + month + " " + p + ".");
//			y = y + 1;
		}
				
//Divide a + 11 * h by 319 to get a quotient m. Ignore the remainder.
	}

}
