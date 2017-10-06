package java_task;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java_task.Main.in;

class Task4 { // потоковая обертка над Scanner для конкретных типов

    Task4() {

        int type;
        do {
            System.out.println("Выберите тип данных в потоке (1 - integer, 2 - double, 3 - words, 4 - lines, 0 - выход):"); // выбираем тип
            type = Integer.valueOf(in.nextLine());
            try {
                switch (type) { // пусть Scanner читает System.in
                    case 1: // в случае int
                        System.out.println("Введите числа через пробел:"); // для примера берем ввод одной строки
                        IntStream intStream = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt); // получаем целочисленный поток из введенной строки
                        int sum = intStream.sum(); // для примера считаем сумму
                        System.out.println("Cумма чисел в вашем потоке = " + sum);
                        break;
                    case 2: // в случае double
                        System.out.println("Введите числа через пробел:"); // для примера берем ввод одной строки
                        DoubleStream doubleStream = Stream.of(in.nextLine().split(" ")).mapToDouble(Double::parseDouble); // получаем поток чисел из введенной строки
                        double avg = doubleStream.average().getAsDouble(); // для примера считаем среднее значение
                        System.out.println("Среднее значение чисел в вашем потоке = " + avg);
                        break;
                    case 3:
                        System.out.println("Введите слова через пробел:"); // для примера берем ввод одной строки
                        Stream wordStream = Stream.of(in.nextLine().split(" ")); // получаем поток слов из введенной строки
                        System.out.println("Количество введенных слов = " + wordStream.count()); // для примера выводим количество введенных слов
                        break;
                    case 4:
                        System.out.println("Количество строк, которое вы хотите ввести:"); // даем пользователю ограничить ввод
                        int n = Integer.valueOf(in.nextLine());
                        System.out.println("Введите строки:");
                        Stream lineStream = Stream.generate(() -> in.nextLine()).limit(n);
                        System.out.println("Количество строк, совпадающих с 'test' = " + lineStream.filter("test"::equals).count()); // для примера выводим количество строк, состоящих из слова "test"
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) { // обрабатываем исключение
                System.out.println("Неверный формат.");
            }
        } while (type!=0);
    }
}
