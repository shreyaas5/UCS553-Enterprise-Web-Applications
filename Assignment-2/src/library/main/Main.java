package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.Printable;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = {
            new Book(1, "Operating System Concepts", "Silberschatz"),
            new DigitalResource(2, "Data Structures and Algorithms PDF", "Cormen"),
            new Book(3, "Computer Networks", "Andrew Tanenbaum"),
            new DigitalResource(4, "Java: The Complete Reference E-Book", "Herbert Schildt"),
            new Book(5, "Database System Concepts", "Korth")
        };

        int[] overdueDays = {3, 5, 2, 0, 4};
        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {
            if (InputValidator.validateResourceId(resources[i].getResourceId())
                    && InputValidator.validateFineDays(overdueDays[i])) {

                ((Printable) resources[i]).printDetails();

                double fine = resources[i].calculateFine(overdueDays[i]);
                System.out.println("Overdue Days: " + overdueDays[i]);
                System.out.println("Fine        : Rs. " + fine);

                totalFine += fine;
            } else {
                System.out.println("Invalid resource data at index " + i);
            }
        }

        System.out.println("\n--------------------------------");
        System.out.println("Library Name : " + LibraryResource.libraryName);
        System.out.println("Total Fine   : Rs. " + totalFine);
        LibraryResource.displayTotalResources();
    }
}
