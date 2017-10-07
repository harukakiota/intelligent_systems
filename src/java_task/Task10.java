package java_task;

import java.math.BigInteger;
import java.util.Random;

import static java_task.Main.in;

class Task10 { // онлайн определитель палиндромов

    int x = 256; // значение взяла из примера, хотя на Википедии нашла только, что фиксируется x = 2. Полагаю, это верно для степеней двойки.
    long q = longRandomPrime(); // если х фиксирован, то q должен выбираться случайно из простых чисел

    Task10() {
        System.out.println("Онлайн определитель палиндромов. Вводите символы по одному или 'exit', чтобы выйти:");
        String str = "", input, substr1, substr2;
        int m;

        do { // пока символы вводятся
            input = in.nextLine();
            if (!input.equals("exit")) {
                substr1 = ""; substr2 = "";
                str = str + input.charAt(0); // добавляем введенный только что символ в строку всех введенных символов
                m = str.length()/2; // находим середину уже введенной строки
                substr1 = str.substring(0,(str.length()+1)/2); // берем первую половину
                substr2 = str.substring(str.length()/2, str.length()); // берем вторую половину, серединное значение неважно, если оно одно
                StringBuffer sbf = new StringBuffer(substr2);
                substr2 = sbf.reverse().toString(); // переворачиваем вторую подстроку

                if (hash(substr1, m) == hash(substr2, m)){ // теперь, если введен палиндром, подстроки должны быть идентичны, как и их хеши
                    System.out.println("'" + str + "' - да, это палиндром. (введите 'exit', чтобы закончить)");
                } else {
                    System.out.println("'" + str + "' - нет, это не палиндром (введите 'exit', чтобы закончить)");
                }
            }
        } while (!input.equals("exit"));
    }

    private long hash(String key, int m) { // функция хеширования Рабина-Карпа
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (x * h + key.charAt(j)) % q;
        return h;
    }

    private static long longRandomPrime() { // случайное большое простое число
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }
}
