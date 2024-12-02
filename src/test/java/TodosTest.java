package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TodosTest {

    @Test
    public void shouldAddTasksAndFindAll() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");
        Epic epic = new Epic(2, new String[]{"Подготовка", "Сбор данных"});
        Meeting meeting = new Meeting(3, "Совещание", "Проект А");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        List<Task> tasks = todos.findAll();
        Assertions.assertEquals(3, tasks.size());
    }

    @Test
    public void shouldFindMultipleTasksByQuery() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить маме"));
        todos.add(new Epic(2, new String[]{"Позвонить маме", "Сбор данных"}));
        todos.add(new Meeting(3, "Совещание", "Позвонить маме"));

        List<Task> result = todos.search("Позвонить");
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void shouldFindOneTaskByQuery() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить маме"));
        todos.add(new Epic(2, new String[]{"Сбор данных"}));

        List<Task> result = todos.search("Сбор");
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.get(0) instanceof Epic);
    }

    @Test
    public void shouldReturnEmptyListWhenNoMatch() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить маме"));
        todos.add(new Epic(2, new String[]{"Сбор данных"}));

        List<Task> result = todos.search("Ничего");
        Assertions.assertTrue(result.isEmpty());
    }
}
