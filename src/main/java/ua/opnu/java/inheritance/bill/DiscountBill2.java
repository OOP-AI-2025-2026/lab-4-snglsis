package ua.opnu.java.inheritance.bill;

import java.util.List;

public class DiscountBill2 {

    private GroceryBill bill;          // композиція
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item item) {
        bill.add(item); // делегуємо додавання
        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    public double getTotal() {
        double total = bill.getTotal();
        if (regularCustomer) {
            total -= discountAmount;
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        double fullPrice = bill.getTotal();
        if (fullPrice == 0.0) return 0.0;
        double percent = 100.0 - (getTotal() * 100.0 / fullPrice);
        percent = Math.round(percent * 1e13) / 1e13;
        return percent;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }

    public List<Item> getItems() {
        return bill.getItems();
    }
}
