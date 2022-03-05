package com.perscholas.cafe3;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> itemList;

    public Store() {
        this.itemList = new ArrayList<>();
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

    public void showMainMenu() {
        System.out.println("Please select from the following menu:");

        int i=1;
        for (Product product : itemList) {
            System.out.println(i + ". " + product.getName());
            i++;
        }
        System.out.println(i + ". Check Out");
    }
}
