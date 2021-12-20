/**
 * Java level 1 HomeWork 3
 * @author Muratov Nail
 * @version 18.12.2021
 */

import java.util.Arrays;
import java.util.Random;

public class HomeWorkLesson2 {
    static int[] array(int len, int initialValue) {
        int[] arr = new int [len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    static Random random = new Random();

    public static void main(String[] args) {
        replaceZeroToOneAndOneToZero();
        arrayOneHundred();
        lessThanSixMultiplyToTwo();
        arrayDiagonal();
        twoArgs();
    }

    static void replaceZeroToOneAndOneToZero() {
        System.out.println("Task #1");
        int [] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("After");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            }
            else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void arrayOneHundred() {
        System.out.println("Task #2");
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] += i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void lessThanSixMultiplyToTwo() {
        System.out.println("Task #3");
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void arrayDiagonal() {
        System.out.println("Task #4");
        int[] [] arr = new int[3] [3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i] [j] = random.nextInt(10);
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("After");
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][((arr.length - 1) - i)] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
        }
    }

    static void twoArgs() {
        System.out.println("Task #5");
        int[] arr = array(3, 777);
        System.out.println(Arrays.toString(arr));
    }
}