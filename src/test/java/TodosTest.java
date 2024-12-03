package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Task[] tasks = todos.findAll();
        Task[] expected = {simpleTask, epic, meeting};

        Assertions.assertArrayEquals(expected, tasks);
    }

    @Test
    public void shouldFindMultipleTasksByQuery() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");
        Epic epic = new Epic(2, new String[]{"Позвонить маме", "Сбор данных"});
        Meeting meeting = new Meeting(3, "Совещание", "Позвонить маме");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Позвонить");
        Task[] expected = {simpleTask, epic, meeting};

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindOneTaskByQuery() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");
        Epic epic = new Epic(2, new String[]{"Сбор данных"});

        todos.add(simpleTask);
        todos.add(epic);

        Task[] result = todos.search("Сбор");
        Task[] expected = {epic};

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMatch() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");
        Epic epic = new Epic(2, new String[]{"Сбор данных"});

        todos.add(simpleTask);
        todos.add(epic);

        Task[] result = todos.search("Ничего");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, result);
    }
}
