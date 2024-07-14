// src/patterns/Memento.java

package patterns;

import models.Customer;

public class CustomerMemento {
    private final String name;
    private final String mobileNumber;
    private final String email;
    private final String address;

    public CustomerMemento(Customer customer) {
        this.name = customer.getName();
        this.mobileNumber = customer.getMobileNumber();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

