package com.perscholas.cafe2;

import java.util.Locale;
import java.util.Scanner;

public class Coffee extends Product {
    private boolean sugar;
    private boolean milk;

    public Coffee() {
        this.sugar = false;
        this.milk = false;
    }

    public Coffee(String name, double price, String description, boolean sugar, boolean milk) {
        super(name, price, description);
        this.sugar = sugar;
        this.milk = milk;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    @Override
    public void calculateProductTotal() {
        setSubtotal(getQuantity() * getPrice());
    }

    @Override
    public void getUserInput(Scanner scanner) {
        System.out.print("Please enter the number of " + getName() + " : ");
        setQuantity(scanner.nextInt());

        System.out.print("Would you like sugar? (Y/N) : ");
        String wantSugar = scanner.next().toUpperCase();
        sugar = wantSugar.equals("Y");

        System.out.print("Would you like milk? (Y/N) : ");
        String wantMilk = scanner.next().toUpperCase();
        milk = wantMilk.equals("Y");
    }

    @Override
    public void printSubtotal() {
        System.out.printf("--- Current Order: %s - %s - Sugar: %s Milk: %s ",
                getName(), getDescription(), (sugar ? "Y" : "N"), (milk ? "Y" : "N"));
        System.out.printf("  Subtotal: $%.2f\n", getSubtotal());
    }
}
