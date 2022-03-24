import java.util.HashMap;
import java.util.ArrayList;
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
        taskList.put(task.getId(), new Task(task.nameTask));
        return task;
    }

    // 1.2 - создать Задачу с подзадачей;
    public Subtask createSubtask(Subtask subtask) {
        ++idgeneratot;
        subtask.setIdSubtask(idgeneratot);
        subtaskList.put(idgeneratot, new Subtask(subtask.nameTask));
        return subtask;
    }

    public Epic createEpic(Epic epic) {
        ArrayList<Subtask> subtasks1 = new ArrayList<>();
        for (int id : subtaskList.keySet()
        ) {
            subtasks1.add(subtaskList.get(id));
        }
        ++idgeneratot;
        epic.setId(idgeneratot);
        epic.setSubtasks(subtasks1);
        epicLists.put(epic.id, new Epic(epic.nameTask));
        subtaskList = new HashMap<>();
        return epic;
    }
    // 2 - Получение списка всех задач

    public ArrayList<Task> getTaskList() {
        ArrayList<Task> task = new ArrayList<>();
        for (int id : taskList.keySet()
        ) {
            Task nameTask = taskList.get(id);
            task.add(nameTask);
        }
        return task;
    }

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

    public void printEpic(Epic epic) {
        if (epic.subtasks.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println(epic);
        }
    }

    public ArrayList<Epic> getEpik() {
        return new ArrayList<>(epicLists.values());
    }

    // 3 - Удаление всех задач
    public void removeAllTasks() {
        taskList.clear();
    }

    public void removeAllEpics() {
        epicLists.clear();
    }

    //4 - Получение по идентификатору
    public Task getTaskById(int id) {
        Task task = taskList.get(id);
        return task;
    }

    // 5 - Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
    public void updateTask(int id, Task task) {
        taskList.put(id, task);
    }

    public void updateEpic(Epic epic1, Epic epic2) {
        int id = epic1.getId();
        epic1.setNameTask(epic2.getNameTask());
    }
    // 6 - Удаление по идентификатору

    public void removeTaskById(int id) {
        taskList.remove(id);
    }

    public void removeSubtaskById(Epic epic) {
        epicLists.remove(epic.getId());
    }

    public void getStatusTask(Task task) {
        System.out.println(task.getStatus());
    }

    public void changeStatusTask(Task task) {
        if (task.status == Status.IN_PROGRESS) {
            task.setStatus(Status.DONE);
        } else if (task.status == Status.STATUS_IS_NEW_TASK) {
            task.setStatus(Status.IN_PROGRESS);
        } else {
            task.setStatus(Status.DONE);
        }
    }

    public ArrayList<Subtask> getSubtasks(Epic epic) {
        ArrayList<Subtask> subtasks = epic.getSubtasks();
        return subtasks;
    }

    public void getStatusEpic(Epic epic) {
        System.out.println(epic.nameTask + " - " + epic.getStatus() + ": ");
        ArrayList<Subtask> subtasks = epic.getSubtasks();
        for (Subtask subtask : subtasks) {
            System.out.println(subtask + " - " + subtask.getStatus());
        }
    }

    public void changeStatusSubtask(Epic epic, Subtask subtask1) {
        int count = 0;
        for (Subtask subtask : epic.getSubtasks()) {
            if (subtask.getNameTask() == subtask1.getNameTask()) {
                changeStatusTask(subtask);
                if (epic.status == Status.STATUS_IS_NEW_TASK) {
                    changeStatusTask(epic);
                }
            }
            if (epic.status == Status.IN_PROGRESS) {
                if (subtask.getStatus() == Status.DONE) {
                    count++;
                }
            }
        }
        if (count == epic.subtasks.size()) {
            epic.setStatus(Status.DONE);
        }
    }

    public HashMap<Integer, Epic> getEpicLists() {
        return epicLists;
    }
}

