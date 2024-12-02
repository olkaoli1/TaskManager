package ru.netology.tasks;

public class Meeting extends Task {
    private String topic;
    private String project;

    public Meeting(int id, String topic, String project) {
        super(id);
        this.topic = topic;
        this.project = project;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    @Override
    public boolean matches(String query) {
        return topic.contains(query) || project.contains(query);
    }
}
