package prototype;

// Prototype interface
interface DataStructure extends Cloneable {
    void process(); // Example method for processing data structures

    DataStructure clone();
}

// Concrete Prototype: UserRecord
class UserRecord implements DataStructure {
    private String username;
    private String email;

    public UserRecord(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public void process() {
        System.out.println("Processing User Record: " + username + ", " + email);
        // Additional processing logic can be added here
    }

    @Override
    public DataStructure clone() {
        return new UserRecord(this.username, this.email);
    }
}

// Concrete Prototype: TransactionRecord
class TransactionRecord implements DataStructure {
    private int transactionId;
    private double amount;

    public TransactionRecord(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    @Override
    public void process() {
        System.out.println("Processing Transaction Record: " + transactionId + ", " + amount);
        // Additional processing logic can be added here
    }

    @Override
    public DataStructure clone() {
        return new TransactionRecord(this.transactionId, this.amount);
    }
}

public class Prototype_problem_3 {
    public static void main(String[] args) {
        // Create original data structures
        DataStructure originalUserRecord = new UserRecord("john_doe", "john.doe@example.com");
        DataStructure originalTransactionRecord = new TransactionRecord(1001, 500.0);

        // Clone data structures
        DataStructure clonedUserRecord = originalUserRecord.clone();
        DataStructure clonedTransactionRecord = originalTransactionRecord.clone();

        // Process original and cloned data structures
        originalUserRecord.process(); // Output: Processing User Record: john_doe, john.doe@example.com
        clonedUserRecord.process(); // Output: Processing User Record: john_doe, john.doe@example.com

        originalTransactionRecord.process(); // Output: Processing Transaction Record: 1001, 500.0
        clonedTransactionRecord.process(); // Output: Processing Transaction Record: 1001, 500.0
    }
}
