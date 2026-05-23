package com.devtalles.proyecto.task.controller;

import com.devtalles.proyecto.task.exceptions.TaskException;
import com.devtalles.proyecto.task.exceptions.TaskValidationException;
import com.devtalles.proyecto.task.model.Task;
import com.devtalles.proyecto.task.model.TaskRepository;

import java.util.List;
import java.util.TreeSet;

public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String id, String title, String description, Boolean completed) throws TaskException, TaskValidationException {
        validateTaskData(id, title, description, completed);
        Task task = new Task(id, title, description,completed);

        this.taskRepository.save(task);
    }

    public void removeTask(String id) throws TaskValidationException, TaskException {
        if (id == null || id.trim().isEmpty()) {
            throw new TaskValidationException("El id no puede estar vacío");
        }
        this.taskRepository.remove(id);
    }

    public List<Task> showTasks() {
        return this.taskRepository.findAll();
    }

    public List<Task> showCompletedTasks() {
        return this.taskRepository.findCompletedTasks();
    }

    public List<Task> showPendingTasks() {
        return this.taskRepository.findPendingTasks();
    }

    public void updateTask(String id, String title, String description, Boolean completed) throws TaskException, TaskValidationException {
        validateTaskData(id, title, description, completed);

        Task updatedTask = new Task(id, title, description, completed);

        this.taskRepository.updateTask(updatedTask);
    }

    public void updateTaskCompleted(String id, Boolean completed) throws TaskException, TaskValidationException {
        validateTaskData(id, completed);
        this.taskRepository.updateTaskCompleted(id, completed);
    }

    private void validateTaskData(String id, String title, String description, Boolean completed) throws TaskValidationException {
        if (id == null || id.trim().isEmpty()) {
            throw new TaskValidationException("El id no puede estar vacío");
        }

        if (title == null || title.trim().isEmpty()) {
            throw new TaskValidationException("El título no puede estar vacío");

        }

        if (description == null || description.trim().isEmpty()) {
            throw new TaskValidationException("La descripción no puede estar vacío");

        }

        if (completed == null) {
            throw new TaskValidationException("El estado no puede ser nulo");

        }
    }

    private void validateTaskData(String id, Boolean completed) throws TaskValidationException {
        if (id == null || id.trim().isEmpty()) {
            throw new TaskValidationException("El id no puede estar vacío");
        }

        if (completed == null) {
            throw new TaskValidationException("El estado no puede ser nulo");

        }
    }
}
