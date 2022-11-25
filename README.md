# ConnectFour
A popular game is called Connect Four. In this game, players choose a column and drop a red or yellow disc into it. Ths first player to "connect four" wins!

You will create a 4x4 two dimensional String array. You should fill the 2D array with empty strings. Then, use a loop to prompt the first player to choose a column. You will attempt to add a disc to this column. You will then check if the player has won. If not, you will prompt the second player to choose a column. You will repeat this process until a player wins or the 2D array is full. If the 2D array is full, print "No one wins!"

You will create and use the following methods in this assignment: 
- void printArray(Stringp[][] array)
- boolean isBoardFull(String[][] array)
  1. Returns TRUE if there's no empty space in the array, otherwise it returns FALSE
- void addDisc(String[][] array, int column, char player)
  1. Attempts to add the "player" symbol to the array at the lowest empty row of the 2D array at the column. Player 1 is an X, Player 2 is an O.
  2. Hint: Start at the top and keep checking the row below until you find one that's not empty.
- boolean winVertical(String[][] array, char player)
  1. Returns TRUE if there are 4 slots with the "player" symbol in a column. Return FALSE otherwise.
- boolean winHorizontal(String[][] array, char player)
  1. Returns TRUE if there are 4 slots with the "player" symbol in a row. Return FALSE otherwise.

You may optionally implement a winDiagonal(String[][] array, char player) method that checks if you won diagonally if 
