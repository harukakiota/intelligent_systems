package java_task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.toIntExact;
import static java_task.Main.in;

class Task7 { // печатаем n случайных строк из указанного файла

    Task7(){

        System.out.println("Введите абсолютный путь к файлу:");
        Path path = Paths.get(in.nextLine()); // получаем  путь
        System.out.println("Введите желаемое количество случайных строк из файла на выходе:");
        int n = Integer.valueOf(in.nextLine()); // получаем нужное количество строк

        List<String> lines = new ArrayList<String>(getSize(String.valueOf(path))); // инициализируем List вычисленного размера

        try {
            lines = Files.readAllLines(path); // считываем все строки
        } catch (IOException e) { // обрабатываем исключения
            System.out.println("Ошибка ввода-вывода.");
            e.printStackTrace();
        }

        Random random = new Random(); // генератор случайных чисел
        int size = lines.size();
        for(int i = 0; i < n; i++) {
            System.out.println(lines.get(random.nextInt(size))); // печатаем случайную строку
        }

    }

    private int getSize(String path) { // вычисление предполагаемого размера
        File file = new File(path);
        long lengthByte = file.length();
        return toIntExact(lengthByte/256);
    }
}
