package com.perscholas.cafe3;

import java.util.Scanner;

public class Coffee extends Product {
    private boolean sugar;
    private boolean milk;

    public Coffee() {
        this.sugar = false;
        this.milk = false;
    }

    public Coffee(String name, double price, String description) {
        super(name, price, description);
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
    public void addOptions(Scanner scanner) {
        System.out.print("Would you like sugar with the coffee? (Y/N) : ");
        String wantSugar = scanner.next();
        sugar = (wantSugar.equals("Y") || wantSugar.equals("y")) ? true : false;

        System.out.print("Would you like milk with the coffee? (Y/N) : ");
        String wantMilk = scanner.next();
        milk = (wantMilk.equals("Y") || wantMilk.equals("y")) ? true : false;
    }

    @Override
    public void printOptions() {
        System.out.printf("Sugar: %s Milk: %s ",
                (sugar ? "Y" : "N"), (milk ? "Y" : "N"));
    }
}
