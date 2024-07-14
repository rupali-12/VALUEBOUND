// src/patterns/Builder.java

package patterns;

import models.Customer;

public class CustomerBuilder {
    private String name;
    private String mobileNumber;
    private String email;
    private String address;

    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Customer build() {
        return new Customer(name, mobileNumber, email, address);
    }
}
