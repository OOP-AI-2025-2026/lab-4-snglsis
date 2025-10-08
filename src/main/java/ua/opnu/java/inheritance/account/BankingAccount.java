package ua.opnu.java.inheritance.account;

public class BankingAccount {
    private int balance;

    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalance();
    }

    public void debit(Debit debit) {
        balance += debit.getAmount(); // дебет додає до балансу
    }

    public void credit(Credit credit) {
        balance += credit.getAmount(); // кредит додає до балансу
    }

    public int getBalance() {
        return balance;
    }
}
