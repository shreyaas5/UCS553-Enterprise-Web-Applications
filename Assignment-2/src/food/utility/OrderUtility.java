package food.utility;

import food.model.FoodOrder;
import food.service.Discountable;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static void generateSummary(FoodOrder order) {
        double discount = 0.0;
        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }
        double delivery = order.calculateDeliveryCharge();
        double finalAmount = order.getAmount() - discount + delivery;

        System.out.println("--------------------------------");
        System.out.println("Restaurant : " + FoodOrder.restaurantName);
        System.out.println("Order ID   : " + order.getOrderId());
        System.out.println("Customer   : " + order.getCustomerName());
        System.out.println("Bill       : Rs. " + order.getAmount());
        System.out.println("Discount   : Rs. " + discount);
        System.out.println("Delivery   : Rs. " + delivery);
        System.out.println("Final Bill : Rs. " + finalAmount);
    }
}
