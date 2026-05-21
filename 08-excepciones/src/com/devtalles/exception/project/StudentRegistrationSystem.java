package com.devtalles.exception.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentRegistrationSystem {

    private List<Student> students;
    private Scanner scanner;

    public StudentRegistrationSystem() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        StudentRegistrationSystem system = new StudentRegistrationSystem();
            system.initApp();
    }

    public void initApp() {
        int option = 0;
        System.out.println("Bienvenido al Sistema de Registro de Estudiantes");
        do {
            displayMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
                showOptions(option);

            } catch (NumberFormatException e) {
                System.out.println("Error de formate: Por favor ingrese un número válido para la opción");;
            } catch (DuplicateStudentException | StudentNotFoundException e) {
                System.out.println("Error de operación: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error de validación: " + e.getMessage());
            }

        } while (option != 4);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Eliminar estudiante");
        System.out.println("3. Mostrar todos los estudiantes");
        System.out.println("4. Salir");
    }

    private void showOptions(int option) throws DuplicateStudentException, StudentNotFoundException {
        switch (option) {
            case 1:
                System.out.println("Nombre: ");
                String name = scanner.nextLine();

                System.out.println("Edad: ");
                Integer age = Integer.parseInt(scanner.nextLine());

                System.out.println("ID (formato: A12345): ");
                String id = scanner.nextLine();

                registerStudent(name, age, id);
                break;
            case 2:
                System.out.println("ID del estudiante a eliminar: ");
                id = scanner.next();
                removeStudent(id);
                break;
            case 3:
                getAllStudents();
                break;
            case 4:
                System.out.println("Programa finalizado");
                break;
            default:
                System.out.println("Opción no valida. Inténtelo nuevamente");
        }
    }

    private void registerStudent(String name, Integer age, String id) throws DuplicateStudentException {

        validateStudentData(name, age, id);
        if (isStudentRegistered(id)) {
            throw new DuplicateStudentException("El estudiante que intenta registrar ya existe");
        }
        
        this.students.add(new Student(name, age, id));
        System.out.println("Usuario registrado correctamente");
    }
    
    private boolean isStudentRegistered(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private void validateStudentData(String name, Integer age, String id) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El id no puede estar vacío");
        }

        if (age < 17 || age > 100)  {
            throw new IllegalArgumentException("La edad tiene que estar entre 17 a 100 años");
        }

        if (!id.matches("^[A-Z]\\d{5}$")) {
            throw new IllegalArgumentException("El id no cumple con un id de estudiante");
        }
    }

    private void removeStudent(String id) throws StudentNotFoundException {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El id no puede estar vacío");
        }

        Iterator<Student> iterator = students.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                System.out.println("El estudiante fue eliminado correctamente");
                found = true;
                break;
            }

            if (!found) {
                throw new StudentNotFoundException("El estudiante no existe");
            }
        }
    }

    private void getAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
