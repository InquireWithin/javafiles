package schedule;

import java.util.Arrays;
import java.util.List;
public class Course implements Comparable<Course>{
    private final String name;
    private final int start;
    private final int end;

        public Course(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
    public static List<Course> exampleCourses() {
        return Arrays.asList(
            new Course("Art", 10, 14),
            new Course("Calculus", 9, 11),
            new Course("Physics", 10, 12),
            new Course("Programming", 8, 10),
            new Course("Design Patterns", 10, 11),
            new Course("Wines of the World", 12, 13),
            new Course("Intro to Engineering", 13, 15),
            new Course("Software Construction", 11, 13),
            new Course("Advanced OO Programming", 14, 16),
            new Course("Economics", 15, 17),
            new Course("Senior Project", 17, 18)
        );
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public String getName() {
        return name;
    }

    
    public int duration() {
        return end - start;
    }
    
    @Override
    public String toString() {
        return name + "(" + start + "-" + end + ")";
    }

    @Override
    public int compareTo(Course o) {
        return (this.end - this.start) - (o.getEnd() - o.getStart());
    }
}
