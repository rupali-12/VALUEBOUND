package patterns;
import models.Customer;
public class CustomerOriginator {
    private Customer customer;

    public void set(Customer customer) {
        this.customer = customer;
    }

    public Customer get() {
        return customer;
    }

    public CustomerMemento saveToMemento() {
        return new CustomerMemento(customer);
    }

    public void restoreFromMemento(CustomerMemento memento) {
        customer = new Customer(memento.getName(), memento.getMobileNumber(), memento.getEmail(), memento.getAddress());
    }
}
