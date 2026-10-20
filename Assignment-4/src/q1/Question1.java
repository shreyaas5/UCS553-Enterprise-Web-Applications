package q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Course {
    private String courseCode;
    private String title;
    private int capacity;
    private HashSet<String> enrolledStudents;
    private ArrayList<String> prerequisites;
    private LinkedList<String> waitlist;

    public Course(String courseCode, String title, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.capacity = capacity;
        this.enrolledStudents = new HashSet<>();
        this.prerequisites = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public HashSet<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    public LinkedList<String> getWaitlist() {
        return waitlist;
    }

    public void addPrerequisite(String prereqCode) {
        prerequisites.add(prereqCode);
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public boolean enrollStudent(String studentId) {
        return enrolledStudents.add(studentId);
    }

    public void addToWaitlist(String studentId) {
        if (!waitlist.contains(studentId)) {
            waitlist.add(studentId);
        }
    }

    public boolean dropStudent(String studentId) {
        return enrolledStudents.remove(studentId);
    }

    public String promoteWaitlistStudent() {
        if (!waitlist.isEmpty()) {
            String nextStudentId = waitlist.removeFirst();
            enrolledStudents.add(nextStudentId);
            return nextStudentId;
        }
        return null;
    }
}

class Student {
    private String studentId;
    private String name;
    private HashSet<String> completedCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.completedCourses = new HashSet<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public HashSet<String> getCompletedCourses() {
        return completedCourses;
    }

    public void addCompletedCourse(String courseCode) {
        completedCourses.add(courseCode);
    }

    public boolean hasCompleted(String courseCode) {
        return completedCourses.contains(courseCode);
    }
}

class CourseRegistrationPortal {
    private HashMap<String, Course> courseMap;
    private HashMap<String, Student> studentMap;

    public CourseRegistrationPortal() {
        courseMap = new HashMap<>();
        studentMap = new HashMap<>();
    }

    public void addCourse(Course course) {
        courseMap.put(course.getCourseCode(), course);
    }

    public void addStudent(Student student) {
        studentMap.put(student.getStudentId(), student);
    }

    public void registerStudent(String studentId, String courseCode) {
        Course course = courseMap.get(courseCode);
        Student student = studentMap.get(studentId);

        if (course == null) {
            System.out.println("Error: Course " + courseCode + " not found.");
            return;
        }
        if (student == null) {
            System.out.println("Error: Student " + studentId + " not found.");
            return;
        }

        if (course.getEnrolledStudents().contains(studentId)) {
            System.out.println("Student " + student.getName() + " (" + studentId + ") is already enrolled in " + courseCode + ".");
            return;
        }

        for (String prereq : course.getPrerequisites()) {
            if (!student.hasCompleted(prereq)) {
                System.out.println("Registration failed for " + student.getName() + ": Missing prerequisite " + prereq + " for " + courseCode + ".");
                return;
            }
        }

        if (!course.isFull()) {
            course.enrollStudent(studentId);
            System.out.println("Enrollment successful: " + student.getName() + " enrolled in " + courseCode + ".");
        } else {
            course.addToWaitlist(studentId);
            int pos = course.getWaitlist().indexOf(studentId) + 1;
            System.out.println("Course " + courseCode + " is full. " + student.getName() + " added to waitlist at position " + pos + ".");
        }
    }

    public void dropStudent(String studentId, String courseCode) {
        Course course = courseMap.get(courseCode);
        Student student = studentMap.get(studentId);

        if (course == null || student == null) {
            System.out.println("Error: Invalid course or student ID.");
            return;
        }

        if (course.dropStudent(studentId)) {
            System.out.println(student.getName() + " dropped " + courseCode + ".");
            String promotedId = course.promoteWaitlistStudent();
            if (promotedId != null) {
                Student promotedStudent = studentMap.get(promotedId);
                String pName = promotedStudent != null ? promotedStudent.getName() : promotedId;
                System.out.println("Waitlist promotion: " + pName + " (" + promotedId + ") is automatically enrolled in " + courseCode + ".");
            }
        } else if (course.getWaitlist().remove(studentId)) {
            System.out.println(student.getName() + " removed from " + courseCode + " waitlist.");
        } else {
            System.out.println("Student " + studentId + " is not registered in " + courseCode + ".");
        }
    }

    public void displayCourse(String courseCode) {
        Course course = courseMap.get(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.println("\nCourse Details: " + course.getCourseCode() + ": " + course.getTitle());
        System.out.println("Capacity: " + course.getCapacity());
        System.out.println("Prerequisites: " + course.getPrerequisites());
        System.out.println("Enrolled Students (" + course.getEnrolledStudents().size() + "/" + course.getCapacity() + "): " + course.getEnrolledStudents());
        System.out.println("Waitlist Queue: " + course.getWaitlist());
    }
}

public class Question1 {
    public static void main(String[] args) {
        System.out.println("=== Course Registration Portal ===");

        CourseRegistrationPortal portal = new CourseRegistrationPortal();

        Course c1 = new Course("CS101", "Introduction to Programming", 3);
        Course c2 = new Course("CS201", "Data Structures", 2);
        c2.addPrerequisite("CS101");

        portal.addCourse(c1);
        portal.addCourse(c2);

        Student s1 = new Student("S101", "Shreyaas");
        s1.addCompletedCourse("CS101");

        Student s2 = new Student("S102", "Rahul");
        s2.addCompletedCourse("CS101");

        Student s3 = new Student("S103", "Aman");

        Student s4 = new Student("S104", "Pooja");
        s4.addCompletedCourse("CS101");

        Student s5 = new Student("S105", "Rohan");
        s5.addCompletedCourse("CS101");

        portal.addStudent(s1);
        portal.addStudent(s2);
        portal.addStudent(s3);
        portal.addStudent(s4);
        portal.addStudent(s5);

        System.out.println("\n1. Registering S101 (Shreyaas) for CS201:");
        portal.registerStudent("S101", "CS201");

        System.out.println("\n2. Registering S103 (Aman) for CS201 (without prerequisite):");
        portal.registerStudent("S103", "CS201");

        System.out.println("\n3. Registering S102 (Rahul) for CS201:");
        portal.registerStudent("S102", "CS201");

        System.out.println("\n4. Registering S104 (Pooja) for CS201 (Course Full):");
        portal.registerStudent("S104", "CS201");

        System.out.println("\n5. Registering S105 (Rohan) for CS201 (Course Full):");
        portal.registerStudent("S105", "CS201");

        portal.displayCourse("CS201");

        System.out.println("\n6. S102 (Rahul) drops CS201:");
        portal.dropStudent("S102", "CS201");

        portal.displayCourse("CS201");
    }
}
