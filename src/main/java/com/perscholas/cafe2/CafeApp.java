package com.perscholas.cafe2;

import java.util.Scanner;

public class CafeApp {
    public static void main(String[] args) {
        Product coffee = new Coffee("Coffee", 3.95, "Plain coffee", false, false);
        Product espresso = new Espresso("Espresso", 4.95, "Strong black coffee", false, false);
        Product cappuccino = new Cappuccino("Cappuccino", 5.95, "Coffee with frothed milk", false, false);

        Scanner scanner = new Scanner(System.in);

        coffee.getUserInput(scanner);
        coffee.calculateProductTotal();
        coffee.printSubtotal();

        espresso.getUserInput(scanner);
        espresso.calculateProductTotal();
        espresso.printSubtotal();

        cappuccino.getUserInput(scanner);
        cappuccino.calculateProductTotal();
        cappuccino.printSubtotal();

        scanner.close();

        checkout(coffee, espresso, cappuccino);
    }

    private static void checkout(Product coffee, Product espresso, Product cappuccino) {
        System.out.println("--------- Project 2: Check Out -----------");

        double subtotal = coffee.getSubtotal() + espresso.getSubtotal() + cappuccino.getSubtotal();
        System.out.printf("Subtotal : $%.2f\n", subtotal);

        final double SALES_TAX = 7.5;
        double addedSalesTax = SALES_TAX/100 * subtotal;
        System.out.printf("Sales Tax : $%.2f\n", addedSalesTax);

        double total = subtotal + addedSalesTax;
        System.out.printf("Total : $%.2f\n", total);
    }
}
