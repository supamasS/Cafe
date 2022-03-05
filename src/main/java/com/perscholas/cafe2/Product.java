package com.perscholas.cafe2;

import java.util.Scanner;

public abstract class Product {
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

    public void getUserInput(Scanner scanner) {
        System.out.print("Please enter the number of " + name + " : ");
        quantity = scanner.nextInt();
    }

    public void printSubtotal() {
        System.out.printf("%s - %s - Subtotal: $%.2f\n", name, description, subtotal);
    }
}
