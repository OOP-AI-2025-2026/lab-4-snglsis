package ua.opnu.java.inheritance.account;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initial = super.getBalance();
        this.minBalance = initial;
        this.maxBalance = initial;
    }

    @Override
    public void debit(Debit debit) {
        super.debit(debit);
        updateMinMax();
    }

    @Override
    public void credit(Credit credit) {
        super.credit(credit);
        updateMinMax();
    }

    private void updateMinMax() {
        int current = super.getBalance();
        if (current < minBalance) minBalance = current;
        if (current > maxBalance) maxBalance = current;
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
