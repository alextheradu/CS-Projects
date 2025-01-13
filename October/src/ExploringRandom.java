import java.util.Random;

//Alex Radu
//Date: Oct 14, 2024

public class ExploringRandom
{

	public static void main(String[] args)
	{
		
		Random rand = new Random();
//		   int rand_int1 = rand.nextInt(100);
//		   int rand_int2 = rand.nextInt(100);
//		   int rand_int3 = rand.nextInt(100);
//		   int rand_int4 = rand.nextInt(100);
//		//    int rand_int1 = 0;
//		   System.out.println(rand_int1);
//		   System.out.println(rand_int2);
//		   System.out.println(rand_int3);
//		   System.out.println(rand_int4);
//		   System.out.println((int) (Math.random() * 6));
		int firstNum = 100;
		int secondNum = 1000;
		int randomNum = 1;
		int attempts = 0;
			while(randomNum < 1000)
			{
				
				
				randomNum = (int)(Math.random() *(secondNum - firstNum + 1)) + firstNum;
				attempts = attempts + 1;
				System.out.println(randomNum);
			}
		System.out.println("It took " + attempts + " attempts to get to 1000.");
	}

}
