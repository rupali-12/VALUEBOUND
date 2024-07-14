package singleton;
class PaymentGatewayConnectionManager {
    private static PaymentGatewayConnectionManager instance;
    private static final Object lock = new Object();
    private boolean isConnected;

    private PaymentGatewayConnectionManager() {
        isConnected = false;
    }

    public static PaymentGatewayConnectionManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new PaymentGatewayConnectionManager();
                }
            }
        }
        return instance;
    }

    // Method to open a connection to the payment gateway
    public void openConnection() {
        if (!isConnected) {
            System.out.println("Opening connection to the payment gateway...");
            isConnected = true;
        } else {
            System.out.println("System is already Open");
        }
    }

    // Method to maintain the connection (dummy method for illustration)
    public void maintainConnection() {
        if (isConnected) {
            System.out.println("Maintaining connection...");
        } else {
            System.out.println("No connection to maintain.");
        }
    }

    // Method to close connection
    public void closeConnection() {
        if (isConnected) {
            System.out.println("Closing connection to the payment gateway...");
            isConnected = false;
        } else {
            System.out.println("No connection to close.");
        }
    }
}

public class SingletonProblem_2 {
    public static void main(String[] args) {
        PaymentGatewayConnectionManager manager1 = PaymentGatewayConnectionManager.getInstance();
        manager1.openConnection(); // open connection
        manager1.maintainConnection(); // maintaing coonection

        PaymentGatewayConnectionManager manager2 = PaymentGatewayConnectionManager.getInstance();
        manager2.openConnection(); // already open
        manager2.maintainConnection(); // no connection to maintain

        manager1.closeConnection(); // close connection
        manager2.closeConnection(); // no connection to close

        System.out.println(manager1 == manager2); // true
    }
}
