package q5;

import java.util.Objects;
import java.util.Optional;

class Utility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Question5 {
    public static void main(String[] args) {
        System.out.println("=== Generic Utility Class Demo ===");

        System.out.println("\n1. Testing isEqual():");
        System.out.println("isEqual(10, 10): " + Utility.isEqual(10, 10));
        System.out.println("isEqual(\"Java\", \"Python\"): " + Utility.isEqual("Java", "Python"));
        System.out.println("isEqual(null, null): " + Utility.isEqual(null, null));

        System.out.println("\n2. Testing getDefault():");
        Optional<String> name = Optional.of("Shreyaas");
        Optional<String> noName = Optional.empty();
        System.out.println("getDefault(name, \"Guest\"): " + Utility.getDefault(name, "Guest"));
        System.out.println("getDefault(noName, \"Guest\"): " + Utility.getDefault(noName, "Guest"));

        Optional<Integer> score = Optional.empty();
        System.out.println("getDefault(score, 0): " + Utility.getDefault(score, 0));

        System.out.println("\n3. Testing max():");
        System.out.println("max(25, 42): " + Utility.max(25, 42));
        System.out.println("max(\"Apple\", \"Banana\"): " + Utility.max("Apple", "Banana"));
        System.out.println("max(3.14, 2.71): " + Utility.max(3.14, 2.71));

        System.out.println("\n4. Testing isNull():");
        String s1 = null;
        String s2 = "Hello";
        System.out.println("isNull(null): " + Utility.isNull(s1));
        System.out.println("isNull(\"Hello\"): " + Utility.isNull(s2));
    }
}
