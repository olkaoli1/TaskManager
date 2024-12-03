package ru.netology.tasks;

import java.util.ArrayList;

public class Todos {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public Task[] findAll() {
        return tasks.toArray(new Task[0]);
    }

    public Task[] search(String query) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.matches(query)) {
                result.add(task);
            }
        }
        return result.toArray(new Task[0]);
    }
}
