/**
 * Java level 1 HomeWork 4
 * @author Muratov Nail
 * @version 21.12.2021
 */

import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    final int SIZE = 3;
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    final String MSG_FOR_HUMAN = "Enter X and Y";
    final String MSG_YOU_WON = "You Won!";
    final String MSG_YOU_LOSE = "You Lose!";
    final String MSG_DRAW = "Draw!";
    final String MSG_GAME_OVER = "Game Over";
    char[] [] table;
    Scanner sc;
    Random rng;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        table = new char[3] [3];
        sc = new Scanner(System.in);
        rng = new Random();
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (isWin(SIGN_X)) {
                System.out.println(MSG_YOU_WON);
                break;
            }
            if (isTableFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
            turnAI();
            printTable();
            if (isWin(SIGN_O)) {
                System.out.println(MSG_YOU_LOSE);
                break;
            }
            if (isTableFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
        }
        printTable();
        System.out.println(MSG_GAME_OVER);
    }
    void initTable() {
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table.length; y++) {
                table[x][y] = SIGN_EMPTY;
            }
        }
    }

    void printTable() {
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table.length; y++) {
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.print(MSG_FOR_HUMAN);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    void turnAI() {
        int x, y;
        do {
            x = rng.nextInt(3);
            y = rng.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    boolean isWin(char ch) {
        for (int i = 0; i < SIZE; i++) {
            if (table[i][0] == ch && table[i][1] == ch && table[i][2] == ch || table[0][i] == ch && table[1][i] == ch && table[2][i] == ch) {
                return true;
            }
        }
        return false;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return table[y][x] == SIGN_EMPTY;
    }

    boolean isTableFull() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}