package com.devtalles.proyecto.task.view;

import com.devtalles.proyecto.task.controller.TaskController;
import com.devtalles.proyecto.task.exceptions.TaskException;
import com.devtalles.proyecto.task.exceptions.TaskValidationException;
import com.devtalles.proyecto.task.model.Task;

import java.util.List;
import java.util.Scanner;

public class TaskView {
    private final TaskController taskController;
    private final Scanner scanner;

    public TaskView(TaskController taskController) {
        this.taskController = taskController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nGestión de Tareas");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Eliminar Tarea");
            System.out.println("3. Actualizar Tarea");
            System.out.println("4. Mostrar Tareas");
            System.out.println("5. Actualizar estado de la Tarea");
            System.out.println("6. Mostrar Tareas completadas");
            System.out.println("7. Mostrar Tareas pendientes");
            System.out.println("8. Salir");
            System.out.println("Seleccione una opción");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    addTaskView();
                    break;
                case "2":
                    removeTaskView();
                    break;
                case "3":
                    updateTaskView();
                    break;
                case "4":
                    showTasksView();
                    break;
                case "5":
                    updateTaskCompletedView();
                    break;
                case "6":
                    showCompletedTaskView();
                    break;
                case "7":
                    showPendingTaskView();
                    break;
                case "8":
                    System.out.println("Saliendo del sistema");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no valida, intente nuevamente");
            }
        }
    }

    private void addTaskView() {

        try {
            Task task = getTaskInput();
            taskController.addTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());
            System.out.println("Tarea agregada correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private void removeTaskView() {

        try {
            System.out.println("Ingrese el id a eliminar");
            String id = scanner.nextLine();

            taskController.removeTask(id);

            System.out.println("Tarea eliminada correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private void showTasksView() {
        try {
            System.out.println("\nLista de tareas");
            List<Task> tasks = taskController.showTasks();

            if (tasks.isEmpty()) {
                System.out.println("Lista de tareas vacía");
                return;
            }

            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private void updateTaskView() {

        try {
            Task task = getTaskInput();
            taskController.updateTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());
            System.out.println("Tarea actualizada correctamente");
        } catch (TaskException | TaskValidationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private void updateTaskCompletedView() {

        try {
            System.out.println("Ingrese el id de la tarea");
            String id = scanner.nextLine();
            Boolean completed = null;

            while (completed == null) {
                System.out.println("¿Está completada? (true/false): ");
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("true")) {
                    completed = true;
                } else if (input.equals("false")) {
                    completed = false;
                } else {
                    System.out.println("El valor ingresado no es correcto, ingrese 'true' o 'false'");
                }
            }
            taskController.updateTaskCompleted(id, completed);
            System.out.println("Estado de la tarea actualizada correctamente");
        } catch (TaskException | TaskValidationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private void showCompletedTaskView() {
        try {
            System.out.println("\n Lista de tareas competadas");
            List<Task> tasks = taskController.showCompletedTasks();

            if (tasks.isEmpty()) {
                System.out.println("No hay tareas completadas");
                return;
            }

            for (Task task : tasks) {
                System.out.println(task.toString());
            }


        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private void showPendingTaskView() {
        try {
            System.out.println("\n Lista de tareas pendientes");
            List<Task> tasks = taskController.showPendingTasks();

            if (tasks.isEmpty()) {
                System.out.println("No hay tareas pendientes");
                return;
            }

            for (Task task : tasks) {
                System.out.println(task.toString());
            }


        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private Task getTaskInput() {

        String id;
        String title;
        String description;
        Boolean completed = null;

        do {
            System.out.println("Ingresar ID: ");
            id = scanner.nextLine();

            if (id.isEmpty()) {
                System.out.println("El id no puede estar vacío");
            }

        } while (id.isEmpty());

        do {
            System.out.println("Ingresar el título: ");
            title = scanner.nextLine();

            if (title.isEmpty()) {
                System.out.println("El título no puede estar vacío");
            }

        } while (title.isEmpty());

        do {
            System.out.println("Ingresar la descripción: ");
            description = scanner.nextLine();

            if (description.isEmpty()) {
                System.out.println("La descripción no puede estar vacía");
            }

        } while (description.isEmpty());

        while (completed == null) {
            System.out.println("¿Está completada? (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true")) {
                completed = true;
            } else if (input.equals("false")) {
                completed = false;
            } else {
                System.out.println("El valor ingresado no es correcto, ingrese 'true' o 'false'");
            }
        }

        return new Task(id, title, description, completed);
    }
}
