package ua.opnu.java.inheritance.bill;

public class Item {
    private String name;
    private double price;
    private double discount; // знижка у гривнях

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }
}
