package com;

public class HomeWorkApp {
        public static void main(String[] args) {
            printThreeWords();
            checkSumSign();
            printColor();
            compareNumbers();
        }

    private static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple \n\n"); //Вывод в столбец слова
    }

    private static void checkSumSign() {
        int a = 5;
        int b = -5;
        int c = a + b;
        System.out.println("5+(-5)=" + c);
        if (c >= 0) {
            System.out.println("сумма положительна\n\n");
        }
        else {
            System.out.println("сумма отрицательна\n\n");
        }
    }
    
    private static void printColor() {
            int value = 100;
            if (value <= 0) {
                System.out.println("Красный");
            }
            else if (value > 0 && value <= 100 ) {
                System.out.println("Желтый");
            }
            else {
                System.out.println("Зеленый");
            }
    }

    private static void compareNumbers() {
        int a = 4589;
        int b = 9438;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }
}
