package java_task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.toIntExact;

class Task9 {

    Task9() { // ссставляем стрим из чередующихся элементов двух других стримов

        Stream first = Stream.iterate(1, n -> n + 2).limit(100); // 2 стрима, для наглядности первый состоит из нечетных чисел до 100
        Stream second = Stream.iterate(2, n -> n + 2).limit(200); // а второй из четных чисел до 200

        Stream outcome = zip(first, second); // применяем функцию, передавая сами стримы
        outcome.forEach(i -> System.out.print(i + " ")); // выводим результирующий стрим через пробел
        System.out.println();
    }

    public static Stream zip(Stream first, Stream second) { // требующаяся функция

        List f = (List) first.collect(Collectors.toList()); // передаем стримы в List, чтобы не потерять данные
        List s = (List) second.collect(Collectors.toList()); // и не словить исключение, что стрим закрыт

        long size = (f.size() < s.size() ? f.size() : s.size()); // находим меньший по размеру

        List list = new ArrayList(toIntExact(size*2)); // выделяем точное количество места под конечный стрим

        for(int i = 0; i < size*2; i++) { // несложным if чередуем элементы из одного и другого списка и добавляем их в результирующий
            if (i%2 == 0) {
                list.add(f.get(i/2));
            } else {
                list.add(s.get(i/2));
            }
        }
        return list.stream(); // возвращаем результат
    }
}
