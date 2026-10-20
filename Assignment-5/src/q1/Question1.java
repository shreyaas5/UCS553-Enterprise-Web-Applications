package q1;

public class Question1 {

    public static <T extends Number> double calculateSum(T[] numbers) {
        double sum = 0.0;
        for (T num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Generic Sum Calculation ===");

        Integer[] intArr = { 10, 20, 30, 40 };
        Float[] floatArr = { 1.5f, 2.5f, 3.5f };
        Double[] doubleArr = { 10.25, 20.75, 30.5 };

        System.out.println("Integer array sum: " + calculateSum(intArr));
        System.out.println("Float array sum: " + calculateSum(floatArr));
        System.out.println("Double array sum: " + calculateSum(doubleArr));
    }
}
