package com.perscholas.cafe3;

public class Espresso extends Product implements Cloneable {
    private boolean extraShot;
    private boolean macchiato;

    public Espresso() {
        this.extraShot = false;
        this.macchiato = false;
    }

    public Espresso(String name, double price, String description, boolean extraShot, boolean macchiato) {
        super(name, price, description);
        this.extraShot = extraShot;
        this.macchiato = macchiato;
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isMacchiato() {
        return macchiato;
    }

    public void setMacchiato(boolean macchiato) {
        this.macchiato = macchiato;
    }

    @Override
    public void calculateProductTotal() {
        double totalPrice = getPrice();

        if(extraShot)
            totalPrice += 2;

        if(macchiato)
            totalPrice += 1;

        setSubtotal(getQuantity() * totalPrice);
    }

    @Override
    public void addOptions() {
        extraShot = getUserOption("extra shot");
        macchiato = getUserOption("macchiato");
    }

    @Override
    public void printOptions() {
        System.out.printf("\t\tExtra Shot: %s\tMacchiato: %s \n",
                            (extraShot ? "Yes (Add $2)" : "No"), (macchiato ? "Yes (Add $1)" : "No"));
    }

    @Override
    public Object clone() {
        return new Espresso(this.getName(), this.getPrice(), this.getDescription(), this.extraShot, this.macchiato);
    }
}
