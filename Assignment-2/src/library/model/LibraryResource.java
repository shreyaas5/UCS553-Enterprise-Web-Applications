package library.model;

public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;

    public static String libraryName = "Nava Nalanda Library";
    private static int totalResources = 0;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResources++;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public static int getTotalResources() {
        return totalResources;
    }

    public static void displayTotalResources() {
        System.out.println("\nTotal Resources = " + totalResources);
    }

    protected void showBasicDetails() {
        System.out.println("Resource ID : " + resourceId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
    }

    public abstract double calculateFine(int overdueDays);
}
