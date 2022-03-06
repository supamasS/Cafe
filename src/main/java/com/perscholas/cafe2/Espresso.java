package com.perscholas.cafe2;

import java.util.Scanner;

public class Espresso extends Product {
    private boolean extraShot;
    private boolean macchiato;

    public Espresso() {
        this.extraShot = false;
        this.macchiato = false;
    }

    public Espresso(String name, double price, String description, boolean extraShot, boolean macchiato) {
        super(name, price, description);
        this.extraShot = extraShot;
        this.macchiato = macchiato;
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isMacchiato() {
        return macchiato;
    }

    public void setMacchiato(boolean macchiato) {
        this.macchiato = macchiato;
    }

    @Override
    public void calculateProductTotal() {
        double totalPrice = getPrice();

        if(extraShot)
            totalPrice += 2;

        if(macchiato)
            totalPrice += 1;

        setSubtotal(getQuantity() * totalPrice);
    }

    @Override
    public void getUserInput(Scanner scanner) {
        System.out.print("Please enter the number of " + getName() + " : ");
        setQuantity(scanner.nextInt());

        System.out.print("Would you like extra shot? (Y/N) : ");
        String wantExtraShot = scanner.next().toUpperCase();
        extraShot = wantExtraShot.equals("Y");

        System.out.print("Would you like macchiato? (Y/N) : ");
        String wantMacchiato = scanner.next().toUpperCase();
        macchiato = wantMacchiato.equals("Y");
    }

    @Override
    public void printSubtotal() {
        System.out.printf("--- Current Order: %s - %s - Extra Shot: %s Macchiato: %s ",
                getName(), getDescription(), (extraShot ? "Y" : "N"), (macchiato ? "Y" : "N"));
        System.out.printf("  Subtotal: $%.2f\n", getSubtotal());
    }
}
