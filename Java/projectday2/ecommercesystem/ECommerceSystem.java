import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    private List<Product> products;
    private List<Customer> customers;
    private List<Order> orders;
    private int nextOrderId;

    // Constructor
    public ECommerceSystem() {
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.nextOrderId = 1;
    }

    // Method to add a product to inventory
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to remove a product from inventory
    public void removeProduct(int productId) throws ProductNotFoundException {
        Product productToRemove = findProduct(productId);
        if (productToRemove != null) {
            products.remove(productToRemove);
        } else {
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }
    }

    // Method to find a product by productId
    private Product findProduct(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    // Method to register a new customer
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to place an order
    public void placeOrder(int customerId, List<Integer> productIds)
            throws CustomerNotFoundException, InsufficientStockException {
        Customer customer = findCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
        }

        List<Product> orderedProducts = new ArrayList<>();
        double totalAmount = 0;

        // Validate products and calculate total amount
        for (int productId : productIds) {
            Product product = findProduct(productId);
            if (product == null) {
                throw new ProductNotFoundException("Product with ID " + productId + " not found.");
            }
            if (product.getStock() <= 0) {
                throw new InsufficientStockException("Product " + product.getName() + " is out of stock.");
            }
            orderedProducts.add(product);
            totalAmount += product.getPrice();
        }

        // Create order
        Order order = new Order(nextOrderId++, customerId, orderedProducts);
        orders.add(order);
        customer.addOrder(order);

        // Update product stocks
        for (Product product : orderedProducts) {
            product.setStock(product.getStock() - 1);
        }
    }

    // Method to update order status
    public void updateOrderStatus(int orderId, OrderStatus status) throws OrderNotFoundException {
        Order orderToUpdate = findOrder(orderId);
        if (orderToUpdate != null) {
            orderToUpdate.setOrderStatus(status);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
        }
    }

    // Method to list all products
    public List<Product> listAllProducts() {
        return products;
    }

    // Method to list all customers
    public List<Customer> listAllCustomers() {
        return customers;
    }

    // Method to list all orders for a customer
    public List<Order> listOrdersForCustomer(int customerId) throws CustomerNotFoundException {
        Customer customer = findCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
        }
        return customer.getOrders();
    }

    // Method to find a customer by customerId
    private Customer findCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    // Method to find an order by orderId
    private Order findOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}
