import java.time.LocalDate;

public class InsurancePolicy {
    private String policyNumber;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, Customer customer, Vehicle vehicle, LocalDate startDate,
            LocalDate endDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}
