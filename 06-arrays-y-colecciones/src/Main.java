import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[] numbersPrimitive = new int[5];

        numbersPrimitive[0] = 10;
        numbersPrimitive[1] = 20;

        int[] newNumbers = new int[numbersPrimitive.length + 1];
        System.arraycopy(numbersPrimitive, 0, newNumbers, 0, numbersPrimitive.length);
        newNumbers[5] = 500;

        Integer[] numbersWrapper = new Integer[5];
        numbersWrapper[0] = 30;
        numbersWrapper[1] = null;

        System.out.println("Tipo int");
        for (int number: newNumbers) {
            System.out.println(number);
        }

        System.out.println("Tipo Integer");
        for (Integer number : numbersWrapper) {
            System.out.println(number);
        }
    }
}
