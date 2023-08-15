
import java.util.Scanner;

public class GFG {

	
	public static void guessingNumberGame()
	{
		Scanner sc = new Scanner(System.in);

		int number = 1 + (int)(100	* Math.random());

		int trials = 10;

		int i,gussedNumber;

		System.out.println("guess the number between 1 to 100 in 10 attempts");

		for ( i = 1; i <= trials; i++) {

			System.out.println("please Guess the number");
			gussedNumber = sc.nextInt();

			if (number == gussedNumber) 
			{
				System.out.println(	"Congratulations!"	+ " You guessed the number in "+(i+1)+ " attempts");
				break;
			}
			else if ((number > gussedNumber) && (i != trials))
			 {
				System.out.println("The number is greater than from " + gussedNumber);
			}
			else if ((number < gussedNumber)	&&(i != trials))
			 {
				System.out.println("The number is less than from " + gussedNumber);
			}
		
	if (i == trials)
		 {
			System.out.println(	"You have exhausted 10 trials.");

			System.out.println("The number was " + number);
		}
	}
	}
	public static void main(String arg[])
	{
		guessingNumberGame();
	}
}
