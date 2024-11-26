public class SimpleTask extends Task {
    protected String title; // Название задачи

    public SimpleTask(int id, String title) {
        super(id); // Вызываем конструктор родительского класса
        this.title = title; // Присваиваем название задачи
    }

    public String getTitle() {
        return title; // Геттер для названия задачи
    }

    @Override
    public boolean matches(String query) {
        // Проверяем, содержится ли запрос в названии задачи
        return title.contains(query);
    }
}
