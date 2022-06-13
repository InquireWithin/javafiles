package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Student implements Comparable<Student> {
    private String fname;private String lname;private double gpa;
    public Student(String fname, String lname,double gpa) {
        this.fname = fname; this.lname = lname;this.gpa = gpa;

    }
    @Override
    public String toString() {
        return "name: " + lname+ ", "+fname;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("First", "Student", 3.2));
        students.add(new Student("Second", "Student", 2.4));
        students.add(new Student("Third", "Student", 2.6));
        students.add(new Student("Fourth", "Student", 3.8));
        //lambda to sort in reverse alphabetical order
        Comparator<Student> comp = (Student o1, Student o2) -> {
            return o2.lname.compareTo(o1.lname);
        };
        System.out.println(students);
        //anonymous class to sort in alphabetical order
        students.sort(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.lname.compareTo(o2.lname);
            }
           
        });
        //lambda to sort first names in reverse-alphabetical order
        students.sort((o1,o2) -> o2.fname.compareTo(o1.fname));
        System.out.println(students);

        //sort first names in reverse alphabetical order using a method reference
        students.sort(Student::compareTo);

        //Using streams to get the student list

        students.stream().forEach(e->System.out.println(e.fname+" "+e.lname));
        //use a stream to filter gpa
        //for each element e in the stream of students, print out ofevery element w/ gpa 3.0 or greater
        students.stream().filter(e -> e.gpa >= 3.0).forEach(System.out::println);

    }
    @Override
    public int compareTo(Student o) {
        return fname.compareTo(o.fname);
    }
}

