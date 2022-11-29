package ec.com.mz.mediatordemo;

import java.util.ArrayList;
import java.util.List;

public class Procedure  implements IMediator{
    List<Task> tasks;
    List<Task> currentTasks;

    public void addTasks(List<Task> tasks){
        this.tasks = tasks;
    }

    public void execute(){
        if(currentTasks == null){
            initialize();
        }
        for(Task task : currentTasks){
            task.execute();
        }
    }

    private void initialize(){
        Integer firstOrder = 0;
        currentTasks = getNextTasks(firstOrder);
    }
    @Override
    public void notify(Task task) {
        if (task.getTaskStatus() == TaskStatus.COMPLETADO){
            int orderTask = task.getOrder();
            currentTasks = getNextTasks(orderTask);
        }
    }

    private List<Task> getNextTasks(int orderTask){
        Integer nextOrder = orderTask + 1;
        List<Task> nextTasks = new ArrayList<Task>();
        for(Task task: tasks){
            if(task.getOrder() == nextOrder) nextTasks.add(task);
        }
        return nextTasks;
    }


}
