import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс Менеджер управляет всеми задачами
 */

public class Manager {
    private static int idgeneratot = 0;
    HashMap<Integer, Task> taskList = new HashMap<>();
    HashMap<Integer, Subtask> subtaskList = new HashMap<>();
    HashMap<Integer, Epic> epicLists = new HashMap<>();

    // 1.1 - создать задачу;
    public Task createTask(Task task) {
        ++idgeneratot;
        task.setId(idgeneratot);
        taskList.put(task.getId(), task);
        return task;
    }

    // 1.2 - создать Задачу с подзадачей;
    public Subtask createSubtask(Subtask subtask) {
        ++idgeneratot;
        subtask.setId(idgeneratot);
        subtaskList.put(idgeneratot, subtask);
        final Epic epic = epicLists.get(subtask.getEpicId());
        epic.subtasks.add(subtask);
        return subtask;
    }

    public Epic createEpic(Epic epic) {
        ++idgeneratot;
        epic.setId(idgeneratot);
        epicLists.put(epic.id, epic);
        return epic;
    }

    // 2 - Полученить список всех задач
    public void printTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (int id : taskList.keySet()
            ) {
                String name = taskList.get(id).nameTask;
                System.out.println(id + ". " + name);
            }
        }
    }

    //  2.1 Печать списка всех Эпиков
    public void printEpic() {
        if (epicLists.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println(epicLists);
        }
    }

    // 3 - Удаленить все задач
    public void removeAllTasks() {
        taskList.clear();
    }

    public void removeAllEpics() {
        subtaskList.clear();
        epicLists.clear();
    }

    //4 - Получить задачи по идентификатору
    public Task getTaskById(int id) {
        Task task = taskList.get(id);
        return task;
    }

    public Subtask getSubtaskId(int id) {
        Subtask subtask = subtaskList.get(id);
        return subtask;
    }

    public Epic getEpicById(int id) {
        Epic epic = epicLists.get(id);
        return epic;
    }

    // 5 - Обновить. Новая версия объекта с верным идентификатором передаются в виде параметра.
    public void updateTask(int id, Task task) {
        taskList.put(id, task);
    }

    public void updateSubtask(int id, Subtask subtask) {
        Subtask subtask1 = subtaskList.get(id);
        int idEpic = subtask1.getEpicId();
        Epic epic = epicLists.get(idEpic);
        subtask.setEpicId(subtask1.getEpicId());
        subtask.setDiscriptionTask(subtask1.getDiscriptionTask());
        subtask.setStatus(subtask1.getStatus());
        subtask.setId(subtask1.getId());
        epic.subtasks.remove(subtask1);
        epic.subtasks.add(subtask);
        epicLists.put(idEpic, epic);
    }

    public void updateEpic(int id, Epic epic2) {
        Epic epic = epicLists.get(id);
        epic2.setSubtasks(epic.getSubtasks());
        epic2.setStatus(epic.getStatus());
        epic2.setDiscriptionTask(epic.getDiscriptionTask());
        epicLists.put(id, epic2);
    }

    // 6 - Удаленить по идентификатору
    public void removeTaskById(int id) {
        taskList.remove(id);
    }

    public void removeSubtaskById(int id) {
        Subtask subtask1 = subtaskList.get(id);
        int idEpic = subtask1.getEpicId();
        Epic epic = epicLists.get(idEpic);
        epic.subtasks.remove(subtask1);
        epic.subtasks.remove(subtask1);
    }

    public void removeEpicById(int id) {
        Epic epic = epicLists.get(id);
        epicLists.remove(id);
        for (Subtask subtask : epic.subtasks) {
            if (subtask.getEpicId() == id) {
                epic.getSubtasks().remove(epic);
            }
        }
    }

    //  4.1 Получить статус Задачи
    public void getStatusTask(Task task) {

        System.out.println(task.getStatus());
    }

    //   4.2 Изменить статус Подзадачи
    public void changeStatusTask(Task task) {
        if (task.status == Status.IN_PROGRESS) {
            task.setStatus(Status.DONE);
        } else if (task.status == Status.STATUS_IS_NEW_TASK) {
            task.setStatus(Status.IN_PROGRESS);
        } else {
            task.setStatus(Status.DONE);
        }
    }

    public void changeStatusSubtask(Subtask subtask) {
        if (subtask.status == Status.IN_PROGRESS) {
            subtask.setStatus(Status.DONE);
        } else if (subtask.status == Status.STATUS_IS_NEW_TASK) {
            subtask.setStatus(Status.IN_PROGRESS);
        } else {
            subtask.setStatus(Status.DONE);
        }
        Epic epic = epicLists.get(subtask.getEpicId());
        changeStatusEpic(epic);
    }

    //  4.3 Получить статус Эпика
    public void getStatusEpic(Epic epic) {
        System.out.println(epic.nameTask + " - " + epic.getStatus() + ": ");
        ArrayList<Subtask> subtasks = epic.getSubtasks();
        for (Subtask subtask : subtasks) {
            System.out.println(subtask + " - " + subtask.getStatus());
        }
    }

    //  4.4 Изменить статус Эпика
    private void changeStatusEpic(Epic epic) {
        int count = 0;
        for (Subtask subtask : epic.getSubtasks()) {
            if (epic.subtasks == null) {
                epic.setStatus(Status.STATUS_IS_NEW_TASK);
            } else if (subtask.getStatus() == Status.IN_PROGRESS) {
                epic.setStatus(Status.IN_PROGRESS);
            } else if (subtask.getStatus() == Status.DONE) {
                count++;
            }
            if (count == epic.subtasks.size()) {
                epic.setStatus(Status.DONE);
            }
        }
    }

    public HashMap<Integer, Epic> getEpicLists() {
        return epicLists;
    }
}

