package javacore.less_9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {

    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("a");
        courses.add("a");
        courses.add("b");
        Student student = new Student("a", courses);
        List<Student> students = new ArrayList<>();
        students.add(student);
        System.out.println(student.uniqueCourses(students));

        Student stud1 = new Student("Виктор", Arrays.asList("Math", "Chemistry"));
        Student stud2 = new Student("Андрей", Arrays.asList("Math", "History"));
        Student stud3 = new Student("Юлия", Arrays.asList("Music", "History", "English"));

        Stream<Student> studentStream = Stream.of(stud1, stud2, stud3);

        Set<String> uniqueSubjects = studentStream
                .flatMap(st -> st.getCourses().stream()
                        .map(subj -> new AbstractMap.SimpleEntry<>(st.getName(), subj)))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println(uniqueSubjects);
        studentStream = Stream.of(stud1, stud2, stud3);

        List<String> studentsStudyingUniqueSubjects = studentStream
                .filter(stud -> stud.getCourses().stream()
                        .anyMatch(uniqueSubjects::contains))
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(studentsStudyingUniqueSubjects);
    }

    private String name; // имя
    private List<String> courses; //список   предметов


    public List<String> getCourses() {
        return courses;
    }

    public Set<String> uniqueCourses(List<Student> students) {
        return students.stream().flatMap(student -> student.getCourses().stream())
                .collect(Collectors.toSet());
    }

    public Student(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    private String getName() {
        return name;
    }

}
