package java_task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

class Task5 { // ищем в src.zip все файлы .java, содержащие слова "transient" и "volatile"

     // так как оперируем со строками, а ключевые слова могут быть в разных строках, вводим два флага

    Task5() {
        Path start = Paths.get("data_for_task_5/"); // ищем в папке, в которую было распаковано
        int maxDepth = 10, countOfFiles = 0;
        boolean flagT, flagV;

        try (Stream<Path> fileStream = Files.walk(start, maxDepth)) { //сначала находим все подходящие файлы .java
            String[] paths = fileStream
                    .map(String::valueOf)
                    .filter(path -> path.endsWith(".java"))
                    .sorted().toArray(String[]::new);

            System.out.println("Подходящие файлы:");
            for (int i = 0; i < paths.length; i++) { //потом по каждому подходящему файлу ищем в его содержимом ключевые слова
                flagT = false; flagV = false;

                List<String> lines = Files.readAllLines(Paths.get(paths[i]));
                for (String x: lines) {
                    if (x.contains("transient")) { // файл содержит первое
                        flagT = true;
                    } else if (x.contains("volatile")) { // файл содержит второе
                        flagV = true;
                    }
                }
                if (flagT && flagV) { // если содержит оба, то он подходит
                    System.out.println(paths[i]);
                    countOfFiles++;
                }
            }
            /* а еще методом проб и ошибок я узнала, что файлов,
                в которых эти слова содержатся в какой-нибудь одной строчке одновременно всего на 6 меньше,
                чем тех, в которых оба слова могут быть разбросаны по всему файлу :С */
            System.out.println("Всего таких файлов = " + countOfFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}