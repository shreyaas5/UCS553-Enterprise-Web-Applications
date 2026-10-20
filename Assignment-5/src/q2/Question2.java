package q2;

import java.util.Optional;

public class Question2 {

    public static void main(String[] args) {
        System.out.println("=== Student Email with Optional ===");

        Optional<String> email = Optional.of("shreyaas@thapar.edu");
        Optional<String> emptyEmail = Optional.empty();

        System.out.print("1. Using ifPresent(): ");
        email.ifPresent(e -> System.out.println("Student Email: " + e));

        System.out.print("2. Using ifPresent() on empty: ");
        emptyEmail.ifPresent(e -> System.out.println("Student Email: " + e));
        System.out.println("(No output because email is empty)");

        System.out.println("3. Using orElse() on present email: " + email.orElse("notfound@thapar.edu"));
        System.out.println("4. Using orElse() on empty email: " + emptyEmail.orElse("default@thapar.edu"));

        System.out.println("5. Using orElseThrow():");
        try {
            String val = email.orElseThrow(() -> new IllegalArgumentException("Email is not available"));
            System.out.println("Present value: " + val);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            String val = emptyEmail.orElseThrow(() -> new IllegalArgumentException("Email address is missing"));
            System.out.println("Empty value: " + val);
        } catch (Exception e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
