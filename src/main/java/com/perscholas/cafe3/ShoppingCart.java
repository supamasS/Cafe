package com.perscholas.cafe3;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    static final double SALES_TAX = 7.5;

    List<Product> cartList;
    double subtotal;

    public ShoppingCart() {
        this.cartList = new ArrayList<>();
        subtotal = 0.0;
    }

    public List<Product> getCartList() {
        return cartList;
    }

    public void setCartList(List<Product> cartList) {
        this.cartList = cartList;
    }

    public void addItem(Product product) {
        cartList.add(product);

        product.calculateProductTotal();
        product.printSubtotal();
        subtotal += product.getSubtotal();
    }

    public void checkout() {
        System.out.println("\nProceed to checkout...\n");
        System.out.println("Order Summary:");

        cartList.forEach(p -> p.printSubtotal());

        System.out.println("-----------------------------");
        System.out.printf("\nPurchase Subtotal: $%.2f\n", subtotal);

        double addedSalesTax = SALES_TAX/100.0 * subtotal;
        System.out.printf("Sales Tax: $%.2f\n", addedSalesTax);

        double total = subtotal + addedSalesTax;
        System.out.printf("Purchase Total: $%.2f\n", total);
    }
}
