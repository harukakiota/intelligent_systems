package java_task;

import java.util.Scanner;

public class Main {

    public static void main (String args []) {

        Scanner in = new Scanner(System.in);
        int task;
        do {
            System.out.println("Введите номер задания, 0 для выхода");
            task = in.nextInt();
            switch (task) {
                case 1:
                    new Task1();
                    break;
                case 2:
                    new Task2();
                    break;
                case 0:
                    System.out.println("Have a nice day!");
                    break;
                default:
                    break;
            }
        } while (task!=0);
    }
}
