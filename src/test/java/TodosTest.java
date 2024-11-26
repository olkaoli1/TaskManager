import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");
        String[] subtasks = {"Купить хлеб", "Купить молоко"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Проект А", "Завтра в 10:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksByQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить маме");
        String[] subtasks = {"Купить хлеб", "Купить молоко"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Проект А", "Завтра в 10:00");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Купить");

        Assertions.assertArrayEquals(expected, actual);
    }
}