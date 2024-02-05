package com.example;

import java.util.Scanner;

public class App {

    // Scanner to take user input
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        // Variables to store user and computer moves, game status, and winner
        byte input;
        byte rand;
        byte i;
        boolean boxAvailable;
        byte winner = 0;

        // Array to represent the tic-tac-toe game board
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        // Display initial message
        System.out.println("Enter box number to select. Enjoy!\n");

        // Flag to track if the game board is empty or not
        boolean boxEmpty = false;

        // Main game loop
        while (true) {
            // Display the current state of the game board
            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

            // Reset the game board if it's not empty
            if (!boxEmpty) {
                for (i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            // Check if the game has been won or drawn
            if (winner == 1) {
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if (winner == 2) {
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if (winner == 3) {
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            // Get user input for their move
            System.out.print("Please make your move: ");

            // Check if the user has entered a valid move
            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else
                    System.out.println("Invalid input. Enter again.");
            }

            // Check if the user has won after their move
            if ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X')
                    || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') || (box[0] == 'X' && box[3] == 'X' && box[6] == 'X')
                    || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X')
                    || (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X')) {
                winner = 1;
                continue;
            }

            // Check if there are still available moves on the board
            boxAvailable = false;
            for (i = 0; i < 9; i++) {
                if (box[i] != 'X' && box[i] != 'O') {
                    boxAvailable = true;
                    break;
                }
            }

            // If no available moves, declare a draw
            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            // Computer makes a random move
            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }

            // Check if the computer has won after its move
            if ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O')
                    || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') || (box[0] == 'O' && box[3] == 'O' && box[6] == 'O')
                    || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O')
                    || (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O')) {
                winner = 2;
            }
        }
    }
}