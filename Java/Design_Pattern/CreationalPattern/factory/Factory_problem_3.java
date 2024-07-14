// Abstract Product: Payment
interface Payment {
    void process();
}

// Concrete Products: CreditCardPayment, PayPalPayment, CryptocurrencyPayment
class CreditCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing credit card payment");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing PayPal payment");
    }
}

class CryptocurrencyPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing cryptocurrency payment");
    }
}

// Factory Method Interface: PaymentFactory
interface PaymentFactory {
    Payment createPayment();
}

// Concrete Factories: CreditCardPaymentFactory, PayPalPaymentFactory,
// CryptocurrencyPaymentFactory
class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}

class CryptocurrencyPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CryptocurrencyPayment();
    }
}

// Client Code
public class Factory_problem_3 {
    public static void main(String[] args) {
        // Create a credit card payment using CreditCardPaymentFactory
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        Payment creditCardPayment = creditCardFactory.createPayment();
        creditCardPayment.process();

        System.out.println();

        // Create a PayPal payment using PayPalPaymentFactory
        PaymentFactory paypalFactory = new PayPalPaymentFactory();
        Payment paypalPayment = paypalFactory.createPayment();
        paypalPayment.process();

        System.out.println();

        // Create a cryptocurrency payment using CryptocurrencyPaymentFactory
        PaymentFactory cryptoFactory = new CryptocurrencyPaymentFactory();
        Payment cryptocurrencyPayment = cryptoFactory.createPayment();
        cryptocurrencyPayment.process();
    }
}
