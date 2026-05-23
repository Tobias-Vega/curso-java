package com.devtalles.proyecto.task.model;

import com.devtalles.proyecto.task.exceptions.TaskException;
import com.devtalles.proyecto.task.persistence.TaskPersistence;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository() {
        try {
            tasks = TaskPersistence.loadTasks();
        } catch (TaskException e) {
            System.err.println("Advertencia: " + e.getMessage());
            tasks = new java.util.ArrayList<>();
        }
    }


    public void save(Task task) throws TaskException {

        if (tasks.contains(task)) {
            throw new TaskException("Ya existe una tarea con el ID: " + task.getId());
        }

        tasks.add(task);
        TaskPersistence.saveTasks(tasks);
    }

    public Task findById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }

        }
            return null;
    }

    public List<Task> findCompletedTasks() {

        List<Task> completedTasks = new ArrayList<>();


        for (Task task : tasks) {
            if (task.getCompleted()) {
                completedTasks.add(task);
            }
        }

        return completedTasks;
    }

    public List<Task> findPendingTasks() {

        List<Task> pendingTasks = new ArrayList<>();


        for (Task task : tasks) {
            if (!task.getCompleted()) {
                pendingTasks.add(task);
            }
        }

        return pendingTasks;
    }

    public void remove(String id) throws TaskException {
        Task task = findById(id);
        if (task == null) {
            throw new TaskException("El ID de la tarea a eliminar no existe");
        }

        tasks.remove(task);
        TaskPersistence.saveTasks(tasks);
    }

    public void remove(Task task) throws TaskException {
        if (task == null) {
            throw new TaskException("La tarea no puede ser nula");
        }

        if(!tasks.remove(task)) {
            throw new TaskException("La tarea no existe en la lista");
        }

        TaskPersistence.saveTasks(tasks);
    }

    public List<Task> findAll() {
        return tasks;
    }
    
    public int findIndexById(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void updateTask(Task updateTask) throws TaskException {

        if (updateTask == null ) {
            throw new TaskException("La tarea no puede ser nula");
        }
        int index = findIndexById(updateTask.getId());

        if (index == -1) {
            throw new TaskException("El ID de la tarea a actualizar no existe");
        }

        tasks.set(index, updateTask);
        TaskPersistence.saveTasks(tasks);
    }

    public void updateTaskCompleted(String id, Boolean completed) throws TaskException {
        int index = findIndexById(id);

        if (index == -1) {
            throw new TaskException("El ID de la tarea a actualizar no existe");
        }
        tasks.get(index).setCompleted(completed);
        TaskPersistence.saveTasks(tasks);
    }


}
