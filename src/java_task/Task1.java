package java_task;

import static java.lang.Math.abs;
import static java.lang.Math.floorMod;
import static java_task.Main.in;

class Task1 { // имплементируем алгоритм Евклида с помощью веселых функций взятия остатка в Java.

    Task1() {

        int a, b;

        System.out.println("Введите первое число:"); // получаем значения для вычисления НОД
        a = Integer.valueOf(in.nextLine());
        System.out.println("Введите второе число:");
        b = Integer.valueOf(in.nextLine());

        int gcd1 = gcd1(a, b);
        System.out.println(gcd1 + " - используя %"); // будет давать отрицательные значения из-за реализации % (исправляется взятием модуля)

        int gcd2 = gcd2(a, b); // будет давать отрицательные значения из-за реализации floorMod (исправляется взятием модуля)
        System.out.println(gcd2 + " - используя floorMod");

        int gcd3 = gcd3(a, abs(b)); // не будет давать отрицательные значения.
        System.out.println(gcd3 + " - используя математический остаток");

    }

    // используя %, который возвращает значение, ближайшее к нулю
    private int gcd1(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd1(b, a % b);
        }
    }

    // используя floorMod, который возвращает значение, меньшее или равное частному
    private int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd2(b, floorMod(a,b));
        }
    }

    // используя rem
    private int gcd3(int a, int b) {
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