// src/services/CustomerService.java

package services;

import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void updateCustomer(int index, Customer customer) {
        if (index >= 0 && index < customers.size()) {
            customers.set(index, customer);
        }
    }

    public void deleteCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            customers.remove(index);
        }
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    public Customer searchCustomerByMobileNumber(String mobileNumber) {
        for (Customer customer : customers) {
            if (customer.getMobileNumber().equals(mobileNumber)) {
                return customer;
            }
        }
        return null;
    }
}

