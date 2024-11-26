public class Epic extends Task {
    protected String[] subtasks; // Массив подзадач

    public Epic(int id, String[] subtasks) {
        super(id); // Вызываем конструктор родительского класса
        this.subtasks = subtasks; // Присваиваем массив подзадач
    }

    public String[] getSubtasks() {
        return subtasks; // Геттер для подзадач
    }

    @Override
    public boolean matches(String query) {
        // Проверяем, содержится ли запрос в одной из подзадач
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
