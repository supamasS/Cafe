package com.perscholas.cafe3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CafeApp {
    protected static final double SALES_TAX = 7.5;
    protected static final String LINE = "-------------------------------------------------------------------------\n";
    protected static Scanner scanner;

    public static void main(String[] args) {
        Store store = new Store(
                new Coffee("Coffee", 3.95, "Plain coffee", false, false),
                new Espresso("Espresso", 4.95, "Strong black coffee", false, false),
                new Cappuccino("Cappuccino", 5.95, "Coffee with frothed milk", false, false));

        scanner = new Scanner(System.in);

        store.getOrder();

        scanner.close();
    }

    public static int getIntInput(String message) {
        boolean inputOK = false;
        int inputNum = 0;

        while(!inputOK) {

            System.out.print(message);

            try {
                inputNum = scanner.nextInt();
                inputOK = true;
            } catch(InputMismatchException e) {
                System.out.println("ERROR: Incorrect input format, please enter a number!");
            } finally {
                // need to clear buffer otherwise it will be infinite loop!
                scanner.nextLine();
            }
        }

        return inputNum;
    }

}
