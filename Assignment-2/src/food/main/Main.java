package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;

public class Main {
    public static void main(String[] args) {
        FoodOrder[] orders = {
            new RegularOrder(101, "Aarav Sharma", 500.0),
            new PremiumOrder(102, "Bhavna Patel", 800.0),
            new RegularOrder(103, "Chirag Verma", 400.0),
            new PremiumOrder(104, "Divya Kapoor", 1000.0),
            new RegularOrder(105, "Eshan Gupta", 600.0),
            new PremiumOrder(106, "Farhan Khan", 900.0)
        };

        for (FoodOrder order : orders) {
            if (OrderUtility.validateAmount(order.getAmount()) &&
                OrderUtility.validateCustomerName(order.getCustomerName())) {
                OrderUtility.generateSummary(order);
            } else {
                System.out.println("Invalid Order: " + order.getOrderId());
            }
        }

        FoodOrder.displayTotalOrders();
    }
}
