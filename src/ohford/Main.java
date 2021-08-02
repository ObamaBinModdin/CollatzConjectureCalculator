package ohford;

/*
 * Oscar Ford
 * Collatz Conjecture
 * 8/2/21 
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("The Collatz conjecture is a conjecture in mathematics that concerns sequences defined as follows:");
		System.out.println("start with any positive integer n. Then each term is obtained from the previous term as follows:");
		System.out.println("if the previous term is even, the next term is one half of the previous term. If the previous term is odd, the next ");
		System.out.println("term is 3 times the previous term plus 1. The conjecture is that no matter what value of n, the sequence will always reach 1.");
		System.out.println("Named after Lothar Collatz who introduced it in 1937 (Wikipedia).\n");

		boolean goAgain = true;
		while (goAgain == true)
		{
			System.out.println("---------------------------------------------------------------------------------------\n");

			Scanner kb = new Scanner(System.in);
			int input = 0;

			System.out.print("Enter a whole number: ");
			try
			{

				input = kb.nextInt();
				int steps = collatzCalc(input, 1);
				System.out.println("Took " + steps + " steps to get to 1");

			} catch (Exception e)
			{
				System.out.println("ERROR: ENTER ONLY A WHOLE NUMBER.");
			} finally
			{
				System.out.println();
				boolean invalidInput = false;
				do
				{
					System.out.print("Would you like to go again? ");
					String inputTwo = kb.next();
					if (inputTwo.equalsIgnoreCase("yes") || inputTwo.equalsIgnoreCase("y"))
					{
						goAgain = true;
						invalidInput = false;
					} else if (inputTwo.equalsIgnoreCase("no") || inputTwo.equalsIgnoreCase("n"))
					{
						goAgain = false;
						invalidInput = false;
					} else
					{
						invalidInput = true;
						System.out.println("Enter a yes or no");
					}
				} while (invalidInput == true);
				System.out.println();
			}
		}
	}

	public static int collatzCalc(int num, int steps)
	{
		if (num % 2 == 0 && num != 1)
		{
			System.out.printf("%-10s %5s %n", (num + "/2="), (num / 2));
			return collatzCalc(num / 2, ++steps);
		} else if (num % 2 == 1 && num != 1)
		{
			System.out.printf("%-10s %5s %n", ("3(" + num + ")+1="), ((num * 3) + 1));
			return collatzCalc((num * 3) + 1, ++steps);
		} else
		{
			return steps;
		}
	}
}
