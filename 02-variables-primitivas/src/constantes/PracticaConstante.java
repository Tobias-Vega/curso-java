package constantes;

public class PracticaConstante {
    public static void main(String[] args) {
        int workDays = 10;
        workDays = 20;
        workDays = 30;

        final double ANNUAL_INTEREST_RATE = 0.05;

        final double TAX_RATE = 0.10;
        int grossSalary = 3000;
        double netSalary = grossSalary * (1 - TAX_RATE);
        System.out.println("netSalary = " + netSalary);
    }
}
