package ProyectoFinal;

import java.util.Scanner;

public class BankApp {

    BankAccount bankAccount;
    private Scanner scanner;

    public BankApp(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void initApp() {
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            processOption(option);

        } while (option != 4);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nSeleccionar opciones");
        System.out.println("1. Depositar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Mostar saldo");
        System.out.println("4. Salir");
    }

    private void handleDeposit() {
        System.out.println("Ingrese el monto a depositar");
        double depositAmount = scanner.nextDouble();
        bankAccount.depositMoney(depositAmount);
    }

    private void handleWithdraw() {
        System.out.println("Ingrese el monto a extraer");
        double withdrawAmount = scanner.nextDouble();
        this.bankAccount.withdrawMoney(withdrawAmount);
    }

    private void processOption(int option) {
        switch (option) {
            case 1:
                handleDeposit();
                break;
            case 2:
                handleWithdraw();
                break;

            case 3:
                bankAccount.showCurrentSalary();
                break;

            case 4:
                System.out.println("Gracias por utilizar la aplicación. Hasta pronto");
                break;

            default:
                System.out.println("Opción no valida, intentelo nuevamente");
        }
    }
}
