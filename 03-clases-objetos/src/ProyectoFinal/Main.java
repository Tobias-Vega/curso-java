package ProyectoFinal;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Tobías Vega", 3000.0);

        BankApp bankApp = new BankApp(bankAccount);

        bankApp.initApp();
    }
}
