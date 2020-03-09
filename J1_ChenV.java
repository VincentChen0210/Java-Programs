// The "J1_ChenV" class.
// Name: Vincent Chen
// Date: 02/04/2019
// Purpose: Game of Craps programmed with Java
public class J1_ChenV   {
    public static void main (String[] args) {
	final int high = 6, low = 1;
	int dice1, dice2, total, wager, guess, balance = 200;
	String message;

	do  {
	    do  {
		System.out.print ("Enter your guess (2-12): ");
		guess = ReadLib.readInt ();
		if (guess == -1)    {
		    break;
		}
	    }
	    while (guess < 2 || guess > 12);
	    
	    if (guess == -1)    {
		break;
	    }
	    
	    do  {
		System.out.print ("Enter your wager: ");
		wager = ReadLib.readInt ();
	    }
	    while (wager > balance || wager < 1);

	    dice1 = (int) (Math.random () * high + low);
	    dice2 = (int) (Math.random () * high + low);

	    System.out.println();
	    System.out.println("Dice Values = " + dice1 + " " + dice2);
	    total = dice1 + dice2;

	    System.out.println("Total = " + total);
	    
	    if (guess == total) {
		message = "Congratulations! You've won $" + wager + "!";
		balance = balance + wager;
	    }
	    else    {
		message = "Oops! Better Luck Next Time! You lost $" + wager + "!";
		balance = balance - wager;
	    }
	    
	    System.out.println(message);
	    System.out.println("Balance = $" + balance);
	    System.out.println();
	}
	while (balance > 0);
	
	if (guess == -1)    {
	    System.out.println("You have chose to end the game! Thanks for playing, and we hope to see you again!");
	}
	else    {
	    System.out.println("You have lost all your money! Thanks for playing, and we hope to see you again!");
	}
    } // main method
} // J1_ChenV class
