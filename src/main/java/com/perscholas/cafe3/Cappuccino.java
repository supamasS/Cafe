package com.perscholas.cafe3;

public class Cappuccino extends Product implements Cloneable {
    private boolean peppermint;
    private boolean whippedCream;

    public Cappuccino() {
        this.peppermint = false;
        this.whippedCream = false;
    }

    public Cappuccino(String name, double price, String description) {
        super(name, price, description);
    }

    public Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream) {
        super(name, price, description);
        this.peppermint = peppermint;
        this.whippedCream = whippedCream;
    }

    public boolean isPeppermint() {
        return peppermint;
    }

    public void setPeppermint(boolean peppermint) {
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream() {
        return whippedCream;
    }

    public void setWhippedCream(boolean whippedCream) {
        this.whippedCream = whippedCream;
    }

    @Override
    public void calculateProductTotal() {
        double totalPrice = getPrice();

        if(peppermint)
            totalPrice += 2;

        if(whippedCream)
            totalPrice += 1;

        setSubtotal(getQuantity() * totalPrice);
    }

    @Override
    public void addOptions() {
        peppermint = CafeApp.getUserOption("peppermint");
        whippedCream = CafeApp.getUserOption("whipped cream");
    }

    @Override
    public void printOptions() {
        System.out.printf("\t\tPeppermint: %s\tWhipped Cream: %s \n",
                            (peppermint ? "Yes (Add $2)" : "No"), (whippedCream ? "Yes (Add $1)" : "No"));
    }

    @Override
    public Object clone() {
        return new Cappuccino(this.getName(), this.getPrice(), this.getDescription());
    }
}
