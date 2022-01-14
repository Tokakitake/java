/**
 * Java level 1 HomeWork 1
 * @author Muratov Nail
 * @version 16.12.2021
 */
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
        System.out.println((a + b >= 0) ? "Positive" : "Negative");
    }

    private static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value <= 100) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 4589;
        int b = 9438;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}
