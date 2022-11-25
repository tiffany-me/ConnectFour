import java.util.*;
public class ConnectFour {
    public static void printArray(String[][] array){
        for (String[] strings : array) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("|" + strings[j]);
            }
            System.out.println("|");
        }
    }
    public static boolean isBoardFull(String[][] array){
        for (String[] strings : array) {
            for (int j = 0; j < array.length; j++) {
                if (strings[j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void addDisc(String[][] array, int column, char player){
        for(int i = array.length - 1; i >= 0; i--){
            if(array[i][column].equals(" ")) {
                array[i][column] = String.valueOf(player);
                break;
            }
        }
    }
    public static boolean columnFull(String[][] array, int column){
        return !array[0][column].equals(" ");
    }
    public static boolean winHorizontal(String[][] array, char player){
        String symbol = String.valueOf(player);
        for(int i = 0; i < array.length; i++){
            if(array[i][0].equals(symbol) && array[i][1].equals(symbol) && array[i][2].equals(symbol) && array[i][3].equals(symbol)){
                return true;
            }
        }
        return false;
    }
    public static boolean winVertical(String[][] array, char player){
        String symbol = String.valueOf(player);
        for(int j = 0; j < array.length; j++){
            if(array[0][j].equals(symbol) && array[1][j].equals(symbol) && array[2][j].equals(symbol) && array[3][j].equals(symbol)){
                return true;
            }
        }
        return false;
    }
    public static boolean winDiagonal(String[][] array, char player){
        String symbol = String.valueOf(player);
        return (array[3][0].equals(symbol) && array[2][1].equals(symbol) && array[1][2].equals(symbol) && array[0][3].equals(symbol))
                || (array[0][0].equals(symbol) && array[1][1].equals(symbol) && array[2][2].equals(symbol) && array[3][3].equals(symbol));
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String[][] array = new String[4][4];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                array[i][j] = " ";
            }
        }

        System.out.println("[Connect Four]");
        char symbol = ' ';
        boolean win = false;

        while(!isBoardFull(array) && !win){
            int x = 1;
            while(x <= 2){
                System.out.print("Player " + x + ", enter a column: ");
                int column = input.nextInt();

                while(columnFull(array, column)){
                    System.out.print("Invalid column, try again: ");
                    column = input.nextInt();
                }

                if(x == 1){
                    symbol = 'X';
                }
                else{
                    symbol = 'O';
                }

                addDisc(array, column, symbol);
                System.out.println();
                printArray(array);
                System.out.println();

                if(winVertical(array, symbol) || winDiagonal(array, symbol) || winHorizontal(array, symbol)){
                    System.out.println("Player " + x + " wins!");
                    win = true;
                    break;
                }
                x++;
            }
        }
        if(!win){
            System.out.println("No one wins!");
        }
    }
}
