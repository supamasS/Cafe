package com.perscholas.cafe3;

import java.util.Scanner;

public class CafeApp {
    public static void main(String[] args) {
        Store store = createStore();
        ShoppingCart shoppingCart = new ShoppingCart();

        store.showMainMenu();
        getOrder(store, shoppingCart);

        shoppingCart.checkout();
    }

    private static void getOrder(Store store, ShoppingCart shoppingCart) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice = scanner.nextInt();

        while(menuChoice-1 != store.getItemList().size()) {
            Product product = store.getItemList().get(menuChoice-1);

            // NEED to create a new object of the same type of the product from the store,
            // NOT using that object, otherwise, we can't order 2 different kind of espresso.

            product.getUserInput(scanner);
            shoppingCart.addItem(product);

            store.showMainMenu();
            menuChoice = scanner.nextInt();
        }

        scanner.close();
    }

    public static Store createStore() {
        Store store = new Store();

        store.addItem(new Coffee("Coffee", 3.95, "Plain coffee"));
        store.addItem(new Espresso("Espresso", 4.95, "Strong black coffee"));
        store.addItem(new Cappuccino("Cappuccino", 5.95, "Coffee with frothed milk"));

        return store;
    }


}
