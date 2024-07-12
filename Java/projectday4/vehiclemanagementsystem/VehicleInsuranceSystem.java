import java.util.*;

public class VehicleInsuranceSystem {
    private List<Customer> customers = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<InsurancePolicy> policies = new ArrayList<>();
    private List<InsuranceClaim> claims = new ArrayList<>();

    // Add Customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer);
    }

    // Add Vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
    }

    // Add Insurance Policy
    public void addPolicy(InsurancePolicy policy) {
        policies.add(policy);
        System.out.println("Policy added: " + policy);
    }

    // Add Insurance Claim
    public void addClaim(InsuranceClaim claim) {
        claims.add(claim);
        System.out.println("Claim added: " + claim);
    }

    // Find Customer by ID
    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    // Find Vehicle by Registration Number
    public Vehicle findVehicleByRegNumber(String regNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNumber().equals(regNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    // Find Policy by Policy Number
    public InsurancePolicy findPolicyByNumber(String policyNumber) {
        for (InsurancePolicy policy : policies) {
            if (policy.getPolicyNumber().equals(policyNumber)) {
                return policy;
            }
        }
        return null;
    }

    // Find Claim by Claim Number
    public InsuranceClaim findClaimByNumber(String claimNumber) {
        for (InsuranceClaim claim : claims) {
            if (claim.getClaimNumber().equals(claimNumber)) {
                return claim;
            }
        }
        return null;
    }

    // Print all Customers
    public void printAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Print all Vehicles
    public void printAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Print all Policies
    public void printAllPolicies() {
        for (InsurancePolicy policy : policies) {
            System.out.println(policy);
        }
    }

    // Print all Claims
    public void printAllClaims() {
        for (InsuranceClaim claim : claims) {
            System.out.println(claim);
        }
    }
}
