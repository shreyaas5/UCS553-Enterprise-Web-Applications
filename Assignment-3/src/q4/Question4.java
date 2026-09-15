package q4;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class Question4 {
    public static void validateAndProcess(double[] marks) throws InvalidMarksException {
        double total = 0;
        for (double mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarksException("Invalid mark: " + mark + ". Marks must be between 0 and 100.");
            }
            total += mark;
        }
        double percentage = total / marks.length;
        String grade;
        if (percentage >= 90) grade = "A";
        else if (percentage >= 75) grade = "B";
        else if (percentage >= 50) grade = "C";
        else grade = "F";

        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        double[] validMarks = { 85.5, 90.0, 78.0 };
        double[] invalidMarks = { 85.5, 105.0, 78.0 };

        System.out.println("Processing valid marks:");
        try {
            validateAndProcess(validMarks);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProcessing invalid marks:");
        try {
            validateAndProcess(invalidMarks);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
