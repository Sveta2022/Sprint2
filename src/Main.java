/**
 * Для тестирования в классе создано три задачи, два эпика с двуся подзадачами и вызваны все методы из класса Manager.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Начинаем тестировать:");
        //Создаем объекты классов
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
//      2.4 Создание. Сам объект должен передаваться в качестве параметра.
        manager.createTask(task1);
        manager.createTask(task2);
        manager.createTask(task3);
        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);
        manager.createEpic(epic1);
        manager.createSubtask(subtask3);
        manager.createSubtask(subtask4);
        manager.createEpic(epic2);
//      2.1 Получение списка всех задач.
        System.out.println("Получение списка всех задач.");
        manager.printTasks();
        manager.printEpic(epic1);
        manager.printEpic(epic2);
        System.out.println();
//      2.3 Получение по идентификатору.
        System.out.println("Получение по идентификатору.");
        System.out.println(manager.getTaskById(1));
        System.out.println(manager.getSubtasks(epic1));
        System.out.println();
//      2.5 Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра.
        Task task4 = new Task("Новая задача");
        Epic epic3 = new Epic("Новый Эпик1");
        manager.updateTask(1, task4);
        manager.updateEpic(epic1, epic3);
        System.out.println("Получение списка всех задач после обновления.");
        manager.printTasks();
        manager.printEpic(epic1);
        manager.getEpik();
        System.out.println();
//        4. Управление статусами
//        4.1 Статус для задач
        System.out.println("Обновление статуса для задач");
        manager.getStatusTask(task1);
        manager.changeStatusTask(task1);
        manager.getStatusTask(task1);
        manager.changeStatusTask(task1);
        manager.getStatusTask(task1);
        System.out.println();
//      4.2 Статус для эпика
        System.out.println("Обновление статуса для эпика");
        manager.getStatusEpic(epic1);
        manager.changeStatusSubtask(epic1, subtask2);
        System.out.println();
        manager.getStatusEpic(epic1);
        manager.changeStatusSubtask(epic1, subtask1);
        System.out.println();
        manager.getStatusEpic(epic1);
        manager.changeStatusSubtask(epic1, subtask2);
        System.out.println();
        manager.getStatusEpic(epic1);
        manager.changeStatusSubtask(epic1, subtask1);
        System.out.println();
        manager.getStatusEpic(epic1);
        manager.changeStatusSubtask(epic1, subtask2);
        System.out.println();
//      2.6 Удаление по идентификатору.
        manager.removeTaskById(1);
        manager.removeSubtaskById(epic1);
        System.out.println("Список задач после удаления по ид");
        manager.printTasks();
        System.out.println(manager.getEpicLists());
        System.out.println();
//      2.2 Удаление всех задач.
        manager.removeAllTasks();
        manager.removeAllEpics();
        System.out.println("Список задач после удаления");
        manager.printTasks();
        System.out.println(manager.getEpicLists());
        System.out.println();
    }
}
