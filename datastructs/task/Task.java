package task;
public class Task {
    private Integer hours;
    private String name;
    public Task(Integer hours, String name){
        this.hours=hours;this.name=name;
    }
    public Integer getHours() {
        return hours;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Task: "+name +"(" + hours + ")";
    }  
}
