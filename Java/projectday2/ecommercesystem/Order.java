import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private List<Product> productList;
    private double totalAmount;
    private OrderStatus orderStatus;

    // Constructor
    public Order(int orderId, int customerId, List<Product> productList) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productList = productList;
        this.totalAmount = calculateTotalAmount();
        this.orderStatus = OrderStatus.PENDING; // Initial status
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    // Method to calculate total amount
    private double calculateTotalAmount() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    // Method to update order status
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
