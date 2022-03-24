/**
 * Для тестирования в классе создано три задачи, два эпика с двумя подзадачами и вызваны все методы из класса Manager.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Начинаем тестировать:");
        //Создать объекты классов
        Manager manager = new Manager();
        Task task1 = new Task("Задача1");
        Task task2 = new Task("Задача2");
        Task task3 = new Task("Задача3");
        Subtask subtask1 = new Subtask("Подзадача1");
        Subtask subtask2 = new Subtask("Подзадача2");
        Subtask subtask3 = new Subtask("Подзадача3");
        Subtask subtask4 = new Subtask("Подзадача4");
        Epic epic1 = new Epic("Эпик1");
        Epic epic2 = new Epic("Эпик2");
//      2.4 Создать. Сам объект должен передаваться в качестве параметра.
        manager.createTask(task1);
        manager.createTask(task2);
        manager.createTask(task3);
        manager.createEpic(epic1);
        subtask1.setEpicId(epic1.getId());
        subtask2.setEpicId(epic1.getId());
        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);
        manager.createEpic(epic2);
        subtask3.setEpicId(epic2.getId());
        subtask4.setEpicId(epic2.getId());
        manager.createSubtask(subtask3);
        manager.createSubtask(subtask4);
//      2.1 Получить список всех задач.
        System.out.println("Получить список всех задач.");
        manager.printTasks();
        manager.printEpic();
        System.out.println();
//      2.3 Получить по идентификатору.
        System.out.println("Получить по идентификатору.");
        System.out.println(manager.getTaskById(task2.id));
        System.out.println(manager.getEpicById(epic1.id));
        System.out.println(manager.getSubtaskId(subtask2.id));
        System.out.println();
//      2.5 Обновить. Новая версия объекта с верным идентификатором передаются в виде параметра.
        Task task4 = new Task("Новая задача1");
        manager.updateTask(task1.id, task4);
        Epic epic3 = new Epic("Новый Эпик1");
        manager.updateEpic(epic1.getId(), epic3);
        Subtask subtask5 = new Subtask("Подзадача новая2");
        manager.updateSubtask(subtask2.getId(), subtask5);
        System.out.println("Получить список всех задач после обновления.");
        manager.printTasks();
        manager.printEpic();
        System.out.println();
//      4. Управление статусами
//      4.1 Статус для задач
        System.out.println("Обновить статус для задач");
        manager.getStatusTask(task1);
        manager.changeStatusTask(task1);
        manager.getStatusTask(task1);
        manager.changeStatusTask(task1);
        manager.getStatusTask(task1);
        System.out.println();
//      4.2 Статус для эпика
        System.out.println("Обновить статус для эпика");
        manager.getStatusEpic(epic1);
        manager.changeStatusSubtask(subtask5);
        System.out.println();
        manager.getStatusEpic(epic3);
        manager.changeStatusSubtask(subtask5);
        System.out.println();
        manager.getStatusEpic(epic3);
        manager.changeStatusSubtask(subtask1);
        System.out.println();
        manager.getStatusEpic(epic3);
        manager.changeStatusSubtask(subtask1);
        System.out.println();
        manager.getStatusEpic(epic3);
        manager.changeStatusSubtask(subtask1);
        System.out.println();
//      2.6 Удалить по идентификатору.
        manager.removeTaskById(task1.getId());
        manager.removeSubtaskById(subtask3.id);
        manager.removeEpicById(epic1.getId());
        System.out.println("Список задач после удаления по ид");
        manager.printTasks();
        System.out.println(manager.getEpicLists());
        System.out.println();
//      2.2 Удалить все задачи.
        manager.removeAllTasks();
        manager.removeAllEpics();
        System.out.println("Список задач после удаления");
        manager.printTasks();
        System.out.println(manager.getEpicLists());
        System.out.println();
    }
}
