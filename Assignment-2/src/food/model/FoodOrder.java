package food.model;

public abstract class FoodOrder {
    private int orderId;
    private String customerName;
    private double amount;

    public static String restaurantName = "Grill Master";
    private static int totalOrders = 0;

    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        totalOrders++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String name) {
        restaurantName = name;
    }

    public static int getTotalOrders() {
        return totalOrders;
    }

    public static void displayTotalOrders() {
        System.out.println("\nTotal Orders = " + totalOrders);
    }

    public abstract double calculateDeliveryCharge();
}
