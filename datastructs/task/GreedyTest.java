package task;
import java.util.List;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.ArrayList;
import java.util.HashSet;
@Testable
public class GreedyTest {
         @Test
         public void testAlgorithm() {
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
            List<Task> expectedList = new ArrayList<>();
            expectedList.add(new Task(1, "onehourtask1"));
            expectedList.add(new Task(1, "onehourtask2"));
            expectedList.add(new Task(2, "two hour task1"));
            boolean isTrue = true;
            for(int i =0;i<expectedList.size();i++){
                if(expectedList.get(i).getHours()!=minimizedTasks.get(i).getHours()){
                    isTrue = false;
                    break;
                }
            }
            assert(isTrue);
    }
         }
        

