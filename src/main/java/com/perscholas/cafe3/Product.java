package com.perscholas.cafe3;

public abstract class Product implements Cloneable {
    private String name = "product";
    private double price;
    private String description;
    private int quantity;

    private double subtotal;

    public Product() {
    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public abstract void calculateProductTotal();

    public abstract void addOptions();

    public abstract void printOptions();

    public void getUserInputQuantity() {
        quantity = CafeApp.getIntInput("Please enter the number of " + getName() + " : ");
    }

    public void printSubtotal() {
        System.out.print(CafeApp.LINE);
        System.out.printf("Item:\t%-20s\tPrice: $%.2f\tQty: %d\tSubtotal: $%.2f\n",
                            name, price, quantity, subtotal);
        printOptions();
    }

    @Override
    public abstract Object clone();
}
