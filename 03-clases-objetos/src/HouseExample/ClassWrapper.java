package HouseExample;

public class ClassWrapper {
    public static void main(String[] args) {
        int number = 10;
        Integer number2 = Integer.valueOf(30);

        System.out.println(number2);

        if (true) {
            // Solo es accesible dentro de este contexto o scope
            Double size = 30.0;
        }
    }
}
