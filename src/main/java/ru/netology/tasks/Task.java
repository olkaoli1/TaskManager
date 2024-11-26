import java.util.Objects;

public class Task {
    protected int id; // Уникальный идентификатор задачи

    public Task(int id) {
        this.id = id; // Присваиваем ID через конструктор
    }

    public int getId() {
        return id; // Геттер для ID
    }

    // Переопределяем equals для корректного сравнения задач
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    // Переопределяем hashCode для работы с коллекциями
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Метод matches проверяет, подходит ли задача под запрос
    public boolean matches(String query) {
        return false; // Переопределяется в наследниках
    }
}
