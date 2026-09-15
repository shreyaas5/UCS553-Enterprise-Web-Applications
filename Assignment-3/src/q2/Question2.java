package q2;

public class Question2 {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try block started.");
            try {
                System.out.println("Inner try block started.");
                int res = 50 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: ArithmeticException caught -> " + e.getMessage());
            }
            int[] arr = new int[2];
            arr[10] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: ArrayIndexOutOfBoundsException caught -> " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Outer catch: General Exception caught.");
        }
        System.out.println("Execution finished.");
    }
}
