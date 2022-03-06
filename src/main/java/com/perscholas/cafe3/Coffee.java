package com.perscholas.cafe3;

public class Coffee extends Product implements Cloneable {
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
    public void addOptions() {
        sugar = getUserOption("sugar");
        milk = getUserOption("milk");
    }

    @Override
    public void printOptions() {
        System.out.printf("\t\tSugar: %s\tMilk: %s \n", (sugar ? "Yes" : "No"), (milk ? "Yes" : "No"));
    }

    @Override
    public Object clone() {
        return new Coffee(this.getName(), this.getPrice(), this.getDescription(), this.sugar, this.milk);
    }
}
