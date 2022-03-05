package com.perscholas.cafe3;

import java.util.Scanner;

public class Cappuccino extends Product {
    private boolean peppermint;
    private boolean whippedCream;

    public Cappuccino() {
        this.peppermint = false;
        this.whippedCream = false;
    }

    public Cappuccino(String name, double price, String description) {
        super(name, price, description);
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
    public void addOptions(Scanner scanner) {
        System.out.print("Would you like peppermint? (Y/N) : ");
        String wantPeppermint = scanner.next();
        peppermint = (wantPeppermint.equals("Y") || wantPeppermint.equals("y")) ? true : false;

        System.out.print("Would you like whipped cream? (Y/N) : ");
        String wantWhippedCream = scanner.next();
        whippedCream = (wantWhippedCream.equals("Y") || wantWhippedCream.equals("y")) ? true : false;
    }

    @Override
    public void printOptions() {
        System.out.printf("Peppermint: %s Whipped Cream: %s ",
                (peppermint ? "Y" : "N"), (whippedCream ? "Y" : "N"));
    }
}
