import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();

    }

    public void createAccount(String accountNumber, String accountHolder, double balance) {
        Account account = new Account(accountNumber, accountHolder, balance);
        accounts.add(account);
        System.out.println("Account created for " + accountHolder);
    }

    public void deposit(double amount, String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("Deposited " + amount + " to " + accountNumber);
                return;
            }
        }
        System.out.println("Account not Found");
    }

    public void withdraw(double amount, String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getBalance() >= amount) {
                    account.setBalance(account.getBalance() + amount);
                    System.out.println("Withdraw " + amount + " from " + accountNumber);
                    return;
                } else {
                    System.out.println("Insufficient Balance");
                }
            }
            return;
        }
        System.out.println("Account not Found");
    }

    public void deleteAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                System.out.println("Account with " + accountNumber + " has been deleted");
            }
        }
        System.out.println("Account not Found");
    }

    public void displayAccountDetails(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println(account);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void displayAllAccountDetails() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
