package java_task;

import java.util.Scanner;
import static java.lang.Math.*;

public class Task1 {

    public static void main (String args []) {

        int a, b;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число:"); // получаем значения для вычисления НОД
        a = in.nextInt();
        System.out.println("Введите второе число:");
        b = in.nextInt();

        int gcd1 = gcd1(a, b);
        System.out.println(gcd1); // будет давать отрицательные значения из-за реализации % (исправляется взятием модуля)

        int gcd2 = gcd2(a, b); // будет давать отрицательные значения из-за реализации floorMod (исправляется взятием модуля)
        System.out.println(gcd2);

        int gcd3 = gcd3(a, abs(b)); // не будет давать отрицательные значения.
        System.out.println(gcd3);
    }

    // используя %, который возвращает значение, ближайшее к нулю
    private static int gcd1(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd1(b, a % b);
        }
    }

    // используя floorMod, который возвращает значение, меньшее или равное частному
    private static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd2(b, floorMod(a,b));
        }
    }

    // используя rem
    private static int gcd3(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int rem = (b+(a%b))%b; /*на википедии это описано как нахождение неотрицательного остатка при условии, что b>0
            то есть лёгкое решение - взять модули a и b, тогда математически их НОД не будет отличаться  от НОДа этих же чисел
            с любыми знаками. Здесь гарантия неотрицательности мне нужна только от b */
            return gcd3(b, rem);
        }
    }
}