package com.devtalles.exception.personalizada.unchecked;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new NegativeBalanceException("Fondos insuficientes...");
        }

        balance -= amount;
        System.out.println("Extracción exitosa");
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        BankAccount account = null;

        try {
            account = new BankAccount(500);
            account.withdraw(600);


        } catch (NegativeBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Saldo: " + account.getBalance());

    }
}
