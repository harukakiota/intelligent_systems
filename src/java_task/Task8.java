package java_task;

import java.util.stream.LongStream;

class Task8 { // реализация псевдорандомного генератора

    private long a = 0x5DEECE66DL, // константы в 16-м формате
            c = 0xBL, m = 1L << 48;

    Task8() {

        LongStream stream = LongStream.iterate(13L, n -> (n * a + c) % m) //создаем поток с вычислением последовательности
                .limit(1000); // ограничиваем, к примеру, 1000
        System.out.println("Полученные числа с х0 = 13:");
        stream.forEach(i -> System.out.print(i + " ")); // выводим последовательность
        System.out.println();
    }

}
