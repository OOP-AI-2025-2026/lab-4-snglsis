package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item item) {
        super.add(item);
        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
        if (regularCustomer) {
            total -= discountAmount;
        }
        return Math.round(total * 100.0) / 100.0; // округлюємо до сотих
    }


    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        double fullPrice = super.getTotal(); // без знижок
        if (fullPrice == 0.0) return 0.0;
        return (discountAmount * 100.0) / fullPrice;
    }

}
