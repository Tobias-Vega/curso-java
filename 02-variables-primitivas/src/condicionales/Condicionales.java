package condicionales;

public class Condicionales {
    public static void main(String[] args) {
        int age = 10;

        if (age > 18) {
            System.out.println("Es mayor a 18");
        } else if (age < 0) {
            System.out.println("No es válido");
        } else {
            System.out.println("Es menor a 18");
        }

        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            default:
                System.out.println("El dato ingresado no es válido");
        }
    }
}
