package com.devtalles.proyecto.task.model;

import com.devtalles.proyecto.task.exceptions.TaskException;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public void save(Task task) throws TaskException {
        if (task == null) {
            throw new TaskException("La tarea no puede ser nula");
        }

        if (findById(task.getId()) != null) {
            throw new TaskException("Ya existe una tarea con el ID: " + task.getId());
        }

        tasks.add(task);
    }

    public Task findById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }

        }
            return null;
    }

    public void remove(String id) throws TaskException {
        Task task = findById(id);
        if (task == null) {
            throw new TaskException("El ID de la tarea a eliminar no existe");
        }

        tasks.remove(task);
    }

    public void remove(Task task) throws TaskException {
        if (task == null) {
            throw new TaskException("La tarea no puede ser nula");
        }

        if(!tasks.remove(task)) {
            throw new TaskException("La tarea no existe en la lista");
        }
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
    }
}
