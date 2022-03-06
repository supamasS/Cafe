package com.perscholas.cafe2;

import java.util.Scanner;

public class Cappuccino extends Product {
    private boolean peppermint;
    private boolean whippedCream;

    public Cappuccino() {
        this.peppermint = false;
        this.whippedCream = false;
    }

    public Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream) {
        super(name, price, description);
        this.peppermint = peppermint;
        this.whippedCream = whippedCream;
    }

    public boolean isPeppermint() {
        return peppermint;
    }

    public void setPeppermint(boolean peppermint) {
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream() {
        return whippedCream;
    }

    public void setWhippedCream(boolean whippedCream) {
        this.whippedCream = whippedCream;
    }

    @Override
    public void calculateProductTotal() {
        double totalPrice = getPrice();

        if(peppermint)
            totalPrice += 2;

        if(whippedCream)
            totalPrice += 1;

        setSubtotal(getQuantity() * totalPrice);
    }

    @Override
    public void getUserInput(Scanner scanner) {
        System.out.print("Please enter the number of " + getName() + " : ");
        setQuantity(scanner.nextInt());

        System.out.print("Would you like peppermint? (Y/N) : ");
        String wantPeppermint = scanner.next().toUpperCase();
        peppermint = wantPeppermint.equals("Y");

        System.out.print("Would you like whipped cream? (Y/N) : ");
        String wantWhippedCream = scanner.next().toUpperCase();
        whippedCream = wantWhippedCream.equals("Y");
    }

    @Override
    public void printSubtotal() {
        System.out.printf("--- Current Order: %s - %s - Peppermint: %s Whipped Cream: %s ",
                getName(), getDescription(), (peppermint ? "Y" : "N"), (whippedCream ? "Y" : "N"));
        System.out.printf("  Subtotal: $%.2f\n", getSubtotal());
    }
}
