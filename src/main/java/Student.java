// Java program to demonstrate working of Comparator
// interface

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// A class to represent a student.
class Student {
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name,
                   String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()
    public String toString() {
        return this.rollno + " " + this.name +
                " " + this.address;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

class Sortbyroll implements Comparator<Student> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}

class Sortbyname implements Comparator<Student> {
    // Used for sorting in ascending order of
    // roll name
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

// Driver class
class Main {
    public static void sortByRollNo(List<Student> students) {
        Collections.sort(students, Comparator.comparingInt(Student::getRollno).reversed());
    }

    public static void sortByName(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getName).thenComparingInt(Student::getRollno).reversed());
    }

    public static void main(String[] args) {
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(115,"bbbb", "canada"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        //sortByRollNo(ar);
        //Collections.sort(ar, new Sortbyroll());

//        System.out.println("\nSorted by rollno");
//        for (int i = 0; i < ar.size(); i++)
//            System.out.println(ar.get(i));

        //sortByName(ar);

        //Collections.sort(ar, (s1, s2) -> s2.name.compareTo(s1.name));
        Collections.sort(ar, Comparator.comparingInt(Student::getRollno).reversed());
        //Collections.sort(ar, new Sortbyname());

        System.out.println("\nSorted list");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}

