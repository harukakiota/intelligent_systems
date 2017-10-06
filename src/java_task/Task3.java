package java_task;

import static java.lang.Math.pow;
import static java_task.Main.in;

class Task3 { // имплементируем перевод из шестнадцатеричной системы в десятичную

    Task3() {
        String income;
        System.out.println("Введите число в шестнадцатеричном формате (с заглавными буквами):"); // получаем число в 16-м формате
        income = in.next();
        System.out.println("Это число в десятичной системе = " + hex_to_dec(income)); // инверстируем и выводим
    }

    private long hex_to_dec(String hex) { // функция конвертации 16-й в 10-ю
        long decimal = 0;
        String numbers = "0123456789ABCDEF"; // индекс совпадает с реальным значением
        int length = hex.length(), base = 16; // переменная длины входной строки и переменная основания исчисления, из которого переводим
        for (int i = 0; i < length; i++) {
            decimal+= (numbers.indexOf(hex.charAt(i)))*(pow(base,(length - i - 1))); // функция перевода каждого разряда
        }
        return decimal;
    }
}
