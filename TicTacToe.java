import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static String turn(int i) {
        String turn = i % 2 == 0 ? "o" : "x";
        return turn;
    }

    public static void board(String[][] board, int i, int userInput) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].contains(Integer.toString(userInput))) {
                    board[row][col] = turn(i - 1);
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    // public static boolean hasSpace(String[][] board, int userInput) {
    //     boolean hasSpace = true;

    //     for (int row = 0; row < board.length; row++) {
    //         for (int col = 0; col < board[row].length; col++) {
    //             hasSpace = !board[row][col].contains("o") || !board[row][col].contains("x") ? false : true; 
    //         }
    //     } 
    //     return hasSpace;
    // }
    
    // public static String checkForWins() {
        
    // }

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        final int MAX_TOLERANCE = 9;
        int userInput = 0;

        String[][] board = { { "  ", " A  ", " B  ", " C  "},
                { "1 ", "___|", "___|", "___" },
                { "2 ", "___|", "___|", "___" },
                { "3 ", "___|", "___|", "___" } };
            
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println(
                "In this game, your objective is to have three consequence pieces diagonally or in a row/column.");
        System.out.println("'o' plays first, and 'x' plays second.");
        System.out.println("To place a piece, enter the coordinates in the form of 'A1'.");

        for (int i = 0; i < MAX_TOLERANCE; i++) { 
            try {
                board(board, i, userInput);
                System.out.println("Turn: " + turn(i));
                System.out.println("Please enter a coordinate to play:");
                userInput = keyboard.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Not a number from 1 to 9!");
            }
        }
    }
}