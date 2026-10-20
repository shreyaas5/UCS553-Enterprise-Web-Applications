package q4;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

class Event {
    private String name;
    private LocalDate date;
    private LocalTime startTime;
    private Optional<String> venue;

    public Event(String name, LocalDate date, LocalTime startTime, String venueName) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.venue = Optional.ofNullable(venueName);
    }

    public void displayDetails() {
        System.out.println("Event Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Start Time: " + startTime);
        System.out.println("Venue: " + venue.orElse("Venue not specified"));

        LocalTime endTime = startTime.plusHours(2);
        System.out.println("End Time (2 hours duration): " + endTime);

        LocalDate today = LocalDate.now();
        if (date.isAfter(today)) {
            long daysRemaining = ChronoUnit.DAYS.between(today, date);
            System.out.println("Status: Upcoming event (" + daysRemaining + " days remaining)");
        } else if (date.isBefore(today)) {
            System.out.println("Status: Past event");
        } else {
            System.out.println("Status: Happening today!");
        }
    }
}

public class Question4 {
    public static void main(String[] args) {
        System.out.println("=== Event Management System ===");

        LocalDate futureDate = LocalDate.now().plusDays(15);
        LocalTime startTime = LocalTime.of(10, 0);

        Event e1 = new Event("Tech Symposium", futureDate, startTime, "Auditorium A");
        System.out.println("\nEvent 1:");
        e1.displayDetails();

        LocalDate pastDate = LocalDate.now().minusDays(5);
        LocalTime startPast = LocalTime.of(14, 30);
        Event e2 = new Event("Coding Contest", pastDate, startPast, null);
        System.out.println("\nEvent 2:");
        e2.displayDetails();

        Event e3 = new Event("Web Workshop", LocalDate.now(), LocalTime.of(16, 0), "Lab 3");
        System.out.println("\nEvent 3:");
        e3.displayDetails();
    }
}
