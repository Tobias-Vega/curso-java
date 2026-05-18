package relaciones;

public class Person {
    public void calculatorSum(Calculator calculator) {
        int result = calculator.add(5, 3);
        System.out.println("Suma = " + result);
    }
}
