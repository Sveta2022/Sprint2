public class Subtask extends Task {
    private int idSubtask;

    public Subtask(String nameTask) {
        this.nameTask = nameTask;
    }

    public int getIdSubtask() {
        return idSubtask;
    }

    public void setIdSubtask(int idSubtask) {
        this.idSubtask = idSubtask;
    }

    @Override
    public String toString() {
        return nameTask;
    }

}


