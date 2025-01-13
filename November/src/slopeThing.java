import java.text.DecimalFormat;

//Alex Radu
//Date: Nov 15, 2024

public class slopeThing
{

	public static void main(String[] args)
	{
		DecimalFormat format = new DecimalFormat("#.##");
		int random = (int)(Math.random() * 50 + 1);
		for(int i = 1; i<50; i++)
		{
			double x1 = ((Math.random() * 21) - 10);
			double y1 = ((Math.random() * 21) - 10);
			double x2 = ((Math.random() * 21) - 10);
			double y2 = ((Math.random() * 21) - 10);
			double slope = ExploringFunctions.slope(x1, y1, x2, y2);
			double distance = ExploringFunctions.distance(x1, y1, x2, y2);
			System.out.println("For the points A(" + x1 + ", " + y1 + ") "
				+ "and B(" + x2 + ", " + y2 + ")\n"
						+ "The distance is " + format.format(distance) + "\n"
								+ "The slope is " + format.format(slope) + "\n");
		}
	}

}
