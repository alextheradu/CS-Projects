
//Name:
//Program description: Honors Computer Science Assignment-Using Output
//Date:
public class UsingOutputAssignment
{
public static void main(String[] args)
{
	//Exercise #1-4
	System.out.println("Exercise 1 \n+--------+\n|  Alex  |\n+--------+\n\nExercise 2\n \\\\\\\\////\n |      |\n(| O  O |)\n \\   C  /\n  \\ -- /\n   \\__/\n\n Exercise 3\n+---+---+---+\n|   |   |   | \n+---+---+---+\n|   |   |   |\n+---+---+---+\n|   |   |   |\n+---+---+---+\n\n Exercise 4\n             +---+\n             |   |\n         +---+---+\n         |   |   |\n     +---+---+---+\n     |   |   |   |\n +---+---+---+---+\n |   |   |   |   |\n +---+---+---+---+");
	
	//Exercise #5
	String name = "Alex";
	int age = 14;
	String favColor = "green";
	//Write a println statement to report the value of the variables above.
	//Your println cannot contain the words "Steve" or "blue" or the number 16.
	System.out.println(name + ", a " + age + " year old, likes the color " + favColor + ".");
	//Exercise #6
	
	//Part 6a
	System.out.println("3 + 4"); //I think this is going to print 3 + 4 because it is a literal string.
	//Part 6b
	System.out.println(3 + 4); //I think this is going to print 7 because it is going to add the numbers.
	//Part 6c
	System.out.println(3 + "4"); //I think this is going to print 34 because it is going to combine the two numbers.
	//Part 6d
	System.out.println("3" + 4 + 5); //I think this is going to print 345 because it will get confused and print them all.
	//Part 6e
	System.out.println("The sum is " + 3 + 4); //I think this is going to print 34 because it will print 3 and 4 separately.
	//Part 6f
	int sum = 7;
	System.out.println("The sum is " + sum);
	//Exercise #7
	String myText = "\n+--------+\n|  Alex  |\n+--------+";
	System.out.println(myText);
}
}
