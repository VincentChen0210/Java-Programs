// The "J2_ChenV" class.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class J2_ChenV
{

    public static void main (String[] args)
    {
	int choice;

	do
	{
	    System.out.println ("Menu:");
	    System.out.println ("1 - Tournament Selection");
	    System.out.println ("2 - Magic Squares");
	    System.out.println ("3 - Arrival Time");
	    System.out.println ("4 - Quit");
	    System.out.println ();
	    System.out.print ("Your selection: ");
	    choice = ReadLib.readInt ();
	    System.out.println ();

	    if (choice == 1)
	    {
		tournament ();
	    }
	    else if (choice == 2)
	    {
		magicSquares ();
	    }
	    else if (choice == 3)
	    {
		arrivalTime ();
	    }
	    System.out.println ();
	}
	while (choice != 4);

	System.out.println ("You have chosen to exit this program.");
    } // main method


    public static void tournament ()
    {
	final int MAX = 100;
	final char WIN = 'W';
	String[] lines = new String [MAX];
	int numPlayers = 0;

	try
	{
	    String line;

	    BufferedReader reader;
	    reader = new BufferedReader (new FileReader ("P1DATA.TXT"));
	    numPlayers = Integer.parseInt (reader.readLine ());

	    for (int lineCount = 0 ; lineCount < numPlayers ; lineCount++)
	    {
		line = reader.readLine ();
		String temp[] = line.split (",");

		lines [lineCount] = "";
		for (int i = 0 ; i < 6 ; i++)
		{

		    lines [lineCount] = lines [lineCount] + temp [i];


		}
	    }
	    reader.close ();
	}
	catch (IOException e)
	{
	    e.printStackTrace ();
	}

	int[] numWins = new int [MAX];

	for (int i = 0 ; i < numPlayers ; i++)
	{

	    for (int k = 0 ; k < 6 ; k++)
	    {

		if (lines [i].charAt (k) == WIN)
		{
		    numWins [i]++;
		}
	    }

	    switch (numWins [i])
	    {
		case 5:
		case 6:
		    System.out.println ("[" + lines [i] + "]: Group 1");
		    break;
		case 3:
		case 4:
		    System.out.println ("[" + lines [i] + "]: Group 2");
		    break;
		case 1:
		case 2:
		    System.out.println ("[" + lines [i] + "]: Group 3");
		    break;
		default:
		    System.out.println ("Eliminated");
		    break;
	    }

	}
    }


    public static void magicSquares ()
    {
	int[] [] square = new int [4] [4];
	int numSquares = 0;

	try
	{

	    String line;
	    BufferedReader reader;
	    reader = new BufferedReader (new FileReader ("P2DATA.TXT"));
	    int tempSum;
	    int counter = 0;

	    numSquares = Integer.parseInt (reader.readLine ());

	    for (int x = 0 ; x < (numSquares * 4) ; x++)
	    {
		boolean magic = true;
		int[] hSum = new int [4];
		int[] vSum = new int [4];

		line = reader.readLine ();
		String temp[] = line.split (" ");
		tempSum = 0;

		for (int i = 0 ; i < 4 ; i++)
		{

		    square [counter] [i] = Integer.parseInt (temp [i]);

		}


		counter++;

		if (((x + 1) % 4 == 0) && (x != 0))
		{
		    for (int i = 0 ; i < 4 ; i++)
		    {
			for (int k = 0 ; k < 4 ; k++)
			{
			    vSum [i] = vSum [i] + square [i] [k];
			    hSum [k] = hSum [k] + square [i] [k];

			}
		    }

		    tempSum = hSum [0];


		    for (int i = 0 ; i < 4 ; i++)
		    {

			if (tempSum != hSum [i])
			{
			    magic = false;

			}
			if (tempSum != vSum [i])
			{
			    magic = false;

			}

		    }

		    if (magic == true)
		    {
			System.out.println ("Magic (sum of " + tempSum + ")");
		    }
		    else
		    {
			System.out.println ("Not magic");
		    }
		    counter = 0;
		}
	    }
	    reader.close ();
	}
	catch (IOException e)
	{
	    e.printStackTrace ();
	}
    }


    public static void arrivalTime ()
    {
	int hours, mins, totalTime, numLines;
	double drivingTime = 0;
	final int MORNINGSTART = 420, MORNINGEND = 600;
	final int AFTERNOONSTART = 960, AFTERNOONEND = 1140;

	try
	{
	    String line;
	    BufferedReader reader;
	    reader = new BufferedReader (new FileReader ("P3DATA.TXT"));
	    numLines = Integer.parseInt (reader.readLine ());

	    DecimalFormat time = new DecimalFormat ("00");

	    for (int i = 0 ; i < numLines ; i++)

		{
		    totalTime = 0;
		    drivingTime = 0;
		    line = reader.readLine ();
		    String temp[] = line.split (":");

		    hours = Integer.parseInt (temp [0]);
		    mins = Integer.parseInt (temp [1]);

		    totalTime = hours * 60 + mins;

		    while (drivingTime != 120)
		    {
			if ((totalTime >= MORNINGSTART) && (totalTime < MORNINGEND))
			{
			    drivingTime += 0.5;
			}
			else if ((totalTime >= AFTERNOONSTART) && (totalTime < AFTERNOONEND))
			{
			    drivingTime += 0.5;
			}
			else
			{
			    drivingTime++;
			}
			totalTime++;

		    }

		    if (totalTime >= 1440)
		    {
			totalTime = totalTime - 1440;
		    }

		    mins = totalTime % 60;
		    hours = totalTime / 60;

		    System.out.println (time.format (hours) + ":" + time.format (mins));
		}
	}
	catch (IOException e)
	{
	    e.printStackTrace ();
	}

    }
} // J2_ChenV class


