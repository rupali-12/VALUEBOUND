import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage of ECommerceSystem class
        ECommerceSystem ecommerceSystem = new ECommerceSystem();

        // Adding products
        Product product1 = new Product(1, "Laptop", 999.99, 10);
        Product product2 = new Product(2, "Mouse", 19.99, 50);
        ecommerceSystem.addProduct(product1);
        ecommerceSystem.addProduct(product2);

        // Registering customers
        Customer customer1 = new Customer(1, "John Doe");
        Customer customer2 = new Customer(2, "Jane Smith");
        ecommerceSystem.registerCustomer(customer1);
        ecommerceSystem.registerCustomer(customer2);

        // Placing orders
        List<Integer> productIds = Arrays.asList(1, 2);
        try {
            ecommerceSystem.placeOrder(1, productIds); // Customer 1 places an order
        } catch (CustomerNotFoundException | ProductNotFoundException | InsufficientStockException e) {
            e.printStackTrace();
        }

        // Updating order status
        try {
            ecommerceSystem.updateOrderStatus(1, OrderStatus.SHIPPED);
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
        }

        // Listing all products, customers, and orders
        System.out.println("Products: " + ecommerceSystem.listAllProducts());
        System.out.println("Customers: " + ecommerceSystem.listAllCustomers());
        try {
            System.out.println("Orders for Customer 1: " + ecommerceSystem.listOrdersForCustomer(1));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }
    }
}
