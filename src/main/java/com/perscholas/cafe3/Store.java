package com.perscholas.cafe3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    List<Product> itemList;

    public Store(Product ...products) {
        this.itemList = new ArrayList<>();
         this.itemList.addAll(Arrays.asList(products));
        // same as above
        // Arrays.stream(products).forEach(p -> this.itemList.add(p));
    }

    public void getOrder() {
        ShoppingCart shoppingCart = new ShoppingCart();

        int listIndex = getMenuChoice() - 1;

        while(listIndex != getItemList().size()) {
            // Create a new object of the same type of the product from the store,
            // NOT using that object directly,
            // otherwise we can't have multiple orders of espresso with different options.
            Product product = (Product)getItemList().get(listIndex).clone();

            product.getUserInputQuantity();
            product.addOptions();

            shoppingCart.addItem(product);

            listIndex = getMenuChoice() - 1;
        }

        shoppingCart.checkout();
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public void setItemList(List<Product> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Product product) {
        itemList.add(product);
    }

    public String getMainMenuMessage() {
        StringBuilder message = new StringBuilder(CafeApp.LINE);

        message.append("Please select from the following menu:\n");

        int i=1;
        for (Product product : itemList) {
            message.append(i++).append(". ").append(product.getName()).append("\n");
        }

        message.append(i).append(". Check Out\n");

        return message.toString();
    }

    public int getMenuChoice() {
        return CafeApp.getIntInput(getMainMenuMessage());
    }
}
