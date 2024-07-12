import java.time.LocalDate;

public class InsuranceClaim {
    private String claimNumber;
    private InsurancePolicy policy;
    private LocalDate claimDate;
    private double claimAmount;
    private String status;

    public InsuranceClaim(String claimNumber, InsurancePolicy policy, LocalDate claimDate, double claimAmount,
            String status) {
        this.claimNumber = claimNumber;
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.status = status;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public InsurancePolicy getPolicy() {
        return policy;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "InsuranceClaim{" +
                "claimNumber='" + claimNumber + '\'' +
                ", policy=" + policy +
                ", claimDate=" + claimDate +
                ", claimAmount=" + claimAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
