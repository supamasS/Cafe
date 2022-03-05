package com.perscholas.cafe3;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

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
        product.calculateProductTotal();
        product.printSubtotal();
        cartList.add(product);
        subtotal += product.getSubtotal();
    }

    public void checkout() {
        System.out.println("\nProceed to checkout...\n");
        System.out.print(CafeApp.LINE);
        System.out.println("Order Summary:");

        cartList.forEach(Product::printSubtotal);
        // cartList.forEach(p -> p.printSubtotal());   // same as above

        printTotal();
    }

    private void printTotal() {
        System.out.print(CafeApp.LINE);
        System.out.printf("Purchase Subtotal: $%.2f\n", subtotal);

        double salesTax = CafeApp.SALES_TAX/100.0 * subtotal;
        System.out.printf("Sales Tax: $%.2f\n", salesTax);

        double total = subtotal + salesTax;
        System.out.printf("Purchase Total: $%.2f\n", total);
        System.out.print(CafeApp.LINE);
    }
}
