package ru.netology.tasks;

import java.util.ArrayList;
import java.util.List;

public class Todos {
    private List<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public List<Task> findAll() {
        return tasks;
    }

    public List<Task> search(String query) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.matches(query)) {
                result.add(task);
            }
        }
        return result;
    }
}
