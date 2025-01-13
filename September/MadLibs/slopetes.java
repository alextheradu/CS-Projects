import java.io.*;
import java.util.Scanner;
//Alex Radu
//Date: Sep 27, 2024

public class slopetes { 
	public static float slope(float x1, float y1, float x2, 
               float y2) 
		{ 
		 if (x2 - x1 != 0) 
		     return (y2 - y1) / (x2 - x1); 
		 return Integer.MAX_VALUE; 
		} 
		public static void main1(String[] args) 
		{ 
		Scanner sc = new Scanner(System.in);
		System.out.print("Type x1: ");
		float x1 = sc.nextFloat();
		System.out.print("Type y1: ");
		float y1 = sc.nextFloat(); 
		System.out.print("Type x2: ");
		float x2 = sc.nextFloat(); 
		System.out.print("Type y2: ");
		float y2 = sc.nextFloat(); 
	
		 System.out.println("Slope is: "
		                    + slope(x1, y1, x2, y2)); 
		} 
}
