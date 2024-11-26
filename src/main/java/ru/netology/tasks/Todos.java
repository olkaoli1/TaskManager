public class Todos {
    private Task[] tasks = new Task[0]; // Массив для хранения задач

    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        System.arraycopy(current, 0, tmp, 0, current.length);
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    public void add(Task task) {
        tasks = addToArray(tasks, task); // Добавляем задачу в массив
    }

    public Task[] findAll() {
        return tasks; // Возвращаем все задачи
    }

    public Task[] search(String query) {
        Task[] result = new Task[0];
        for (Task task : tasks) {
            if (task.matches(query)) {
                result = addToArray(result, task);
            }
        }
        return result; // Возвращаем массив подходящих задач
    }
}