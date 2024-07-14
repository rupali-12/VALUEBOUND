package patterns;

public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        // Implement payment with PayPal
        System.out.println("Paid " + amount + " using PayPal.");
    }
}