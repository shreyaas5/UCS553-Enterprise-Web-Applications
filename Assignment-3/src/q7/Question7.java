package q7;

import java.util.ArrayList;
import java.util.List;

class ApplicationException extends Exception {
    public ApplicationException(String msg) { super(msg); }
}

class ProductException extends ApplicationException {
    public ProductException(String msg) { super(msg); }
}

class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String msg) { super(msg); }
}

class OutOfStockException extends ProductException {
    public OutOfStockException(String msg) { super(msg); }
}

class PaymentException extends ApplicationException {
    public PaymentException(String msg) { super(msg); }
}

class InvalidPaymentException extends PaymentException {
    public InvalidPaymentException(String msg) { super(msg); }
}

class InsufficientFundsException extends PaymentException {
    public InsufficientFundsException(String msg) { super(msg); }
}

class OrderException extends ApplicationException {
    public OrderException(String msg) { super(msg); }
}

class EmptyCartException extends OrderException {
    public EmptyCartException(String msg) { super(msg); }
}

class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public void reduceStock(int qty) { this.stock -= qty; }
}

class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) throws OutOfStockException {
        if (product.getStock() <= 0) {
            throw new OutOfStockException("Product " + product.getName() + " is out of stock.");
        }
        items.add(product);
        product.reduceStock(1);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public double calculateTotal() throws EmptyCartException {
        if (items.isEmpty()) {
            throw new EmptyCartException("Cannot checkout: Cart is empty.");
        }
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public void clearCart() {
        items.clear();
    }
}

public class Question7 {
    public static Product searchProduct(List<Product> catalog, String id) throws ProductNotFoundException {
        for (Product p : catalog) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        throw new ProductNotFoundException("Product with ID " + id + " not found.");
    }

    public static void processPayment(double total, double balance, String paymentMethod) throws PaymentException {
        if (!paymentMethod.equalsIgnoreCase("CREDIT") && !paymentMethod.equalsIgnoreCase("DEBIT")) {
            throw new InvalidPaymentException("Payment method " + paymentMethod + " is invalid.");
        }
        if (balance < total) {
            throw new InsufficientFundsException("Insufficient funds. Required: " + total + ", Available: " + balance);
        }
        System.out.println("Payment of $" + total + " successful via " + paymentMethod + ".");
    }

    public static void main(String[] args) {
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("P101", "Laptop", 1000.0, 2));
        catalog.add(new Product("P102", "Mouse", 25.0, 0));

        ShoppingCart cart = new ShoppingCart();

        try {
            Product p1 = searchProduct(catalog, "P101");
            cart.addProduct(p1);
            System.out.println("Added " + p1.getName() + " to cart.");

            Product p2 = searchProduct(catalog, "P102");
            cart.addProduct(p2);
        } catch (ProductException e) {
            System.out.println("Product Error: " + e.getMessage());
        }

        try {
            double total = cart.calculateTotal();
            processPayment(total, 500.0, "CREDIT");
        } catch (ApplicationException e) {
            System.out.println("Checkout Error: " + e.getMessage());
        }
    }
}
