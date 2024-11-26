public class Meeting extends Task {
    protected String topic; // Тема встречи
    protected String project; // Название проекта
    protected String start; // Время начала

    public Meeting(int id, String topic, String project, String start) {
        super(id); // Вызываем конструктор родительского класса
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic; // Геттер для темы
    }

    public String getProject() {
        return project; // Геттер для проекта
    }

    public String getStart() {
        return start; // Геттер для времени начала
    }

    @Override
    public boolean matches(String query) {
        // Проверяем, содержится ли запрос в теме или проекте
        return topic.contains(query) || project.contains(query);
    }
}
