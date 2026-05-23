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
            System.out.println("5. Salir");
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
                    System.out.println("Saliendo del sistema");
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

            System.out.println("Tarea eliminada correctamente");
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
        } catch (TaskException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado. Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private Task getTaskInput() {
        System.out.println("Ingresar ID: ");
        String id = scanner.nextLine();

        System.out.println("Ingrese el título: ");
        String title = scanner.nextLine();

        System.out.println("Ingresar la descripción: ");
        String description = scanner.nextLine();

        System.out.println("¿Está completada? (true/false): ");
        Boolean completed = Boolean.parseBoolean(scanner.nextLine());

        return new Task(id, title, description, completed);
    }
}
