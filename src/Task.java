import java.util.Objects;

/**
 * Класс Task является родителем классов Subtask и Epic и хранит списки Задач и Эпиков
 */
public class Task {
    String nameTask;
    String discriptionTask;
    int id;
    String status = new Status().STATUS_IS_NEW_TASK;

    public Task() {
    }

    public Task(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDiscriptionTask() {
        return discriptionTask;
    }

    public void setDiscriptionTask(String discriptionTask) {
        this.discriptionTask = discriptionTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(nameTask, task.nameTask) && Objects.equals(discriptionTask, task.discriptionTask) && Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTask, discriptionTask, id, status);
    }

    @Override
    public String toString() {
        return nameTask;
    }
}
