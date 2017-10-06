package java_task;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main (String args []) {

        int task;
        do {
            System.out.println("Введите номер задания, 0 для выхода"); // выбираем задание
            task = in.nextInt();
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
