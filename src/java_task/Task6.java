package java_task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java_task.Main.in;

public class Task6 {

    Task6() {

        System.out.println("Введите символ для поиска в файле:");
        char symbol = in.nextLine().charAt(0); // считываем символ и переводим в char
        int count = 0;

        try (Stream<String> stream = Files.lines(Paths.get("data_for_task_6/123.txt"))) { // берем файл и считываем все строки
            List<String> lines = stream
                    .filter(line -> line.contains(String.valueOf(symbol))) // фильтруем те, в которых точно есть этот символ
                    .map(String::trim)
                    .collect(Collectors.toList());

            List<Character> lineInChar; // для использования удобной функции подсчета переводим каждую строку в List<Character>
            for (String x: lines) {
                lineInChar = x.chars().mapToObj(e->(char)e).collect(Collectors.toList());
                count+= Collections.frequency(lineInChar,symbol); // считаем количество этого символа в данной строке
            }

            System.out.println(count);
        } catch (IOException e) { // обрабатываем исключение
            System.out.println("Ошибка ввода-вывода.");
            e.printStackTrace();
        }

    }
}
