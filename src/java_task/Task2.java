package java_task;

import java.util.Scanner;

class Task2 { // имплементируем Rot13

    // исходный массив букв, сделала независимым от регистра
    private static String letters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    Task2() {

        String income, outcome;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку для кодирования:");
        income = in.nextLine();
        outcome = encode_decode(income);
        System.out.println("Закодированная строка:" + outcome);
        System.out.println("Раскодированная строка:" + encode_decode(outcome));

    }

    private String encode_decode(String income) {

        String outcome = "";
        char currentLetter;
        for(int i = 0; i < income.length(); i++) {
            currentLetter = income.charAt(i);
            if (letters.contains(String.valueOf(currentLetter))) {
                outcome = outcome + letters.charAt((letters.indexOf(currentLetter) + 26) % 52); // ищет нужный элемент для де/кодирования
            } else {
                outcome = outcome + currentLetter;
            }
        }
        return outcome;
    }
}
