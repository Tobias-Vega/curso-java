package ProyectoFinal;

public class BankAccount {

    private String accountHolder;
    private double balance;


    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void depositMoney(double money) {
        if (money <= 0) {
            System.out.println("El monto no puede ser negativo");
            return;
        }

        this.balance += money;
        System.out.println("Depósito realizado correctamente");
    }

    public void withdrawMoney(double money) {

        if (money <= 0) {
            System.out.println("El monto no puede ser negativo");
            return;
        }

        if (money > this.balance) {
            System.out.println("Fondos insuficientes");
            return;
        }

        this.balance -= money;
        System.out.println("Extracción realizada exitosamente");

    }

    public void showCurrentSalary() {
        System.out.println("El salario del titular " + this.accountHolder +" actual es: $ " + this.balance);
    }
}
