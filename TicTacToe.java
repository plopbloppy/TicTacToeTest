import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static String turn(int i) {
        String turn = i % 2 == 0 ? "o" : "x";
        return turn;
    }

    public static void board(String[][] board, int i) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    public static void placePiece(String[][] board, int i, String userInput) {
        String letter = userInput.substring(0, 1);
        int number = Integer.parseInt(userInput.substring(1));
        int col;
        int row;

        switch (letter) {
            case "A": 
                col = 1;
                break;
            case "B":
                col = 2;
                break;
            case "C": 
                col = 3;
                break;
        }
        switch (number) {
            case 1: 
                row = 2;
                break;
            case 2:
                row = 3;
                break;
            case 3: 
                row = 4;
                break;
        } 
        board[col][row] = turn(i);
    }

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        final int MAX_TOLERANCE = 9;

        String[][] board = { { "   ", " A ", "B ", "C" },
                { "   ", " _ ", "_ ", "_" },
                { "1  ", "|_", "|_", "|_|" },
                { "2  ", "|_", "|_", "|_|" },
                { "3  ", "|_", "|_", "|_|" } };

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println(
                "In this game, your objective is to have three consequence pieces diagonally or in a row/column.");
        System.out.println("'o' plays first, and 'x' plays second.");
        System.out.println("To place your piece, enter the column and the row, in the form of 'A1'.");

        for (int i = 0; i < MAX_TOLERANCE; i++) {
            board(board, i);
            System.out.println("Turn: " + turn(i));

            System.out.println("Please enter your coordinates:");
            String input = keyboard.next();
            placePiece(board, i, input);
        }
    }
}
