package ec.com.mz.mediatordemo;

public abstract class Task {
    private IMediator mediator;
    private TaskStatus taskStatus;
    private Integer order;

    public Task(IMediator mediator, TaskStatus taskStatus, Integer order) {
        this.mediator = mediator;
        this.taskStatus = taskStatus;
        this.order = order;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public Integer getOrder(){
        return order;
    }

    public void execute(){
        System.out.println( "Executing: " + this.getClass() + "... Completed");
        System.out.print("Changing status from " + taskStatus + " to " + TaskStatus.COMPLETADO + "..." );
        taskStatus = TaskStatus.COMPLETADO;
        System.out.println("Completed");
        System.out.println("Notify to mediator...");
        mediator.notify(this);
    }
}
