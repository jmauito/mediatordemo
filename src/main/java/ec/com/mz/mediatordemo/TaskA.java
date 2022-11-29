package ec.com.mz.mediatordemo;

public class TaskA extends Task{
    public TaskA(IMediator mediator, TaskStatus taskStatus, Integer order) {
        super(mediator, taskStatus, order);
    }
}
