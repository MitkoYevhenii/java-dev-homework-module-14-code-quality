package com.example;

import java.util.Scanner;

public class TicTacToeGame {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new TicTacToeGame().startGame();
    }

    private void startGame() {
        char[] box = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        boolean boxEmpty = false;
        byte winner = 0;

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            displayBoard(box);

            if (!boxEmpty) {
                resetBoard(box);
                boxEmpty = true;
            }

            winner = checkGameStatus(box, winner);

            if (winner != 0) {
                displayResult(winner);
                break;
            }

            userMove(box);
            winner = checkWinner(box, 'X');

            if (winner == 1 || winner == 3) {
                continue;
            }

            if (!isMoveAvailable(box)) {
                winner = 3;
                continue;
            }

            computerMove(box);
            winner = checkWinner(box, 'O');
        }
    }

    private void displayBoard(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private void resetBoard(char[] box) {
        for (int i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    private byte checkGameStatus(char[] box, byte winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
        return winner;
    }

    private void displayResult(byte winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    private void userMove(char[] box) {
        System.out.print("Please make your move: ");
        while (true) {
            byte input = scan.nextByte();
            if (isValidMove(input, box)) {
                box[input - 1] = 'X';
                break;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private boolean isValidMove(byte input, char[] box) {
        return input > 0 && input < 10 && box[input - 1] != 'X' && box[input - 1] != 'O';
    }

    private byte checkWinner(char[] box, char symbol) {
        if ((box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol)) {
            return (symbol == 'X') ? (byte) 1 : (byte) 2;
        }
        return 0;
    }

    private boolean isMoveAvailable(char[] box) {
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return true;
            }
        }
        return false;
    }

    private void computerMove(char[] box) {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }
}
