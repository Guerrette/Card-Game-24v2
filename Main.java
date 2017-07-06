import java.util.Scanner;
/**
 * Main class allows for user input to test 4 numbers in a deck of cards
 * @author Patrick
 *
 */
public class Main 
{

	public static void main(String[] args) 
	{
		boolean contin = true;
		//tells user directions
		System.out.println("Enter a string of 4 numbers where each number is seperated by spaces from 1-13 or  k for 13 q for 12 or j for 11: ");
		//while loop to enter multiple times
		while(contin)
		{
			Scanner kbd = new Scanner(System.in);
			String s = kbd.nextLine();
			if(s .equals("bye") || s.equals("Bye")) // if user types bye program ends
			{
				break;
			}
			double check = PostFixOp.Math(s); //Evaluate and print formula if = 24
			if(check == -888)
			{
				System.out.println("Invalid input try again: ");
			}
			else
			{
				System.out.println("Enter a new set of numbers: ");
			}
			
			
			
		}
	}

}
