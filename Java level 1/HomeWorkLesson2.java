/**
 * Java level 1 HomeWork 2
 * @author Muratov Nail
 * @version 16.12.2021 - 17.12.2021
 */
public class HomeWorkLesson2 {
    public static void main(String[] args) {
        System.out.println(Between10And20(7, 7));
        System.out.println(Between10And20(0, 10));
        System.out.println(Between10And20(7, 77));

        NegativeOrPositive(0);
        NegativeOrPositive(-5);
        NegativeOrPositive(5);

        System.out.println(Negative(0));
        System.out.println(Negative(-11));
        System.out.println(Negative(11));

        RepeatString("Milk inside a bag of", 6);

        System.out.println(Years(2000));
        System.out.println(Years(1914));
        System.out.println(Years(1945));
        System.out.println(Years(1998));
        System.out.println(Years(1516));
    }

    static boolean Between10And20(int a, int b) {
        return a + b >= 10 && a + b <= 20 ;
    }

    static void NegativeOrPositive (int a) {
        System.out.println(a >= 0? "Positive" : "Negative");
    }

    static boolean Negative(int a) {
        return a < 0;
    }

    static void RepeatString(String s, int count) {
        for (int i = 0; i < count; i++ ) {
            System.out.println(s);
        }
    }

    static boolean Years(int y) {
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }
}
