package q3;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter operator (+, -, *, /): ");
            String op = scanner.nextLine();
            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
                throw new IllegalArgumentException("Invalid operator entered.");
            }
            if (op.equals("/") && num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }

            double result = 0;
            switch (op) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
            }
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numeric input.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
