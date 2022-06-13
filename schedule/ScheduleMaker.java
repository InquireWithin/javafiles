package schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
//might need another class for this
public class ScheduleMaker{
    

    //take in a list of all courses offered
    //from these courses, find the one that starts the earliest
    //after that course's end time, select the course with the least difference from its start time
    //to the previous course's end time
    //repeat for every course (where applicable) in the list
    //return this "refined" course list.

    /*
    * This will NOT always return the most optimal result
    */
    private List<Course> list;
    //the course list after schedule creation
    //might be unused due to static
    public List<Course> completedList;
    public ScheduleMaker(List<Course> list) {
        this.list = list;
    }
    public static List<Course> makeSchedule(List<Course> list) {
        //List of previous courses times
        List<Course> selected = new ArrayList<>();
        //sort list
        list = sort(list);
        //will check for conflictions or not, 1 represents a confliction
        int checker = 0;
        for(int i = 0;i<list.size();i++){
            //if the courses selected to be taken list is empty,
            //there is a 0% chance of conflict.
            if(selected.size() == 0) {
                System.out.println("No courses selected yet, no need for conflict check.");
                System.out.println("Adding first course in the list: "+list.get(i));
                selected.add(list.get(i));
            }
            else{

            }
            //iterate through already selected course list
            System.out.println("Length of selected course list: "+ selected.size());
            for(int j = 0;j<selected.size();j++) {
                //filter out potential conflicts
                checker = 0;
                //i's end should be before j's start OR i's start should be AFTER j's end
                /*if(list.get(i).getStart() > selected.get(j).getEnd() || list.get(i).getStart() < selected.get(j).getStart() &&
                list.get(i).getEnd() > selected.get(j).getEnd() ||list.get(i).getEnd()< selected.get(j).getStart())*/
                if(list.get(i).getEnd() <= selected.get(j).getStart() || list.get(i).getStart() >= selected.get(j).getEnd()) {
                    continue;
                    //no conflict found yet, continue to next selected course
                }
                //course conflicts, flag it and exit the loop
                else{checker = 1;System.out.println("Conflict found, go to next course");
                    break;}
            }
            System.out.println("running checker");
            if(checker == 0) {
                System.out.println("adding " + list.get(i) + " to the course schedule");
                selected.add(list.get(i));
            }
        }
        
        return selected;
    }
    //sort them based on course length
    public static List<Course> sort(List<Course> list){
        /*new Comparable<Course>(){
            @Override
            public int compareTo(Course o) {
                if()
            }
        };*/
        Collections.sort (list);
        return list;
    }
    public List<Course> swap(int a, int b, List<Course> list) {
        Course tempB = list.get(b);
        list.set(b, list.get(a));
        list.set(a, tempB);
        return list;
    }
        
    
    public static void main(String[] args) {
        //retrieve an example List of courses to try to make a schedule out of
        List<Course> list = Course.exampleCourses();
        //initialize the schedule maker
        ScheduleMaker sm = new ScheduleMaker(list);
        //use the schedule maker to assemble a solution schedule out of the potential courses to take
        List<Course> schedule = makeSchedule(list);
        //print out schedule
        //essentially a static version of toString
        String str = "Course Name       Start Time      End Time\n";
        for(int i =0;i<schedule.size();i++){
            str += schedule.get(i).getName() + "      " + schedule.get(i).getStart() + "        " + 
            schedule.get(i).getEnd() + "\n";
        }
        System.out.println(str);
    }
}
