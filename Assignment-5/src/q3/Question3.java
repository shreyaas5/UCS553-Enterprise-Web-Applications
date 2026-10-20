package q3;

import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {
    private String studentName;
    private T[] marks;

    public Result(String studentName, T[] marks) {
        this.studentName = Objects.requireNonNull(studentName, "Student name cannot be null");
        this.marks = Objects.requireNonNull(marks, "Marks array cannot be null");
    }

    public double calculateAverage() {
        if (marks.length == 0) return 0.0;
        double total = 0.0;
        for (T mark : marks) {
            total += mark.doubleValue();
        }
        return total / marks.length;
    }

    public boolean isPassed(double threshold) {
        return calculateAverage() >= threshold;
    }

    public void displayResult(double threshold) {
        Optional<T[]> optionalMarks = Optional.ofNullable(marks);
        if (optionalMarks.isPresent()) {
            double avg = calculateAverage();
            boolean passed = isPassed(threshold);
            System.out.println("Student: " + studentName);
            System.out.print("Marks: ");
            for (T m : marks) {
                System.out.print(m + " ");
            }
            System.out.println();
            System.out.println("Average: " + avg);
            System.out.println("Status: " + (passed ? "Passed" : "Failed"));
        } else {
            System.out.println("Marks not available for student: " + studentName);
        }
    }
}

public class Question3 {
    public static void main(String[] args) {
        System.out.println("=== Student Result with Generics ===");

        Integer[] intMarks = { 85, 90, 78, 88 };
        Result<Integer> r1 = new Result<>("Shreyaas", intMarks);
        r1.displayResult(50.0);

        System.out.println();
        Double[] doubleMarks = { 45.5, 48.0, 42.5 };
        Result<Double> r2 = new Result<>("Aman", doubleMarks);
        r2.displayResult(50.0);

        System.out.println("\nTesting Objects.requireNonNull():");
        try {
            new Result<Integer>(null, intMarks);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        try {
            new Result<Integer>("Rahul", null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}
