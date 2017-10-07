package java_task;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main (String args []) {

        int task;
        do {
            System.out.println("Введите номер задания (от 1 до 10) или 0, чтобы выйти"); // выбираем задание
            task = Integer.valueOf(in.nextLine());
            switch (task) {
                case 1:
                    new Task1();
                    break;
                case 2:
                    new Task2();
                    break;
                case 3:
                    new Task3();
                    break;
                case 4:
                    new Task4();
                    break;
                case 5:
                    new Task5();
                    break;
                case 6:
                    new Task6();
                    break;
                case 7:
                    new Task7();
                    break;
                case 8:
                    new Task8();
                    break;
                case 9:
                    new Task9();
                    break;
                case 10:
                    new Task10();
                    break;
                case 0:
                    System.out.println("Have a nice day!");
                    break;
                default:
                    break;
            }
        } while (task!=0); // выход, если нажат 0

        in.close(); // закрываем сканнер
    }
}
