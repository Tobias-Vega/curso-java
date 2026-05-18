package Strings;

public class ExampleString {

    public static void main(String[] args) {

        String name = "Tobías";
        String name2 = "Tobías";

        System.out.println(name == name2);

        String name3 = new String("Tobías");

        System.out.println(name3 == name);

        System.out.println(name.toUpperCase());

        System.out.println(name);

        Person person = new Person("Tobías", "Vega");

        System.out.println(person.toString());

    }
}
