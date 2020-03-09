# Java Programs
2 programs created for assignments in Grade 12 programming class

### J1_ChenV: Simple craps game

In this program, the user is able to play a simple version of the dice game Craps.

In this game, the user make wagers on the outcome of the roll of a pair of dice. The user may bet as much money as they have, as they are only playing against the computer.
If the correct dice roll is guessed, the user earns the amount of money they initially wagered. If they incorrectly guess the dice roll, they lose the amount of money wagered.

The game automatically ends when the player has lost all their money.

### J2_ChenV: Various file reading programs

In this program, the user may choose between 3 different file reading programs, all which require no user input. To see different outputs, the coresponding text files must be changed.
At the start of every text file, the number of inputs is indicated on it's own line. The program will continue to run until the user has chosen to exit the program.

Elements used:
- Text file reading
  - BufferedReader & FileReader classes, IOException
- Void functions
- If statements
- Looping statements

##### 1 - Tournament Selection

This subprogram reads a file named "P1DATA.txt" containing serveral 'win-loss' records and groups these records based on number of wins.

Unique elements used:
- String arrays
- Switch statement

##### 2 - Magic Squares

This subprogram reads a file named "P2DATA.txt" containing several 4x4 numerical arrays and outputs whether or not the 4x4 array is a "magic square" (all rows and columns sum up to the same value).
If the array is a magic square, the sum for each line is also included.

Unique elements used:
- 2D array

##### 3 - Arrival time

This subprogram reads a file named "P3DATA.txt" containing several time stamps. These time stamps represent departure times for 2-hour long car trips.
During the day, there are certain "peak traffic" hours where travelling takes twice as long as it would outside of peak traffic hours. These hours are from 7 AM to 10 AM and 4 PM to 7 PM.
The subprogram calculates the corresponding arrival time given the departure time.

Unique elements used:
- Constants
- Integer parsing
