package java_task;

import static java_task.Main.in;

class Task2 { // имплементируем Rot13

    // исходный массив букв, сделала независимым от регистра
    private static String letters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    Task2() {

        String income, outcome;
        System.out.println("Введите строку для кодирования:");
        income = in.nextLine();
        outcome = encode_decode(income); // кодируем
        System.out.println("Закодированная строка: " + outcome);
        System.out.println("Раскодированная строка: " + encode_decode(outcome)); // декодируем

    }

    private String encode_decode(String income) { // функция кодирования/декодирования

        String outcome = "";
        char currentLetter;
        for(int i = 0; i < income.length(); i++) {
            currentLetter = income.charAt(i);
            if (letters.contains(String.valueOf(currentLetter))) { // проверяем, из алфавита символ или нет
                outcome = outcome + letters.charAt((letters.indexOf(currentLetter) + 26) % 52); // ищет нужный элемент для де/кодирования
            } else {
                outcome = outcome + currentLetter; // иначе оставляет символ тем же
            }
        }
        return outcome;
    }
}
