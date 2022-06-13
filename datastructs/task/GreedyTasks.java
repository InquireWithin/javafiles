package task;
import java.util.ArrayList;
import java.util.List;

public class GreedyTasks {
    private static List<Task> tasks;
    private static Integer maxTime;

    public GreedyTasks(List<Task> tasks,Integer maxTime){
        this.tasks=tasks;this.maxTime=maxTime;
    }
    /**
     * This is a greedy algorithm because it is intended to be a quick and efficient 
     * "one-size fits all algorithm". The downside of this comes in the form of not being able
     * to find the most optimal solution in all cases
     * The situation tested in main doesn't even find the optimal solution.
     * 
     * @param taskList
     * @return
     */
    public static List<Task> greedyAlgorithm(List<Task> taskList) {
        List<Task> selectedTasks = new ArrayList<>();
        int min = maxTime+1;;
        int currentTime = 0;
        Task minTask = new Task(0, "");
        while(currentTime < maxTime){
            //System.out.println("Checking next task avaliable....");
            min = maxTime+1;
        
        for(Task t: taskList){
            if (t.getHours() < min && currentTime + t.getHours() <= maxTime){
                System.out.println("New min task spotted: "+t);
                min = t.getHours();
                minTask = t; 
            }
        }
        if(min == maxTime+1){break;}
        selectedTasks.add(minTask);
        System.out.println("chosen task:" + minTask);
        taskList.remove(minTask);
        currentTime += minTask.getHours();
        System.out.println("current time: "+currentTime);
    }
        
        return selectedTasks;
    }
        public static void main(String[] args) {
            List<Task> tasks = new ArrayList<>();
            List<Task> minimizedTasks = new ArrayList<>();
            tasks.add(new Task(1, "onehourtask1"));
            tasks.add(new Task(3, "threehourtask1"));
            tasks.add(new Task(4, "fourhourtask1"));
            tasks.add(new Task(1, "onehourtask2"));
            tasks.add(new Task(2, "two hour task1"));
            tasks.add(new Task(3,"threehourtask2"));
            GreedyTasks gt = new GreedyTasks(tasks, 6);
            minimizedTasks =gt.greedyAlgorithm(tasks);
            for(Task t:minimizedTasks){
                System.out.println(t.toString());
            }
    }
    }

